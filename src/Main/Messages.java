package Main;

import java.util.ArrayList;

public class Messages {
    private final static ArrayList<Message> messages = new ArrayList<>();
    synchronized public static void addMessage(Message message){
        messages.add(message);
    }
    synchronized public static ArrayList<Message> getAllMessage(){
        return messages;
    }
    public static int lastId(){
        if(messages.size() == 0)
            return 0;
        return messages.get(messages.size()-1).getId();
    }
    public static void addAll(ArrayList<Message> messages){
        Messages.messages.addAll(messages);
    }
}
