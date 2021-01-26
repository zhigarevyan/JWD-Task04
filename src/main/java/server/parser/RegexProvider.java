package server.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class RegexProvider {
    private static final String REGEX_PROPERTIES_FILE = "src/main/resources/regex.properties";
    private Properties regexProperties;
    private static RegexProvider instance;

    public static RegexProvider getInstance() {
        if (instance == null) {
            instance = new RegexProvider();
        }
        return instance;
    }


    private RegexProvider() {
        try {
            FileReader regexFileReader = new FileReader(REGEX_PROPERTIES_FILE);
            regexProperties = new Properties();
            regexProperties.load(regexFileReader);
        } catch (FileNotFoundException e) {
            System.err.println("File not found while creating regex reader");
        } catch (IOException e) {
            System.err.println("File not found while reading regex properties");
        }
    }

    public String get(String key) {
        return regexProperties.getProperty(key);
    }


}
