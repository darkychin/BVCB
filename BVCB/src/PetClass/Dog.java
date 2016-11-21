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
public class Dog extends Pet implements Serializable {

    private String DogID;
    private int Dog_Counter;

    public void setDog_Counter(int d) {
        Dog_Counter = d;
    }

    public int getDog_Counter() {
        return Dog_Counter;
    }

    public void setDogID(String d) {
        DogID = d;
    }

    public String getDogID() {
        return DogID;
    }

    public void readList(List<Dog> DogList) {
        try {
            FileInputStream inputStream = new FileInputStream("Dog.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                Dog tmp = (Dog) objectInputFile.readObject();
                DogList.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading binary file.", "File Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeList(List<Dog> DogList) {
        try {
            FileOutputStream outputStream = new FileOutputStream("Dog.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (Dog d : DogList) {
                objectOutputFile.writeObject(d);
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

    public void delete(List<Dog> DogList, String PetID) {

        for (Iterator<Dog> iter = DogList.listIterator(); iter.hasNext();) {
            Dog d = iter.next();
            if (d.getDogID().equals(PetID)) {
                DogList.remove(d);
            }
        }
        writeList(DogList);

    }

    @Override
    public void readCounter() {
        int counter = 0;
        try {
            File file = new File("Dog Counter.txt");
            Scanner inputFile = new Scanner(file);

            //while (inputFile.hasNext()){}
            // Read the next name.
            String tmp = inputFile.nextLine();
            counter = Integer.parseInt(tmp);
            counter++;
            writeCounter(counter);
            setDog_Counter(counter);
        } catch (IOException ioe) {

        }

    }

    @Override
    public void writeCounter(int counter) {

        String tmp = Integer.toString(counter);
        try {
            PrintWriter outputFile = new PrintWriter("Dog Counter.txt");
            outputFile.println(tmp);

            outputFile.close();
        } catch (IOException IO) {

        }
    }

    @Override
    public void generateID(int number) {
        if (number < 10) {
            DogID = "D00" + Integer.toString(number);
        } else if (number < 100) {
            DogID = "D0" + Integer.toString(number);
        } else {
            DogID = "D" + Integer.toString(number);
        }
    }

}
