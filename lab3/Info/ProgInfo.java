package lab3.Info;

import java.nio.file.attribute.FileTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgInfo extends Info{

    private String content;
    public ProgInfo(String name, long size, String lastUpdate, String created, String content) {
        super(name, size, lastUpdate, created);
        this.content = content;
    }

    @Override
    public void display() {
        super.display();

        System.out.println("Line Count: "+ countLines() );
        System.out.println("Class Count: " + countClasses());
        System.out.println("Method Count: " + countMethods());
    }

    public int countLines() {
        String[] lines = content.split("\n");
        return lines.length;
    }

    public int countClasses() {
        int classCount = 0;
        Pattern classPattern = Pattern.compile("class\\s+(\\w+)\\s*\\{?");
        Matcher matcher = classPattern.matcher(content);
        while (matcher.find()) {
            classCount++;
        }
        return classCount;
    }

    public int countMethods() {
        int methodCount = 0;
        Pattern methodPattern = Pattern.compile("\\b(public|private|protected|static)\\s+\\w+\\s+\\w+\\s*\\([^)]*\\)\\s*\\{?");
        Matcher matcher = methodPattern.matcher(content);
        while (matcher.find()) {
            methodCount++;
        }
        return methodCount;
    }

}
