/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonClass;

import BusinessClass.Boarding;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.joda.time.LocalTime;

/**
 *
 * @author Chin
 */
public class BoardingStaff extends Admin implements Serializable {

    public void overwriteBoarding(List<Boarding> BoardingList, String BoardingID, String LastFed, String Status) {

        for (Boarding boarding : BoardingList) {
            if (boarding.getBoardingID().equals(BoardingID)) {
                boarding.setL_Fed(LastFed);
                boarding.setStatus(Status);
            }
            boarding.writeList(BoardingList);
        }

    }

    public void deleteBoarding(List<Boarding> BoardingList, String BoardingID) {
        Iterator<Boarding> iter_boarding = BoardingList.iterator();
        while (iter_boarding.hasNext()) {
            Boarding temp_boarding = iter_boarding.next();
            if (BoardingID.equals(temp_boarding.getBoardingID())) {
                iter_boarding.remove();
            }
            temp_boarding.writeList(BoardingList);
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

    @Override
    public void generateID(int number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
