package org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Bozerg on 1/31/2016.
 */
public class GameRunner {
    private static final Logger logger;
    static{
        logger = LoggerFactory.getLogger(GameRunner.class);
        logger.debug("org.GameRunner logger initialized");
    }
    public static void main(String[] args){
        logger.debug("org.GameRunner main method called");
    }
}
