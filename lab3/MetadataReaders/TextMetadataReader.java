package lab3.MetadataReaders;
import lab3.Info.Info;
import lab3.Info.TxtInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class TextMetadataReader extends MetadataReader{
    public TxtInfo readMetadata(String filePath) {
        Info info = super.readMetadata(filePath);

        String content = readTextFileContent(filePath);
        if (content != null) {
            return new TxtInfo(
                        info.getName(), info.getSize(), info.getLastUpdate(), info.getCreated(),
                        content
                        );
        }

        return null;
    }

    private String readTextFileContent(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder contentBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
            return contentBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
