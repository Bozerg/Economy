package org.networking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

/**
 * Created by Graham on 1/31/2016.
 */
public final class ServerConnection {

    //url:bozerg.ddns.net port:9030
    private static ServerConnection instance;
    private static BufferedReader serverOutputStream;
    private static PrintWriter serverInputStream;
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
        }
        catch(MalformedURLException me){
            me.printStackTrace();//Fix-me: Log this
            return null;
        }
        catch (IOException e){
            e.printStackTrace();//Fix-me: Log this
            return null;
        }
    }

    private ServerConnection(){}

    public BufferedReader getServerOutputStream(){
        try {
            if (serverOutputStream ==null)
            {
                Socket s = new Socket(HOST, PORT);
                InputStreamReader input = new InputStreamReader(s.getInputStream());
                serverOutputStream = new BufferedReader(input);
            }
            return serverOutputStream;
        }catch(IOException ioe){
            ioe.printStackTrace();//Fix-me: Log this
            return null;
        }
    }

    public PrintWriter getServerInputStream(){
        try{
            if (serverInputStream == null) {
                Socket s = new Socket(HOST, PORT);
                serverInputStream =
                        new PrintWriter(s.getOutputStream(), true);
            }
            return serverInputStream;
        }catch(IOException ioe){
            ioe.printStackTrace();//Fix-me: Log this
            return null;
        }
    }

    public void connectionCleanup(){
        try {
            if (serverInputStream!=null)
            {
                serverInputStream.close();
                serverInputStream = null;
            }
            if (serverOutputStream!=null)
            {
                serverOutputStream.close();
                serverOutputStream = null;
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
}
