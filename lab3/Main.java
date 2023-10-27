package lab3;

import java.nio.file.*;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class Main {
    public static Logger logger = lab3.FileManager.getLogger();
    public static void main(String[] args) {
        String folderPath = "/Users/nmacrii/Desktop/test";
        Path directory = Path.of(folderPath);


        Scanner in = new Scanner(System.in);
        String navigate = "";

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            Controller.getStatus(directory);
        }, 0, 10, TimeUnit.SECONDS);

        while (!navigate.equals("q")){
            System.out.print("\nWelcome UTM GIT!\n" +
                    "What do u want to do?\n\n" +
                    "commit - create a checkpoint\n" +
                    "info <filename> - show information about a file\n" +
                    "status - show status of the file compared to the last checkpoint\n\n" +
                    "q - quit program\n\n" +
                    "Your input> ");

            navigate = in.nextLine();

            if(navigate.equals("commit")){
                Controller.commit(directory);
            }else if(navigate.startsWith("info")){
                String[] nav = navigate.split(" ");
                Controller.getInfo(folderPath+"/"+nav[1]);
            }else if(navigate.equals("status")){
                Controller.getStatus(directory);
            }else{
                logger.warning("Incorrect command");
            }

        }
        FileManager.saveLogToFile();
        scheduler.shutdown();

    }

}
