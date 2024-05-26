package Client;

import Main.Message;
import Main.Messages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

class Update implements Runnable {
    @Override
    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 60000);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ArrayList<Message> messages = (ArrayList<Message>) inputStream.readObject();
            Messages.addAll(messages);
            int lastId = -1;
            for (Message message : messages) {
                if(message.getId() > Client.getLastId())
                    System.out.println(message.getAuhtor() + " : " + message.getMessage());
                lastId = message.getId();
            }
            Client.setLastId(lastId);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
