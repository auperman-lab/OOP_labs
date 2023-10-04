package lab2.Operations;

import lab2.FileManager;
import lab2.Models.Faculty;
import lab2.Models.Student;
import lab2.Models.StudyField;

import java.util.Vector;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneralOperations {
    public static Logger logger = FileManager.getLogger();

    public void createFaculty(Vector<Faculty> faculties, String s){
        String[] parts = s.split("/");
        if (parts.length == 4) {

            Faculty faculty = new Faculty(parts[1], parts[2], StudyField.valueOf(parts[3].toUpperCase()));
            faculties.add(faculty);
            logger.info("\nFaculty created successfully\n"+ s);


        } else {
            logger.warning("Invalid format for creating a faculty: " + s); // Log a warning
        }
    }

    public void showStudentFaculty(Vector<Faculty> faculties, String s) {
        String[] parts = s.split("/");
        if (parts.length == 2) {
            String abbreviation = selectAbbreviation(parts[1]);
            if (abbreviation.equals("Unknown")){
                logger.warning("Student email has an unknown domain: " + parts[1]);
            }else{
                for (Faculty faculty : faculties) {
                    if (faculty.abbreviation.equals(abbreviation)) {
                        faculty.displayFaculty();
                        logger.info("Student found in faculty: " + faculty.name + ", Student Email: " + parts[1]);
                        return;
                    }
                }
                logger.warning("Student not found in any faculty: " + parts[1]);
            }

        } else {
            logger.warning("Invalid format for searching students: " + s);
        }
    }


    public void displaySpecificFaculty(Vector<Faculty> faculties, String s) {
        String[] parts = s.split("/");
        if (parts.length == 2) {
            StudyField displayField;
            try {
                displayField = StudyField.valueOf(parts[1].toUpperCase());
            } catch (IllegalArgumentException e) {
                logger.warning("Invalid StudyField provided: " + parts[1]);
                return;
            }

            logger.info("Displaying faculties of " + displayField + " field:");
            boolean found = false;
            for (Faculty faculty : faculties) {
                if (faculty.studyField.equals(displayField)) {
                    faculty.displayFaculty();
                    found = true;
                }
            }
            if (!found) {
                logger.info("No faculties found for the specified StudyField: " + displayField);
            }
            System.out.println("\n END \n");
        } else {
            logger.warning("Invalid format for displaying faculties of a field: " + s);
        }
    }





    public void printGeneralOperations() {
        System.out.print("\nGeneral operations\n" +
                "What do you want to do?\n\n" +
                "nf/<faculty name>/<faculty abbreviation>/<field> - create faculty\n" +
                "ss/<student email> - search student and show faculty\n" +
                "df - display faculties\n" +
                "df/<field> - display all faculties of a field\n\n"+
                "b - Back\n" +
                "q - Quit\n\n" +
                "Your input> ");
    }


    public String selectAbbreviation(String email) {
        String[] parts = email.split("@");
        if (parts.length >= 2) {
            String[] splitByDot = parts[1].split("\\."); // Escape the dot with double backslashes
            if (splitByDot.length > 0) {
                return splitByDot[0];
            }
        }
        return "Unknown";
    }



}
