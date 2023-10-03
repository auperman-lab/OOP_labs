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

    public Student(String firstName, String lastName, String dateOfBirth, String email, boolean status, String enrollementDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.enrollementDate = dateFormat.parse(enrollementDate);
            this.dateOfBirth = dateFormat.parse(dateOfBirth);

        } catch (java.text.ParseException e) {
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
