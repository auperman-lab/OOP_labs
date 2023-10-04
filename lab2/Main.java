package lab2;

import lab2.Models.Faculty;
import lab2.Models.Student;
import lab2.Operations.FacultyOperations;
import lab2.Operations.GeneralOperations;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        // TODO good
        Vector<Faculty> faculties = new Vector<>(2);
        Vector<Student> students = new Vector<>(2);
        FileManager fileManager = new FileManager();

        fileManager.readFaculty(faculties, fileManager.facultydb);
        fileManager.readStudent(students, fileManager.studentdb);

        Scanner in = new Scanner(System.in);
        String navigate = "";

        while (!navigate.equals("q")) {
            System.out.print("\nWelcome to TUM's student management system!\n" +
                    "What do u want to do?\n\n" +
                    "g - General operations\n" +
                    "f - Faculty operations\n" +
                    "s - Student operations\n\n" +
                    "q - quit program\n\n" +
                    "Your input> ");


            navigate = in.nextLine();
            switch (navigate) {
                case "g":
                    boolean g = general(faculties, in);
                    if (g) return;
                    break;
                case "f":
                    boolean f = faculty(faculties, students, fileManager, in);
                    if (f) return;
                    break;
                case "s":
                    break;
                case "q":
                    break;

                default:
                    System.out.println("Unknown command. Please try again.\n\n+" +
                            "Your input> ");
                    break;
            }
        }
        System.out.println("Exiting the program.");
        fileManager.saveFaculties(faculties, fileManager.facultydb);
        fileManager.saveStudents(students, fileManager.studentdb);

        in.close();
    }

    public static boolean general(Vector<Faculty> faculties, Scanner in) {

        GeneralOperations general = new GeneralOperations();
        String navigate = "";


        while (!(navigate.equals("q"))) {
            general.printGeneralOperations();

            navigate = in.nextLine();

            if (navigate.startsWith("nf/")) {
               general.createFaculty(faculties, navigate);
            }
            else if (navigate.startsWith("ss/")) {
               general.showStudentFaculty(faculties, navigate);
            }
            else if (navigate.equals("df")) {
                System.out.println("\nDisplaying all faculties : \n");

                for (Faculty faculty : faculties) {
                    faculty.displayFaculty();
                }

                System.out.println("\nEND \n");
            }
            else if (navigate.startsWith("df/")) {
                general.displaySpecificFaculty(faculties, navigate);
            }
             else if (navigate.equals("b")) {
                return false;
            }
            else if (navigate.equals("q")){
                return true;
            }
            else System.out.println("Unknown command. Please try again.");
        }
        return true;
    }

    public static boolean faculty(Vector<Faculty> faculties, Vector<Student> students,FileManager fileManager, Scanner in) {
        String navigate ="";
        FacultyOperations facultyOperations = new FacultyOperations();


        while (!(navigate.equals("q"))) {
           facultyOperations.printFacultyOperations();
            navigate = in.nextLine();

            if (navigate.startsWith("ns/")) {
                facultyOperations.createStudent(faculties, students, navigate);
            }
            else if (navigate.startsWith("gs/")) {
               facultyOperations.graduateStudent(students, navigate);
            }
            else if (navigate.startsWith("ds/")) {
               facultyOperations.displayStudents(faculties, students, navigate, true);
            }
            else if (navigate.startsWith("dg/")) {
                facultyOperations.displayStudents(faculties, students, navigate, false);
            }
            else if (navigate.startsWith("bf/")) {
              facultyOperations.belongsToFaculty(students, navigate);
            }
            else if (navigate.startsWith("bs/")){
                facultyOperations.batchStudents(students, fileManager, navigate);
            }
            else if (navigate.equals("b")) {
                return false;
            }
            else {
                System.out.println("Unknown command. Please try again.");
            }

        }
        return true;
    }


}
