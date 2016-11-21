/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessClass;

import java.io.*;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Chin
 */
public class Consultation implements Serializable{
    private String AppointmentID, VetID, PetID, Diagnosis, Prognosis, Sicklvl;
    private int Fees;

    public String getAppID() {
        return AppointmentID;
    }

    public void setAppID(String AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    public String getVetID() {
        return VetID;
    }

    public void setVetID(String VetID) {
        this.VetID = VetID;
    }

    public String getPetID() {
        return PetID;
    }

    public void setPetID(String PetID) {
        this.PetID = PetID;
    }
    
    public String getDiag(){
        return Diagnosis;
    }
    public void setDiag(String value){
        Diagnosis = value;
    }
    
     public String getProg(){
        return Prognosis;
    }
    public void setProg(String value){
        Prognosis = value;
    }

    public String getSicklvl() {
        return Sicklvl;
    }

    public void setSicklvl(String Sicklvl) {
        this.Sicklvl = Sicklvl;
    }

    public int getFees() {
        return Fees;
    }

    public void setFees(int Fees) {
        this.Fees = Fees;
    }

    public void readList(List<Consultation> list) {
        try {
            FileInputStream inputStream = new FileInputStream("Consultation.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                Consultation tmp = (Consultation) objectInputFile.readObject();
                list.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading binary file.", "File Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeList(List<Consultation> list) {
        try {
            FileOutputStream outputStream = new FileOutputStream("Consultation.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (Consultation cons : list) {
                objectOutputFile.writeObject(cons);
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
    
    
}
