import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args){
        ExecutorService pool = Executors.newCachedThreadPool();
        try {
            ServerSocket serverSocket = new ServerSocket(60000);
            while (true) {
                Socket connectionSocket = serverSocket.accept();

            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket connectionSocket;
    private String clientName;

    public ClientHandler(Socket connectionSocket, String clientName) {
        this.connectionSocket = connectionSocket;
        this.clientName = clientName;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(connectionSocket.getInputStream());
            byte[] buffer = new byte[2048];

            Message clientMessage;



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}