package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static { //her method dan once calisir
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis); //fis in okudugu bilgileri properties e yukledi

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

/*
Test methodundan yolladigimiz String key degerini alip properties classindan
getProperty() methodunu kullanarak bu key'e ait value'yu bize getirir
 */


    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}
