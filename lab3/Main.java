package lab3;

import java.io.IOException;
import java.nio.file.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String folderPath = "/Users/nmacrii/Desktop/test";
        Path directory = Path.of(folderPath);

        try {
            List<String> metadataList = new ArrayList<>();
            Files.walkFileTree(directory, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new Folder.FolderVisitor(metadataList));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
