package lab3.MetadataReaders;

import lab3.Info.Info;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class MetadataReader {
    public Info readMetadata(String filePath) {
        Path path = FileSystems.getDefault().getPath(filePath);

        try {
            BasicFileAttributes attrs = java.nio.file.Files.readAttributes(path, BasicFileAttributes.class);

            String name = path.getFileName().toString();
            long size = attrs.size();
            FileTime lastUpdate = attrs.lastModifiedTime();
            FileTime created = attrs.creationTime();

            return new Info(name, size, lastUpdate, created);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}