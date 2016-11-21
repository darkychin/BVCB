/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonClass;

import BusinessClass.RotaTable;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Chin
 */
public class Manager extends Admin implements Serializable {
// create 8 vet and assign them with their counter
    //private String F_name,L_name,Gender,Address,ContactNo,Email,DOB;
    //int Age;
    
    public void registerVet(List<Vet> VetList, int VetCounter, String VetF_name, String VetL_name, String Gender, String Address, String ContactNo, String Email, String DOB,
            String Exp1, String Exp2) {
        Vet vet = new Vet();
        vet.setVet_Counter(VetCounter);
        vet.generateID(VetCounter);
        vet.setF_name(VetF_name);
        vet.setL_name(VetL_name);
        vet.setGender(Gender);
        vet.setAddress(Address);
        vet.setContactNo(ContactNo);
        vet.setEmail(Email);
        vet.setDOB(DOB);
        vet.setExp1(Exp1);
        vet.setExp2(Exp2);
        
        VetList.add(vet);
        vet.writeList(VetList);
    }
    
    public void saveRota(List<RotaTable> RotaList, String day, String vet1, String vet2, String vet3) {
        RotaTable rota_table = new RotaTable();
        rota_table.setDay(day);
        rota_table.setVet_name1(vet1);
        rota_table.setVet_name2(vet2);
        rota_table.setVet_name3(vet3);
        
        RotaList.add(rota_table);
        rota_table.writeList(RotaList);
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
