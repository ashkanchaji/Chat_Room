package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SendSocket implements Runnable {
    @Override
    public void run() {
        ExecutorService pool = Executors.newCachedThreadPool();
        try {
            ServerSocket serverSocketGet = new ServerSocket(60000);
            while (true) {
                Socket connectionSocket = serverSocketGet.accept();
                pool.execute(new SendM(connectionSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
