package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class GetSocket implements Runnable {
    @Override
    public void run() {
        ExecutorService pool = Executors.newCachedThreadPool();
        try {
            ServerSocket serverSocketGet = new ServerSocket(60001);
            while (true) {
                Socket connectionSocket = serverSocketGet.accept();
                pool.execute(new GetM(connectionSocket));
                System.out.println("connectGet");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
