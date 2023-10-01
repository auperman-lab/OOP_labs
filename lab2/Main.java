package lab2;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args){
        Vector<Faculty> faculties = new Vector<>(2);
        Vector<Student> students = new Vector<>(2);


        Scanner in = new Scanner(System.in);
        String s;

        while (true) {
            System.out.print("\nWelcome to TUM's student management system!\n"+
                    "What do u want to do?\n\n"+
                    "g - General operations\n"+
                    "f - Faculty operations\n"+
                    "s - Student operations\n\n"+
                    "q - quit program\n\n"+
                    "Your input> ");


            s = in.nextLine();
            switch (s){
                case "g":
                    boolean g =general(faculties);
                    if(g){
                        return;
                    }
                    break;
                case "f":
                    boolean f =faculty(faculties, students);
                    if(f){
                        return;
                    }
                    break;
                case "s":
                    break;

                default:
                    System.out.println("Unknown command. Please try again.\n\n+" +
                            "Your input> ");
                    break;
            }
        }
    }

    public static boolean general(Vector<Faculty> faculties) {
        Scanner in = new Scanner(System.in);
        String s;


        while (true) {
            System.out.print("\nGeneral operations\n" +
                    "What do you want to do?\n\n" +
                    "nf/<faculty name>/<faculty abbreviation>/<field> - create faculty\n" +
                    "ss/<student email> - search student and show faculty\n" +
                    "df - display faculties\n" +
                    "df/<field> - display all faculties of a field\n\n" +
                    "b - Back\n" +
                    "q - Quit\n\n" +
                    "Your input> ");

            s = in.nextLine();

            if (s.startsWith("nf/")) {
                String[] parts = s.split("/");
                if (parts.length == 4) {

                    Faculty faculty = new Faculty(parts[1], parts[2], StudyField.valueOf(parts[3].toUpperCase()));
                    faculties.add(faculty);

                } else System.out.println("Invalid format for creating a faculty.");

            }
            else if (s.startsWith("ss/")) {
                String[] parts = s.split("/");
                if(parts.length == 2){
                    String abbreviation = selectAbbreviation(parts[1]);
                    for(Faculty faculty:faculties){
                        if(faculty.abbreviation.equals(abbreviation)){
                            System.out.println("Student with email :" + parts[1]+"is a student in this faculty : ");
                            faculty.displayFaculty();
                        }
                    }

                }else System.out.println("Invalid format for shearching students");
            }
            else if (s.equals("df")) {

                for(Faculty faculty :faculties){
                   faculty.displayFaculty();
                }

            }
            else if (s.startsWith("df/")) {

                String[] parts = s.split("/");
                if (parts.length == 2){
                    StudyField displayField = StudyField.valueOf(parts[1].toUpperCase());
                    for(Faculty faculty :faculties){
                        if (faculty.studyField.equals(displayField)){
                            faculty.displayFaculty();
                        }
                    }
                } else System.out.println("Invalid format for displaying faculties of a field.");

            }
            else if (s.equals("b")) {
                return false;
            }
            else if (s.equals("q")) {
                System.out.println("Exiting the program.");
                return true;
            }
            else {
                System.out.println("Unknown command. Please try again.");
            }
        }
    }


    public static boolean faculty(Vector<Faculty> faculties, Vector<Student> students) {
        Scanner in = new Scanner(System.in);
        String s;

        System.out.print("\nFaculty opertions\n" +
                "What do u want to do?\n\n" +
                "ns/<faculty abbreviation>/<first name>/<last name>/<date of birth> - create student\n" +
                "gs/<student email> - graduate student\n" +
                "ds/<faculty abbreviation> - display enrolled students\n" +
                "dg/<faculty abbreviation> - display graduated students\n" +
                "bf/<faculty abbreviation>/<email> - check if student belongs to faculty\n\n" +
                "b - Back\n" +
                "q - Quit\n\n" +
                "Your input> ");


        while (true) {
            s = in.nextLine();

            if (s.startsWith("ns/")) {
                String[] parts = s.split("/");
                if (parts.length == 5) {
                    Faculty studentFaculty = findFaculty(faculties, parts[1]);
                    if (studentFaculty == null) {
                        System.out.println("Invalit Faculty abbreviation");
                    }else{
                        Student student = new Student(parts[2], parts[3], parts[4], studentFaculty.abbreviation);
                        students.add(student);
                        studentFaculty.enrollStudent(student);
                    }
                } else System.out.println("Invalid format for creating a student");


            }
            else if (s.startsWith("gs/")) {
                String[] parts = s.split("/");
                if (parts.length == 2) {
                    for (Student student : students) {
                        if (student.email.equals(parts[1])) {
                            student.status = false;
                        } else System.out.println("Invalid student email");
                    }
                } else System.out.println("Invalid format for graduating a student");


            }
            else if (s.startsWith("ds/")) {
                String[] parts = s.split("/");
                if (parts.length == 2) {
                    Faculty studentFaculty = findFaculty(faculties, parts[1]);
                    if (studentFaculty == null) {
                        System.out.println("Invalid Faculty abbreviation");
                    }else{
                        for(Student student:students){
                            if(student.status  && selectAbbreviation(student.email).equals(studentFaculty.abbreviation)){
                                student.displayStudent();
                            }
                        }
                    }
                } else System.out.println("Invalid format for displaying all enrolled students");


            }
            else if (s.startsWith("dg/")) {
                String[] parts = s.split("/");
                if (parts.length == 2) {
                    Faculty studentFaculty = findFaculty(faculties, parts[1]);
                    if(studentFaculty == null){
                        System.out.println("Invalid Faculty abbreviation");
                    }else{
                        for(Student student:students){
                            if(!student.status && selectAbbreviation(student.email).equals(studentFaculty.abbreviation)){
                                student.displayStudent();
                            }
                        }
                    }
                }else System.out.println("Invalid format for displaying all graduated students");


            }
            else if (s.startsWith("bf/")) {
                String[] parts = s.split("/");
                if (parts.length == 3) {
                    for(Student student: students){
                        if(parts[1].equals(selectAbbreviation(student.email)) && student.email.equals(parts[2])){
                            student.displayStudent();
                        }
                    }

                }else System.out.println("Invalid format for checking if a student belongs to a faculty");


            }
            else if (s.equals("b")) {
                return false;
            }
            else if (s.equals("q")) {
                System.out.println("Exiting the program.");
                return true;
            }
            else {
                System.out.println("Unknown command. Please try again.");
            }

        }
    }

    public static Faculty findFaculty(Vector<Faculty> faculties, String abbreviation){
        for(Faculty faculty:faculties){
            if(faculty.abbreviation.equals(abbreviation)){
                return faculty;
            }
        }
        return null;
    }

    public static String selectAbbreviation(String email){
        String[] parts = email.split("@");
        String[] splid = parts[1].split(".");
        return splid[0];
    }
}
