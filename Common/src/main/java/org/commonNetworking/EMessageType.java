package org.commonNetworking;

/**
 * Created by Graham on 1/31/2016.
 */
public enum EMessageType {
    WORLD("org/commonWorld"),
    PLAYER("org/commonPlayer");


    private final String messageName;

    EMessageType(String messageName){
        this.messageName=messageName;
    }
}
