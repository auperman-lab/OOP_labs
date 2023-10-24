package lab3;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.List;



public class Folder extends SimpleFileVisitor<Path> {
    static class FolderVisitor extends SimpleFileVisitor<Path> {
        private List<String> metadataList;

        public FolderVisitor(List<String> metadataList) {
            this.metadataList = metadataList;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String fileName = file.getFileName().toString();
            long fileSize = attrs.size();
            FileTime lastModifiedTime = attrs.lastModifiedTime();

            String metadata = "File: " + fileName + "\n" +
                    "Size: " + fileSize + " bytes\n" +
                    "Last Modified Time: " + lastModifiedTime + "\n\n";

            metadataList.add(metadata);


            return FileVisitResult.CONTINUE;
        }

        public FileVisitResult visitResult(String file, BasicFileAttributes attrs){
            long fileSize = attrs.size();
            FileTime lastModifiedTime = attrs.lastModifiedTime();
            FileTime creationTime = attrs.creationTime();

            return FileVisitResult.CONTINUE;

        }

    }
}

