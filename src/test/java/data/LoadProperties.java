package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to load properties from a specified file.
 * This class is responsible for reading key-value pairs from a properties file
 * and making them accessible throughout the application.
 */
public class LoadProperties 
{
    /**
     * Static Properties object to hold the loaded properties data.
     * The properties data is loaded from the config.properties file located in
     * the src/main/java/properties directory.
     */
    public static Properties filePath = loadProperties(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\config.properties");

    /**
     * Loads properties from the given file path.
     *
     * @param path the path to the properties file.
     * @return a Properties object containing the loaded properties.
     */
    private static Properties loadProperties(String path)
    {
        Properties pro = new Properties();

        // Stream for reading the properties file
        try (FileInputStream stream = new FileInputStream(path))
        {
            pro.load(stream);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error occurred: File not found - " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("Error occurred: IO exception - " + e.getMessage());
        }
        return pro;
    }
}
