package lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public static void clearFile(String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
