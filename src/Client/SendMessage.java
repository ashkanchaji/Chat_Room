package Client;

import Main.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

class SendMessage implements Runnable {
    private Scanner scanner;
    private String name;
    public SendMessage(Scanner scanner, String name) {
        this.scanner = scanner;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            do {
                String nextline = scanner.nextLine();
                if(nextline.equals("/exit"))
                    exit(0);
                System.out.flush();
                Socket socket = new Socket("127.0.0.1", 60001);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(new Message(name, nextline));
                outputStream.close();
                socket.close();
            }
            while (true);
        } catch (UnknownHostException e) {
            System.out.println("server unreachalbe!");
        } catch (IOException e) {
            System.out.println("an error occurd!");
        }
    }
}
