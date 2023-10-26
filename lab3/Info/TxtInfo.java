package lab3.Info;

import java.nio.file.attribute.FileTime;
public class TxtInfo extends Info{

    private String content;
    public TxtInfo(String name, long size, String lastUpdate, String created, String content) {
        super(name, size, lastUpdate, created);
        this.content = content;

    }

    private int countLines() {
        String[] lines = content.split("\n");
        return lines.length;
    }

    private int countWords() {
        String[] words = content.split("\\s+");
        return words.length;
    }

    private int countCharacters() {
        return content.length();
    }

    @Override
    public void display() {
        super.display();

        System.out.println("Line Count: " + countLines());
        System.out.println("Word Count: " + countWords());
        System.out.println("Character Count: " + countCharacters());
    }

}
