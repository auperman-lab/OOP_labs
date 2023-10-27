package lab3.MetadataReaders;

import lab3.Info.Info;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.logging.Logger;

public class MetadataReader {
    public static Logger logger = lab3.FileManager.getLogger();
    public Info readMetadata(String filePath) {
        Path path = FileSystems.getDefault().getPath(filePath);

        try {
            BasicFileAttributes attrs = java.nio.file.Files.readAttributes(path, BasicFileAttributes.class);

            String name = path.getFileName().toString();
            long size = attrs.size();
            FileTime lastUpdate = attrs.lastModifiedTime();
            FileTime created = attrs.creationTime();

            logger.info("file metadata retrieved successfully");
            return new Info(name, size, lastUpdate, created);
        } catch (IOException e) {
            logger.warning("failed to read metadata "+ e);
            return null;
        }
    }
}