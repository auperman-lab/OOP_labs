package lab3;

import java.nio.file.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String folderPath = "/Users/nmacrii/Desktop/test";
        Path directory = Path.of(folderPath);

        Scanner in = new Scanner(System.in);
        String navigate = "";

        while (!navigate.equals("q")){
            navigate = in.nextLine();

            if(navigate.equals("commit")){
                Controller.commit(directory);
            }else if(navigate.startsWith("info")){
                String[] nav = navigate.split(" ");
                Controller.getInfo(nav[1]);
            }else if(navigate.equals("status")){
                Controller.getStatus();
            }

        }

    }




}
