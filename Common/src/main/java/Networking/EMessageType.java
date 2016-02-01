package Networking;

/**
 * Created by Graham on 1/31/2016.
 */
public enum EMessageType {
    WORLD("World"),
    PLAYER("Player");


    private final String messageName;

    EMessageType(String messageName){
        this.messageName=messageName;
    }
}
