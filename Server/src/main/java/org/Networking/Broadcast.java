package org.networking;

import org.commonNetworking.Message;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Graham on 1/31/2016.
 */
public class Broadcast {
    private Socket socket;

    public Broadcast(String host,int port){
        try{
            socket = new Socket(host,port);
        }catch (IOException ioe) {
            ioe.printStackTrace();//Fixme: Log this
        }
    }

    public Boolean sendMessage(Message message)
    {
        try {
            if (socket!=null) {
                PrintWriter pr = new PrintWriter(socket.getOutputStream());
                pr.print(message.name+"|"+message.type+"|"+message.body);
            }
        }catch(IOException ioe){
            ioe.printStackTrace();//Fixme: Log me
        }
        return true;
    }
}
