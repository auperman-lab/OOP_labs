package lab2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class FileManager {
    private String facultyFile = "faculty_records.txt";
    private String studentFile = "student_records.txt";



    public void saveFaculties(Vector<Faculty> faculties){

        clearFile(facultyFile);

        for(Faculty faculty:faculties){
            try {
                FileWriter fileWriter = new FileWriter(facultyFile, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


                bufferedWriter.newLine();
                bufferedWriter.write("Name: " + faculty.name);
                bufferedWriter.newLine();
                bufferedWriter.write("Abbreviation: " + faculty.abbreviation);
                bufferedWriter.newLine();
                bufferedWriter.write("StudyField: "+ faculty.studyField.toString());
                bufferedWriter.newLine();

                bufferedWriter.close();

//                System.out.println("Faculty information has been written to " + facultyFile);

            } catch (IOException e) {
                // Handle the IO exception
                e.printStackTrace();

                // Log the error and provide context
                System.err.println("Error writing faculty information to the file: " + e.getMessage());
            }
        }
        try{
            FileWriter fileWriter = new FileWriter(facultyFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("Error writing faculty information to the file: " + e.getMessage());

        }

    }

    public  Vector<Faculty> readFaculty( Vector<Faculty> faculties) {

        try (FileReader fileReader = new FileReader(facultyFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            String name = null;
            String abbreviation = null;
            StudyField studyField = null;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("Name: ")) {
                    name = line.substring("Name: ".length());
                } else if (line.startsWith("Abbreviation: ")) {
                    abbreviation = line.substring("Abbreviation: ".length());
                } else if (line.startsWith("StudyField: ")) {
                    studyField = StudyField.valueOf(line.substring("StudyField: ".length()));
                } else if (line.isEmpty() && name != null && abbreviation != null && studyField != null) {
                    Faculty faculty = new Faculty(name, abbreviation, studyField);
                    faculties.add(faculty);
                    name = null;
                    abbreviation = null;
                    studyField = null;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading faculty information from the file: " + e.getMessage());

        }

        return faculties;
    }

    public void saveStudents(Vector<Student> students){

        clearFile(studentFile);
        for(Student student:students){
            try {
                FileWriter fileWriter = new FileWriter(studentFile, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                bufferedWriter.newLine();
                bufferedWriter.write("First Name: " + student.firstName);
                bufferedWriter.newLine();
                bufferedWriter.write("Last Name: " + student.lastName);
                bufferedWriter.newLine();
                bufferedWriter.write("Email: " + student.email);
                bufferedWriter.newLine();
                bufferedWriter.write("Status: " + student.status.toString());
                bufferedWriter.newLine();
                bufferedWriter.write("Enrollment Date: " + dateFormat.format(student.enrollementDate));
                bufferedWriter.newLine();
                bufferedWriter.write("Date of Birth: " + dateFormat.format(student.dateOfBirth));
                bufferedWriter.newLine();

                bufferedWriter.close();

//                System.out.println("Student information has been written to " + studentFile);

            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error writing student information to the file: " + e.getMessage());

            }
        }
        try{
            FileWriter fileWriter = new FileWriter(studentFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public  Vector<Student> readStudent( Vector<Student> students) {

        try (FileReader fileReader = new FileReader(studentFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            String firstName = null;
            String lastName= null;
            String email = null;
            String enrollementDate = null;
            String dateOfBirth = null;
            Boolean status = null;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("First Name: ")) {
                    firstName = line.substring("First Name: ".length());
                } else if (line.startsWith("Last Name: ")) {
                    lastName = line.substring("Last Name: ".length());
                } else if (line.startsWith("Email: ")) {
                    email = line.substring("Email: ".length());
                }else if (line.startsWith("Status: ")) {
                    status = Boolean.valueOf(line.substring("Status: ".length()));
                }else if (line.startsWith("Enrollment Date: ")) {
                    enrollementDate = line.substring("Enrollment Date: ".length());
                }else if (line.startsWith("Date of Birth: ")) {
                    dateOfBirth = line.substring("Date of Birth: ".length());

                } else if (line.isEmpty() && firstName != null && lastName != null && email != null) {
                    Student student = new Student(firstName, lastName, dateOfBirth, email, status, enrollementDate);
                    students.add(student);
                    firstName = null;
                    lastName= null;
                    email = null;
                    enrollementDate = null;
                    dateOfBirth = null;
                    status = null;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading student information from the file: " + e.getMessage());

        }

        return students;
    }



    private void clearFile(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


