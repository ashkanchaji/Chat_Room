package Server;

import Main.Messages;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

class SendM implements Runnable {
    private Socket connectionSocket;
    private String person;

    public SendM(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
            outputStream.writeObject(Messages.getAllMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
