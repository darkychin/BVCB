/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonClass;

import BusinessClass.Consultation;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Chin
 */
public class Vet extends Admin implements Serializable {

    private String VetID, Expertise1, Expertise2;
    private int Vet_Counter;

    public String getVetID() {
        return VetID;
    }

    public void setVetID(String VetID) {
        this.VetID = VetID;
    }

    public int getVet_Counter() {
        return Vet_Counter;
    }

    public void setVet_Counter(int Vet_Counter) {
        this.Vet_Counter = Vet_Counter;
    }

    public String getExp1() {
        return Expertise1;
    }

    public void setExp1(String value) {
        Expertise1 = value;
    }

    public String getExp2() {
        return Expertise2;
    }

    public void setExp2(String value) {
        Expertise2 = value;
    }

    public void readList(List<Vet> list) {
        try {
            FileInputStream inputStream = new FileInputStream("Vet.dat");
            ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);

            while (true) {
                Vet tmp = (Vet) objectInputFile.readObject();
                list.add(tmp);
            }

        } catch (EOFException eofe) {

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error reading vet's binary file.", "File Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Vet file not found.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeList(List<Vet> list) {
        try {
            FileOutputStream outputStream = new FileOutputStream("Vet.dat");
            ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);

            for (Vet vet : list) {
                objectOutputFile.writeObject(vet);
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

    public void delete(List<Vet> vetList, int Counter) {

        for (Iterator<Vet> iter = vetList.listIterator(); iter.hasNext();) {
            Vet v = iter.next();
            if ((v.getVet_Counter() == Counter)) {
                vetList.remove(v);
            }
        }
        writeList(vetList);

    }

    @Override
    public void generateID(int number) {
        try {
            if (number < 10) {
                VetID = "V00" + Integer.toString(number);
            } else if (number < 100) {
                VetID = "V0" + Integer.toString(number);
            } else {
                VetID = "V" + Integer.toString(number);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void readCounter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeCounter(int counter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void saveCons(List<Consultation> ConsList, String appointmentID, String vetID, String petID, String prognosis, String diagnosis, String sicklvl, int fees) {
        Consultation cons = new Consultation();
        cons.setAppID(appointmentID);
        cons.setVetID(vetID);
        cons.setPetID(petID);
        cons.setProg(prognosis);
        cons.setDiag(diagnosis);
        cons.setSicklvl(sicklvl);
        cons.setFees(fees);
        ConsList.add(cons);
        cons.writeList(ConsList);
    }

    public void overwriteCons(List<Consultation> ConsList, String appoinmentID, String prognosis, String diagnogis, String sicklvl, int fees) {
        for (Consultation cons : ConsList) {
            if (cons.getAppID().equals(appoinmentID)) {
                cons.setProg(prognosis);
                cons.setDiag(diagnogis);
                cons.setSicklvl(sicklvl);
                cons.setFees(fees);
            }
            cons.writeList(ConsList);
        }
    }
}
