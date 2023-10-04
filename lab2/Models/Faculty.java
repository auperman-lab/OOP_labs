package lab2.Models;

import java.util.Vector;

public class Faculty {
    public String name;
    public String abbreviation;
    public StudyField studyField;

    public Faculty(String name, String abbreviation, StudyField studyField){
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
    }


    public void displayFaculty(){
        System.out.println("Name : "+this.name);
        System.out.println("Abbreviation : "+this.abbreviation);
        System.out.println("Field : "+this.studyField+"\n");
    }





}
