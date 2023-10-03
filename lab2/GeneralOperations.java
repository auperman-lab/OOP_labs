package lab2;

import java.util.Vector;

public class GeneralOperations {

    public void createFaculty(Vector<Faculty> faculties, String s){
        String[] parts = s.split("/");
        if (parts.length == 4) {

            Faculty faculty = new Faculty(parts[1], parts[2], StudyField.valueOf(parts[3].toUpperCase()));
            faculties.add(faculty);
            System.out.println("\nFaculty created successfully\n");

        } else System.out.println("Invalid format for creating a faculty.");
    }

    public void showStudentFaculty(Vector<Faculty> faculties, String s){
        String[] parts = s.split("/");
        if (parts.length == 2) {
            String abbreviation = selectAbbreviation(parts[1]);
            for (Faculty faculty : faculties) {
                if (faculty.abbreviation.equals(abbreviation)) {
                    System.out.println("\nStudent with email :" + parts[1] + "is a student in this faculty : \n");
                    faculty.displayFaculty();
                }
            }

        } else System.out.println("Invalid format for shearching students");
    }

    public void displaySpecificFaculty(Vector<Faculty> faculties, String s){
        String[] parts = s.split("/");
        if (parts.length == 2) {
            StudyField displayField = StudyField.valueOf(parts[1].toUpperCase());
            System.out.println("\nPrinting faculties of " + displayField + "field : \n");
            for (Faculty faculty : faculties) {
                if (faculty.studyField.equals(displayField)) {
                    faculty.displayFaculty();
                }
            }
            System.out.println("\n END \n");
        } else System.out.println("Invalid format for displaying faculties of a field.");

    }


    public void printGeneralOperations() {
        System.out.print("\nGeneral operations\n" +
                "What do you want to do?\n\n" +
                "nf/<faculty name>/<faculty abbreviation>/<field> - create faculty\n" +
                "ss/<student email> - search student and show faculty\n" +
                "df - display faculties\n" +
                "df/<field> - display all faculties of a field\n\n" +
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
