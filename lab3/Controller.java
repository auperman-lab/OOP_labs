package lab3;

import lab3.Info.ImgInfo;
import lab3.Info.Info;
import lab3.Info.ProgInfo;
import lab3.Info.TxtInfo;
import lab3.MetadataReaders.ImageMetadataReader;
import lab3.MetadataReaders.MetadataReader;
import lab3.MetadataReaders.ProgMetadataReader;
import lab3.MetadataReaders.TextMetadataReader;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.logging.Logger;


import static lab3.FileManager.readMetadataFromFile;
import static lab3.FileManager.saveMetadataToFile;

public class Controller {
    public static Logger logger = lab3.FileManager.getLogger();

    public static void commit(Path directory){
        try {
            List<String> metadataList = new ArrayList<>();
            Files.walkFileTree(directory, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new Folder.FolderVisitor(metadataList));

            saveMetadataToFile(metadataList);
        } catch (IOException e) {
            logger.warning("failed to get folder information "+ e);
        }
    }

    public static void getInfo(String file) {
        String[] ext = file.split("\\.");


        switch(ext[1]){
            case "png" :
            case "jpg" :
                ImageMetadataReader imageReader = new ImageMetadataReader();
                ImgInfo imgInfo = imageReader.readMetadata(file);
                if (imgInfo != null) {
                    imgInfo.display();
                }
                break;
            case "txt":
                TextMetadataReader textReader = new TextMetadataReader();
                TxtInfo txtInfo = textReader.readMetadata(file);
                if (txtInfo != null) {
                    txtInfo.display();
                }
                break;
            case "java":
            case "py":
                ProgMetadataReader progReader = new ProgMetadataReader();
                ProgInfo progInfo = progReader.readMetadata(file);
                if (progInfo != null) {
                    progInfo.display();
                }


                break;
            default:
                MetadataReader reader = new MetadataReader();
                Info fileInfo = reader.readMetadata(file);
                if (fileInfo != null) {
                    fileInfo.display();
                }
                break;
        }

    }

    public static void getStatus(Path directory) {

        try {
            List<String> metadataList = new ArrayList<>();
            Files.walkFileTree(directory, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new Folder.FolderVisitor(metadataList));
            StatusDetection statusDetection = new StatusDetection(metadataList, readMetadataFromFile());


            statusDetection.detectChanges();
        } catch (IOException e) {
            logger.warning("failed to get folder information "+ e);
        }


    }
}
