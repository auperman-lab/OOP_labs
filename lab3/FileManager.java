package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void saveMetadataToFile(List<String> metadataList, String fileName) {
        clearFile(fileName);
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (String metadata : metadataList) {
                writer.println(metadata);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readMetadataFromFile(String fileName) {
        List<String> metadataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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

    public static void clearFile(String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
