package lab3.Info;

import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;

public class Info {
    private String name;
    private String extension;
    private long size;
    private String lastUpdate;
    private String created;

    public Info(String name, long size, FileTime lastUpdate,FileTime created){
        this.name = name;
        this.extension = getPrettyExtension(name);
        this.size = size;
        this.lastUpdate = formatDateAndTime(lastUpdate);
        this.created = formatDateAndTime(created);
    }

    public Info(String name, long size, String lastUpdate,String created){
        this.name = name;
        this.extension = getPrettyExtension(name);
        this.size = size;
        this.lastUpdate = lastUpdate;
        this.created = created;
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

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getCreated() {
        return created;
    }
    public void display(){
        System.out.println("File name: "+ name);
        System.out.println("File extension: "+ extension);
        System.out.println("File Size:" + size);
        System.out.println("Last Updated:" + lastUpdate);
        System.out.println("Created at:" + created);

    }

}
