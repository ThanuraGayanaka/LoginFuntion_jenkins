package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;



    static {

         properties= new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(fileInputStream);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }


    public static String getAppUrl(){

        return properties.getProperty("url");


    }






}
