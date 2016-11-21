/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetClass;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public abstract class Pet implements Serializable {

    private String OwnerID,Name, Sex, Species, Allergies;
    private int Age;
    private boolean Boarding;

    public String getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(String value) {
        OwnerID = value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String value) {
        Name = value;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String value) {
        Sex = value;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String Species) {
        this.Species = Species;
    }

    public String getAllergies() {
        return Allergies;
    }

    public void setAllergies(String value) {
        Allergies = value;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int value) {
        Age = value;
    }

    public boolean getBoarding() {
        return Boarding;
    }

    public void setBoarding(boolean value) {
        Boarding = value;
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
