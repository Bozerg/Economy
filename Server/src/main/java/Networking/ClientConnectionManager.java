package Networking;



/**
 * Created by Graham on 1/31/2016.
 * This class is meant to manage the client connections to the server, as well as initialize
 * any Broadcasters (publishers) that need to publish data to a socket. This is also where we set
 * which sockets/ports/URLs/ etc.
 */
public class ClientConnectionManager {
    private static final String HOST = "bozerg.ddns.net";
    private static final int PORT = 9030;
    private Broadcast broadcaster;

    private static ClientConnectionManager instance;

    public static ClientConnectionManager getInstance(){
        if (instance == null){
            instance = new ClientConnectionManager();
        }
        return instance;
    }

    private ClientConnectionManager(){

    }

}
