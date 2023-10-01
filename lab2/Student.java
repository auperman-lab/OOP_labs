package lab2;

import java.text.ParseException;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class Student {

    String firstName;
    String lastName;
    String email;
    Date enrollementDate;
    Date dateOfBirth;

    Boolean status;

    public Student(String firstName, String lastName, String dateOfBirth, String abbreviation){
        this.firstName = firstName;
        this.lastName = lastName;

        this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+abbreviation+".utm.md";
        this.status = true;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateFormatted = dateFormat.format(new Date());
        try {
            this.enrollementDate = dateFormat.parse(currentDateFormatted);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        try {
            this.dateOfBirth = dateFormat.parse(dateOfBirth);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public void recordStudent(){
        String fileName = "student_records.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            bufferedWriter.write("First Name: " + this.firstName);
            bufferedWriter.newLine();
            bufferedWriter.write("Last Name: " + this.lastName);
            bufferedWriter.newLine();
            bufferedWriter.write("Email: " + this.email);
            bufferedWriter.newLine();
            bufferedWriter.write("Enrollment Date: " + dateFormat.format(enrollementDate));
            bufferedWriter.newLine();
            bufferedWriter.write("Date of Birth: " + dateFormat.format(dateOfBirth));
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            bufferedWriter.close();

            System.out.println("Student information has been written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void displayStudent(){
        System.out.println("First Name : "+this.firstName);
        System.out.println("Last Name : "+this.lastName);
        System.out.println("Email : "+this.email);
        System.out.println("Enrollement date : "+this.enrollementDate);
        System.out.println("Date of Birth : "+this.dateOfBirth);
    }


}
