/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessClass;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author Chin
 */
public class Boarding implements Serializable{
    private String BoardingID, CusID, CusName, PetID, PetName, Species, Allergies,Sicknesslvl,Status, LastFed;
    private int BoardingCounter;

    public int getBoardingCounter() {
        return BoardingCounter;
    }

    public void setBoardingCounter(int BoardingCounter) {
        this.BoardingCounter = BoardingCounter;
    }

    
    public String getBoardingID() {
        return BoardingID;
    }

    public void setBoardingID(String BoardingID) {
        this.BoardingID = BoardingID;
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public String getPetID() {
        return PetID;
    }

    public void setPetID(String PetID) {
        this.PetID = PetID;
    }

    public String getPetName() {
        return PetName;
    }

    public void setPetName(String PetName) {
        this.PetName = PetName;
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

    public void setAllergies(String Allergies) {
        this.Allergies = Allergies;
    }

    public String getSicknesslvl() {
        return Sicknesslvl;
    }

    public void setSicknesslvl(String Sicknesslvl) {
        this.Sicknesslvl = Sicknesslvl;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public String getL_Fed(){
        return LastFed;
    }
    public void setL_Fed(String L_Fed){
        this.LastFed= L_Fed;
    }
    
    public void readList(List<Boarding> list) {
        try {
            FileInputStream inputStream = new FileInputStream("Boarding.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                Boarding tmp = (Boarding) objectInputFile.readObject();
                list.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading binary file.", "File Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeList(List<Boarding> list) {
        try {
            FileOutputStream outputStream = new FileOutputStream("Boarding.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (Boarding boarding : list) {
                objectOutputFile.writeObject(boarding);
            }
            objectOutputFile.flush();
            objectOutputFile.close();
        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Input error.", "File Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readCounter() {
        int counter = 0;
        try {
            File file = new File("Boarding Counter.txt");
            Scanner inputFile = new Scanner(file);
            String tmp = inputFile.nextLine();
            counter = Integer.parseInt(tmp);
            counter++;
            writeCounter(counter);
            setBoardingCounter(counter);
        } catch (IOException ioe) {

        }
    }

    public void writeCounter(int counter) {

        String tmp = Integer.toString(counter);
        try {
            PrintWriter outputFile = new PrintWriter("Boarding Counter.txt");
            outputFile.println(tmp);

            outputFile.close();
        } catch (IOException IO) {

        }
    }

    public void generateID(int number) {
        try {
            if (number < 10) {
                BoardingID = "B00" + Integer.toString(number);
            } else if (number < 100) {
                BoardingID = "B0" + Integer.toString(number);
            } else {
                BoardingID = "B" + Integer.toString(number);
            }
        } catch (Exception e) {

        }
    }
}
