/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessClass;

import org.joda.time.*;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Appointment implements Serializable{

    private int AppointmentCounter;
    private String AppointmentID;
    private String CustomerID;
    private String CustomerName;
    private String PetID;
    private String PetName;
    private String Date;
    private String Time;
    private String VetID;
    private String VetName;

    public int getAppCounter() {
        return AppointmentCounter;
    }

    public void setAppCounter(int AppointmentCounter) {
        this.AppointmentCounter = AppointmentCounter;
    }

    public String getAppID() {
        return AppointmentID;
    }

    public void setAppID(String AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    public String getAppCustomerID() {
        return CustomerID;
    }

    public void setAppCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getAppCustomerName() {
        return CustomerName;
    }

    public void setAppCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getAppPetID() {
        return PetID;
    }

    public void setAppPetID(String PetID) {
        this.PetID = PetID;
    }

    public String getAppPetName() {
        return PetName;
    }

    public void setAppPetName(String PetName) {
        this.PetName = PetName;
    }

    public String getAppDate() {
        return Date;
    }

    public void setAppDate(String Date) {
        this.Date = Date;
    }

    public String getAppTime() {
        return Time;
    }

    public void setAppTime(String Time) {
        this.Time = Time;
    }

    public String getAppVetID() {
        return VetID;
    }

    public void setAppVetID(String VetID) {
        this.VetID = VetID;
    }

    public String getAppVetName() {
        return VetName;
    }

    public void setAppVetName(String VetName) {
        this.VetName = VetName;
    }

    public void readList(List<Appointment> list) {
        try {
            FileInputStream inputStream = new FileInputStream("Appointment.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                Appointment tmp = (Appointment) objectInputFile.readObject();
                list.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading binary file.", "File Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "File not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeList(List<Appointment> list) {
        try {
            FileOutputStream outputStream = new FileOutputStream("Appointment.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (Appointment appointment : list) {
                objectOutputFile.writeObject(appointment);
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
            File file = new File("Appointment Counter.txt");
            Scanner inputFile = new Scanner(file);

            //while (inputFile.hasNext()){}
            // Read the next name.
            String tmp = inputFile.nextLine();
            counter = Integer.parseInt(tmp);
            counter++;
            writeCounter(counter);
            setAppCounter(counter);
        } catch (IOException ioe) {

        }
    }

    public void writeCounter(int counter) {

        String tmp = Integer.toString(counter);
        try {
            PrintWriter outputFile = new PrintWriter("Appointment Counter.txt");
            outputFile.println(tmp);

            outputFile.close();
        } catch (IOException IO) {

        }
    }

    public void generateID(int number) {
        try {
            if (number < 10) {
                AppointmentID = "AP00" + Integer.toString(number);
            } else if (number < 100) {
                AppointmentID = "AP0" + Integer.toString(number);
            } else {
                AppointmentID = "AP" + Integer.toString(number);
            }
        } catch (Exception e) {

        }
    }
}
