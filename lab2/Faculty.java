package lab2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Vector;

public class Faculty {
    String name;
    String abbreviation;
    StudyField studyField;
    Vector<Student> students = new Vector<>(2);

    public Faculty(String name, String abbreviation, StudyField studyField){
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
    }


    public void recordFaculty(){

        String fileName = "faculty_records.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.newLine();
            bufferedWriter.write("Name: " + this.name);
            bufferedWriter.newLine();
            bufferedWriter.write("Abbreviation: " + this.abbreviation);
            bufferedWriter.newLine();
            bufferedWriter.write("StudyField: "+ this.studyField.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();

            System.out.println("Faculty created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void displayFaculty(){
        System.out.println("Name : "+this.name);
        System.out.println("Abbreviation : "+this.abbreviation);
        System.out.println("Field : "+this.studyField);
    }


    public void enrollStudent(Student student){
        students.add(student);

    }



}
