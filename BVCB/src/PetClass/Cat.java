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
public class Cat extends Pet implements Serializable {

    private String CatID;
    private int Cat_Counter;

    public void setCat_Counter(int c) {
        Cat_Counter = c;
    }

    public int getCat_Counter() {
        return Cat_Counter;
    }

    public void setCatID(String c) {
        CatID = c;
    }

    public String getCatID() {
        return CatID;
    }

    /*public void createBinaryFile(){
     final Formatter x;
     try
     {
     x= new Formatter("Cat.dat");
     }
     catch(Exception e){
     JOptionPane.showMessageDialog(null,"Unable to create binary file.","File Error",JOptionPane.ERROR_MESSAGE);
     }
     }
    
     public void createCounterFile(){
     final Formatter x;
     try
     {
     x= new Formatter("Cat Counter.txt");
     x.format("%d", 0);
     x.close();
     }
     catch(Exception e){
     JOptionPane.showMessageDialog(null,"Unable to create text file.","File Error",JOptionPane.ERROR_MESSAGE);
     }
     }*/
    public void readList(List<Cat> CatList) {
        try {
            FileInputStream inputStream = new FileInputStream("Cat.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                Cat tmp = (Cat) objectInputFile.readObject();
                CatList.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading binary file.", "File Error", JOptionPane.ERROR_MESSAGE);
            //createBinaryFile();
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void writeList(List<Cat> CatList) {
        try {
            FileOutputStream outputStream = new FileOutputStream("Cat.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (Cat c : CatList) {
                objectOutputFile.writeObject(c);
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

    public void delete(List<Cat> CatList, String PetID) {

        for (Iterator<Cat> iter = CatList.listIterator(); iter.hasNext();) {
            Cat c = iter.next();
            if (c.getCatID().equals(PetID)) {
                CatList.remove(c);
            }
        }
        writeList(CatList);

    }

    @Override
    public void readCounter() {
        int counter = 0;
        try {
            File file = new File("Cat Counter.txt");
            Scanner inputFile = new Scanner(file);

            //while (inputFile.hasNext()){}
            // Read the next name.
            String tmp = inputFile.nextLine();
            counter = Integer.parseInt(tmp);
            counter++;
            writeCounter(counter);
            setCat_Counter(counter);
        } catch (IOException ioe) {
            //createCounterFile();
        }

    }

    @Override
    public void writeCounter(int counter) {

        String tmp = Integer.toString(counter);
        try {
            PrintWriter outputFile = new PrintWriter("Cat Counter.txt");
            outputFile.println(tmp);

            outputFile.close();
        } catch (IOException IO) {

        }
    }

    @Override
    public void generateID(int number) {
        if (number < 10) {
            CatID = "C00" + Integer.toString(number);
        } else if (number < 100) {
            CatID = "C0" + Integer.toString(number);
        } else {
            CatID = "C" + Integer.toString(number);
        }
    }

}
