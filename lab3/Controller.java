package lab3;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static lab3.FileManager.saveMetadataToFile;

public class Controller {
    public static void commit(Path directory){
        try {
            List<String> metadataList = new ArrayList<>();
            Files.walkFileTree(directory, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new Folder.FolderVisitor(metadataList));

            saveMetadataToFile(metadataList, "metadata.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getInfo(String file) {
        String[] ext = file.split("\\.");
        switch(ext[1]){
            case "png" :
            case "jpg" :
                break;
            case "txt":
                break;
            case "java":
            case "py":
                break;
            default:


        }

    }

    public static void getStatus() {
        // Implement the status logic here
    }
}
