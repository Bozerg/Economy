package Networking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

/**
 * Created by Graham on 1/31/2016.
 */
public final class ServerConnection {

    //url:bozerg.ddns.net port:9030
    private static ServerConnection instance;

    private static final String HOST = "localhost";//"bozerg.ddns.net";
    private static final int PORT = 9030;

    public static ServerConnection getInstance(){
        if (instance == null){
            instance = new ServerConnection();
        }
        return instance;
    }

    private URL getServerUrl(){
        try{
            return new URL("bozerg.ddns.net");
        }catch(MalformedURLException me)
        {
            me.printStackTrace();//Fix-me: Log this
            return null;
        }
        catch (IOException e){
            e.printStackTrace();//Fix-me: Log this
            return null;
        }
    }

    private ServerConnection(){}

    public BufferedReader getConnection(){
        try {
            Socket s = new Socket(HOST, PORT);
            InputStreamReader input = new InputStreamReader(s.getInputStream());
            return new BufferedReader(input);
        }catch(IOException ioe){
            ioe.printStackTrace();//Fix-me: Log this
            return null;
        }
    }
}
