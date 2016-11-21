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
public class Rabbit extends Pet implements Serializable {

    private String RabbitID;
    private int Rabbit_Counter;

    public void setRabbit_Counter(int r) {
        Rabbit_Counter = r;
    }

    public int getRabbit_Counter() {
        return Rabbit_Counter;
    }

    public void setRabbitID(String r) {
        RabbitID = r;
    }

    public String getRabbitID() {
        return RabbitID;
    }

    public void readList(List<Rabbit> RabbitList) {
        try {
            FileInputStream inputStream = new FileInputStream("Rabbit.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                Rabbit tmp = (Rabbit) objectInputFile.readObject();
                RabbitList.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading binary file.", "File Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeList(List<Rabbit> RabbitList) {
        try {
            FileOutputStream outputStream = new FileOutputStream("Rabbit.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (Rabbit i : RabbitList) {
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

    public void delete(List<Rabbit> RabbitList, String PetID) {

        for (Iterator<Rabbit> iter = RabbitList.listIterator(); iter.hasNext();) {
            Rabbit r = iter.next();
            if (r.getRabbitID().equals(PetID)) {
                RabbitList.remove(r);
            }
        }
        writeList(RabbitList);

    }

    @Override
    public void readCounter() {
        int counter = 0;
        try {
            File file = new File("Rabbit Counter.txt");
            Scanner inputFile = new Scanner(file);

            //while (inputFile.hasNext()){}
            // Read the next name.
            String tmp = inputFile.nextLine();
            counter = Integer.parseInt(tmp);
            counter++;
            writeCounter(counter);
            setRabbit_Counter(counter);
        } catch (IOException ioe) {

        }

    }

    @Override
    public void writeCounter(int counter) {

        String tmp = Integer.toString(counter);
        try {
            PrintWriter outputFile = new PrintWriter("Rabbit Counter.txt");
            outputFile.println(tmp);

            outputFile.close();
        } catch (IOException IO) {

        }
    }

    @Override
    public void generateID(int number) {
        if (number < 10) {
            RabbitID = "R00" + Integer.toString(number);
        } else if (number < 100) {
            RabbitID = "R0" + Integer.toString(number);
        } else {
            RabbitID = "R" + Integer.toString(number);
        }
    }

}
