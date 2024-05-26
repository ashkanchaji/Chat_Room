package Server;

import Main.Message;
import Main.Messages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

class GetM implements Runnable {
    private Socket connectionSocket;

    public GetM(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(connectionSocket.getInputStream());
            Message message = (Message) inputStream.readObject();
            message.setId(Messages.lastId()+1);
            Messages.addMessage(message);
            System.out.println(message.getMessage());
            System.out.println("id :+ "+Messages.lastId()+"\tsuccess");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
