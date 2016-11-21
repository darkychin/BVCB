/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessClass;


import java.io.*;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Chin
 */
public class RotaTable implements Serializable {
    
    private String day, vet_name1, vet_name2, vet_name3;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getVet_name1() {
        return vet_name1;
    }

    public void setVet_name1(String vet_name1) {
        this.vet_name1 = vet_name1;
    }

    public String getVet_name2() {
        return vet_name2;
    }

    public void setVet_name2(String vet_name2) {
        this.vet_name2 = vet_name2;
    }

    public String getVet_name3() {
        return vet_name3;
    }

    public void setVet_name3(String vet_name3) {
        this.vet_name3 = vet_name3;
    }
    
    
    
    public void readList(List<RotaTable> RotaList) {
        try {
            FileInputStream inputStream = new FileInputStream("RotationTable.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                 RotaTable tmp = (RotaTable) objectInputFile.readObject();
                RotaList.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading binary file.", "File Error", JOptionPane.ERROR_MESSAGE);
            //createBinaryFile();
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void writeList(List<RotaTable> RotaList) {
        try {
            FileOutputStream outputStream = new FileOutputStream("RotationTable.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (RotaTable rotaTable : RotaList) {
                objectOutputFile.writeObject(rotaTable);
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
