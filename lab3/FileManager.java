package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileManager {
    private static String metadataFile = "metadata.txt";
    private static Logger LOGGER = Logger.getLogger(lab2.FileManager.class.getName());
    private static String logFile = "operations.log";
    public static void saveMetadataToFile(List<String> metadataList) {
        clearFile();
        try (PrintWriter writer = new PrintWriter(metadataFile)) {
            for (String metadata : metadataList) {
                writer.println(metadata);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readMetadataFromFile() {
        List<String> metadataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(metadataFile))) {
            StringBuilder metadataEntry = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                metadataEntry.append(line).append("\n");
                if (line.isEmpty()) {
                    metadataList.add(metadataEntry.toString());
                    metadataEntry.setLength(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return metadataList;
    }

    public static void clearFile() {
        try {
            Files.deleteIfExists(Paths.get(metadataFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveLogToFile() {
        try {
            FileHandler fileHandler = new FileHandler(logFile, true);
            LOGGER.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());

            LOGGER.addHandler(fileHandler);


        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.severe("Error saving student information to the file: " + e.getMessage());

        }
    }

    public static Logger getLogger(){
        return LOGGER;
    }
}
