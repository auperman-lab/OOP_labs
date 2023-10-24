package lab3;

import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;

public class Info {
    private String name;
    private String extension;
    private long size;
    private String lastUpdate;
    private String created;

    public Info(String name_, long size_, FileTime lastUpdate_,FileTime created_){
        this.name = name_;
        this.extension = getPrettyExtension(name_);
        this.size = size_;
        this.lastUpdate = formatDateAndTime(lastUpdate_);
        this.created = formatDateAndTime(created_);
    }

    private String getPrettyExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex != -1) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "No Extension";
    }

    private String formatDateAndTime(FileTime fileTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new java.util.Date(fileTime.toMillis()));
    }
    public void display(){
        System.out.println("File name: "+ name);
        System.out.println("File extension: "+ extension);
        System.out.println("File Size:" + size);
        System.out.println("Last Updated:" + lastUpdate);
        System.out.println("Created at:" + created);

    }

}
