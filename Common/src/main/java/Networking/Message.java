package Networking;

/**
 * Created by Graham on 1/31/2016.
 */
public abstract class Message {
    public String name;
    public EMessageType type;
    public String message;

    public Message(String name, EMessageType type,String message){
        this.name = name;
        this.type = type;
        this.message = message;
    }
}
