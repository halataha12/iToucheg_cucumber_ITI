package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    public static Properties  userdata =LoadProperties("C:/Users/TC/Desktop/New folder/iToucheg_Cucumber/src/main/java/properties/userdata.properties");
    private static Properties LoadProperties(String path){
        Properties pro=new Properties();
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        }
        catch (FileNotFoundException e){
            System.out.println("Error occurred: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("Error occurred: " + e.getMessage());
        }

        return  pro;

    }
}
