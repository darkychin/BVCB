/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonClass;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Chin
 */
public class Customer extends Person implements Serializable {

    private String CustomerID;
    private int Cus_Counter;

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String value) {
        CustomerID = value;
    }

    public int getCus_Counter() {
        return Cus_Counter;
    }

    public void setCus_Counter(int value) {
        Cus_Counter = value;
    }

    public void readList(List<Customer> list) {
        try {
            FileInputStream inputStream = new FileInputStream("Customer.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                Customer tmp = (Customer) objectInputFile.readObject();
                list.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading binary file.", "File Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeList(List<Customer> list) {
        try {
            FileOutputStream outputStream = new FileOutputStream("Customer.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (Customer c : list) {
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

    public void delete(List<Customer> CustomerList, int Counter) {

        for (Iterator<Customer> iter = CustomerList.listIterator(); iter.hasNext();) {
            Customer c = iter.next();
            if (Integer.toString(c.getCus_Counter()).equals(Counter)) {
                CustomerList.remove(c);
            }
        }
        writeList(CustomerList);

    }

    @Override
    public void readCounter() {
        int counter = 0;
        try {
            File file = new File("Customer Counter.txt");
            Scanner inputFile = new Scanner(file);

            //while (inputFile.hasNext()){}
            // Read the next name.
            String tmp = inputFile.nextLine();
            counter = Integer.parseInt(tmp);
            counter++;
            writeCounter(counter);
            setCus_Counter(counter);
        } catch (IOException ioe) {

        }
    }

    @Override
    public void writeCounter(int counter) {

        String tmp = Integer.toString(counter);
        try {
            PrintWriter outputFile = new PrintWriter("Customer Counter.txt");
            outputFile.println(tmp);

            outputFile.close();
        } catch (IOException IO) {

        }
    }

    @Override
    public void generateID(int number) {
        try {
            if (number < 10) {
                CustomerID = "C00" + Integer.toString(number);
            } else if (number < 100) {
                CustomerID = "C0" + Integer.toString(number);
            } else {
                CustomerID = "C" + Integer.toString(number);
            }
        } catch (Exception e) {

        }

    }

}
