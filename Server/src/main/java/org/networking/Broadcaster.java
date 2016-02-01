package org.networking;

import org.commonNetworking.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Graham on 1/31/2016.
 */
public class Broadcaster {
    private static final Logger logger;
    private Socket socket;

    static{
        logger = LoggerFactory.getLogger(Broadcaster.class);
        logger.debug("org.networking.Broadcaster logger initialized");
    }


    public Broadcaster(String host, int port){
        try{
            socket = new Socket(host,port);
        }catch (IOException ioe) {
            logger.error("Broadcaster Socket Constructor Failure");
            logger.debug(ioe.getStackTrace().toString());
        }
    }

    public Boolean sendMessage(Message message)
    {
        try {
            if (socket!=null) {
                PrintWriter pr = new PrintWriter(socket.getOutputStream());
                pr.print(message.name+"|"+message.type+"|"+message.body);
            }
        }
        catch(IOException ioe){
            logger.error("Server Broadcaster Message Failure");
            logger.debug(ioe.getStackTrace().toString());
            return false;
        }
        return true;
    }
}
