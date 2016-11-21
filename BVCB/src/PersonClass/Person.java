/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonClass;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;

public abstract class Person implements Serializable {

    private String F_name, L_name, Gender, Address, ContactNo, Email, DOB, Name;
    int Age;

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String value) {
        F_name = value;
    }

    public String getL_name() {
        return L_name;
    }

    public void setL_name(String value) {
        L_name = value;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String value) {
        Gender = value;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String value) {
        Address = value;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String value) {
        ContactNo = value;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String value) {
        Email = value;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String value) {
        DOB = value;
    }

    public int getAge() {
        LocalDate Date1 = LocalDate.parse(DOB, DateTimeFormat.forPattern("dd/MM/yyyy"));
        LocalDate now = new LocalDate();
        Years Age_1 = Years.yearsBetween(Date1, now);
        Age = Age_1.getYears();
        return Age;
    }

    public String getName() {
        this.Name = getL_name() + " " + getF_name();
        return Name;
    }

    public void readList() {
    }

    ; 
    
    public void writeList() {
    }

    ;
    
    public void delete() {
    }

    ;
    
    public abstract void readCounter();

    public abstract void writeCounter(int counter);

    public abstract void generateID(int number);
}
