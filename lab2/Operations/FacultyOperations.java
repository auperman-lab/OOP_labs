package lab2.Operations;

import lab2.FileManager;
import lab2.Models.Faculty;
import lab2.Models.Student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class FacultyOperations {

    public void createStudent(Vector<Faculty> faculties, Vector<Student> students, String s){
        String[] parts = s.split("/");
        if (parts.length == 5) {
            Faculty studentFaculty = findFaculty(faculties, parts[1]);
            if (studentFaculty == null) {
                System.out.println("Invalit Faculty abbreviation");
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String currentDateFormatted = dateFormat.format(new Date());
                Student student = new Student(parts[2], parts[3], parts[4], parts[2].toLowerCase()+parts[3].toLowerCase()+"@"+studentFaculty.abbreviation+".utm.md", true, currentDateFormatted);
                students.add(student);
                System.out.println("\nStudent created successfully\n");
            }
        } else System.out.println("Invalid format for creating a student");
    }

    public void graduateStudent(Vector<Student> students, String s){
        String[] parts = s.split("/");
        if (parts.length == 2) {
            for (Student student : students) {
                if (student.email.equals(parts[1])) {
                    student.status = false;
                    System.out.println("\nStudent graduated successfully\n");
                } else System.out.println("Invalid student email");
            }
        } else System.out.println("Invalid format for graduating a student");
    }

    public void displayStudents(Vector<Faculty> faculties, Vector<Student> students, String s, Boolean isEnrolled){
        String[] parts = s.split("/");
        if (parts.length == 2) {
            Faculty studentFaculty = findFaculty(faculties, parts[1]);
            if (studentFaculty == null) {
                System.out.println("Invalid Faculty abbreviation");
            } else {
                System.out.println("\n Printing enrolled students of " + studentFaculty.name + " faculty \n");
                for (Student student : students) {
                    if (isEnrolled && student.status && selectAbbreviation(student.email).equals(studentFaculty.abbreviation)) {
                        student.displayStudent();
                    }
                }
                System.out.println("\n END \n");

            }
        } else System.out.println("Invalid format for displaying all enrolled students");


    }

    public void belongsToFaculty(Vector<Student> students, String s){
        String[] parts = s.split("/");
        if (parts.length == 3) {
            for (Student student : students) {
                if (parts[1].equals(selectAbbreviation(student.email)) && student.email.equals(parts[2])) {
                    System.out.println("\n This student belongs to " + parts[1] + " faculty \n:");
                    student.displayStudent();
                }
            }

        } else System.out.println("Invalid format for checking if a student belongs to a faculty");

    }



    private Faculty findFaculty(Vector<Faculty> faculties, String abbreviation) {
        for (Faculty faculty : faculties) {
            if (faculty.abbreviation.equals(abbreviation)) {
                return faculty;
            }
        }
        return null;
    }

    private String selectAbbreviation(String email) {
        String[] parts = email.split("@");
        if (parts.length >= 2) {
            String[] splitByDot = parts[1].split("\\."); // Escape the dot with double backslashes
            if (splitByDot.length > 0) {
                return splitByDot[0];
            }
        }
        return "Unknown";
    }

    public void batchStudents(Vector<Student> students, FileManager fileManager, String s){

        String[] parts = s.split("/");
        if (parts.length == 2) {
            fileManager.readStudent(students, parts[1]);

        } else System.out.println("Invalid format for bathcing students info");


    }

    public void printFacultyOperations(){
        System.out.print("\nFaculty opertions\n" +
                "What do u want to do?\n\n" +
                "ns/<faculty abbreviation>/<first name>/<last name>/<date of birth> - create student\n" +
                "gs/<student email> - graduate student\n" +
                "ds/<faculty abbreviation> - display enrolled students\n" +
                "dg/<faculty abbreviation> - display graduated students\n" +
                "bf/<faculty abbreviation>/<email> - check if student belongs to faculty\n" +
                "bs/filelocation - add students from a file\n\n"+
                "b - Back\n" +
                "q - Quit\n\n" +
                "Your input> ");

    }
}
