package com.rea.robot.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResourceUtil {
    private static Properties prop = new Properties();
    private static Logger log= Logger.getLogger(ResourceUtil.class.getName());
    static{
        loadProperties();
    }

    private static void loadProperties() {

        InputStream input = null;

        try {

            String filename = "position.properties";
            input = ResourceUtil.class.getClassLoader().getResourceAsStream(filename);
            if(input==null){
                System.out.println("Sorry, unable to find " + filename);
                return ;
            }
            prop.load(input);

        } catch (IOException io) {
            log.log(Level.SEVERE,"Unable to read properties.");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    log.log(Level.WARNING,"Unable to close input Stream.");
                }
            }
        }
       }
    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }

}
