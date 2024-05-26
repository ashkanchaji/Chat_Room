package Client;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private static int lastId;
    public static void main(String[] args) throws InterruptedException {
        lastId = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name : ");
        String name = scanner.nextLine();
        System.out.println("Welcome to Chatromm \n please be polite \n for exit write \"/exit\" ");
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(new SendMessage(scanner,name));
        while(true){
            pool.execute(new Update());
            Thread.sleep(100);
        }
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Client.lastId = lastId;
    }
}

