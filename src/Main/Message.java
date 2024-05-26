package Main;

import java.io.Serializable;

public class Message implements Serializable {
    private int id;
    private String auhtor;
    private String message;

    public Message(String auhtor, String message) {
        this.id = Messages.lastId() + 1;
        this.auhtor = auhtor;
        this.message = message;
    }

    public String getAuhtor() {
        return auhtor;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
