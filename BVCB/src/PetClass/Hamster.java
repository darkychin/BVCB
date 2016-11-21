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
public class Hamster extends Pet implements Serializable {

    private String HamsterID;
    private int Hamster_Counter;

    public void setHamster_Counter(int h) {
        Hamster_Counter = h;
    }

    public int getHamster_Counter() {
        return Hamster_Counter;
    }

    public void setHamsterID(String h) {
        HamsterID = h;
    }

    public String getHamsterID() {
        return HamsterID;
    }

    public void readList(List<Hamster> HamsterList) {
        try {
            FileInputStream inputStream = new FileInputStream("Hamster.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                Hamster tmp = (Hamster) objectInputFile.readObject();
                HamsterList.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading binary file.", "File Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeList(List<Hamster> HamsterList) {
        try {
            FileOutputStream outputStream = new FileOutputStream("Hamster.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (Hamster h : HamsterList) {
                objectOutputFile.writeObject(h);
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

    public void delete(List<Hamster> HamsterList, String PetID) {

        for (Iterator<Hamster> iter = HamsterList.listIterator(); iter.hasNext();) {
            Hamster h = iter.next();
            if (h.getHamsterID().equals(PetID)) {
                HamsterList.remove(h);
            }
        }
        writeList(HamsterList);

    }

    @Override
    public void readCounter() {
        int counter = 0;
        try {
            File file = new File("Hamster Counter.txt");
            Scanner inputFile = new Scanner(file);

            //while (inputFile.hasNext()){}
            // Read the next name.
            String tmp = inputFile.nextLine();
            counter = Integer.parseInt(tmp);
            counter++;
            writeCounter(counter);
            setHamster_Counter(counter);
        } catch (IOException ioe) {

        }

    }

    @Override
    public void writeCounter(int counter) {

        String tmp = Integer.toString(counter);
        try {
            PrintWriter outputFile = new PrintWriter("Hamster Counter.txt");
            outputFile.println(tmp);

            outputFile.close();
        } catch (IOException IO) {

        }
    }

    @Override
    public void generateID(int number) {
        if (number < 10) {
            HamsterID = "H00" + Integer.toString(number);
        } else if (number < 100) {
            HamsterID = "H0" + Integer.toString(number);
        } else {
            HamsterID = "H" + Integer.toString(number);
        }
    }

}
