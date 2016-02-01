package org.commonNetworking;

/**
 * Created by Graham on 1/31/2016.
 */
public abstract class Message {
    public String name;
    public EMessageType type;
    public String body;

    public Message(String name, EMessageType type, String body){
        this.name = name;
        this.type = type;
        this.body = body;
    }
}
