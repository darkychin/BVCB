/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetClass;

import java.io.*;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Chin
 */
public class Lizard extends Pet implements Serializable {

    private String LizardID;
    private int Lizard_Counter;

    public void setLizard_Counter(int i) {
        Lizard_Counter = i;
    }

    public int getLizard_Counter() {
        return Lizard_Counter;
    }

    public void setLizardID(String h) {
        LizardID = h;
    }

    public String getLizardID() {
        return LizardID;
    }

    public void readList(List<Lizard> LizardList) {
        try {
            FileInputStream inputStream = new FileInputStream("Lizard.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                Lizard tmp = (Lizard) objectInputFile.readObject();
                LizardList.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading binary file.", "File Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeList(List<Lizard> LizardList) {
        try {
            FileOutputStream outputStream = new FileOutputStream("Lizard.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (Lizard i : LizardList) {
                objectOutputFile.writeObject(i);
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

    public void delete(List<Lizard> LizardList, String PetID) {

        for (Iterator<Lizard> iter = LizardList.listIterator(); iter.hasNext();) {
            Lizard i = iter.next();
            if (i.getLizardID().equals(PetID)) {
                LizardList.remove(i);
            }
        }
        writeList(LizardList);

    }

    @Override
    public void readCounter() {
        int counter = 0;
        try {
            File file = new File("Lizard Counter.txt");
            Scanner inputFile = new Scanner(file);

            //while (inputFile.hasNext()){}
            // Read the next name.
            String tmp = inputFile.nextLine();
            counter = Integer.parseInt(tmp);
            counter++;
            writeCounter(counter);
        } catch (IOException ioe) {

        }

        setLizard_Counter(counter);
    }

    @Override
    public void writeCounter(int counter) {

        String tmp = Integer.toString(counter);
        try {
            PrintWriter outputFile = new PrintWriter("Lizard Counter.txt");
            outputFile.println(tmp);

            outputFile.close();
        } catch (IOException IO) {

        }
    }

    @Override
    public void generateID(int number) {
        if (number < 10) {
            LizardID = "L00" + Integer.toString(number);
        } else if (number < 100) {
            LizardID = "L0" + Integer.toString(number);
        } else {
            LizardID = "L" + Integer.toString(number);
        }
    }

}
