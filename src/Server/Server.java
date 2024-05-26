package Server;

import Main.Message;
import Main.Messages;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args){
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(new SendSocket());
        pool.execute(new GetSocket());
        pool.shutdown();
    }
}
