package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ConfigFileReader {

    public static String getProperty(String propertyName) {
        String propertyValue = null;

        try (InputStream input = new FileInputStream("./src/main/java/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            propertyValue = prop.getProperty(propertyName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return propertyValue;
    }
}