/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonClass;

import BusinessClass.Appointment;
import BusinessClass.Boarding;
import PetClass.Cat;
import PetClass.Dog;
import PetClass.Hamster;
import PetClass.Lizard;
import PetClass.Rabbit;
import static Screens.ReceptionistMenu.CatList;
import static Screens.ReceptionistMenu.DogList;
import static Screens.ReceptionistMenu.HamsterList;
import static Screens.ReceptionistMenu.LizardList;
import static Screens.ReceptionistMenu.RabbitList;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Chin
 */
public class Receptionist extends Admin implements Serializable {

    public String createCustomer(List<Customer> CustomerList, String F_name, String L_name, String Gender, String Address, String ContactNo, String Email, String DOB) {

        Customer customer = new Customer();

        customer.readCounter();
        int c = customer.getCus_Counter();
        customer.generateID(c);
        customer.setF_name(F_name);
        customer.setL_name(L_name);
        customer.setGender(Gender);
        customer.setAddress(Address);
        customer.setContactNo(ContactNo);
        customer.setEmail(Email);
        customer.setDOB(DOB);

        CustomerList.add(customer);
        customer.writeList(CustomerList);

        return customer.getCustomerID();
    }

    public String createPet(List<Cat> CatList, List<Dog> DogList, List<Hamster> HamsterList, List<Lizard> LizardList, List<Rabbit> RabbitList,
            String OwnerID, String PetName, String Sex, String Species, int Age, String Allergies, boolean Boarding) {
        String PetID;
        if (Species.equals("Cat")) {

            Cat cat = new Cat();

            cat.setOwnerID(OwnerID);
            cat.readCounter();
            int c = cat.getCat_Counter();
            cat.generateID(c);
            PetID = cat.getCatID();
            cat.setName(PetName);
            cat.setSex(Sex);
            cat.setAge(Age);
            cat.setAllergies(Allergies);
            cat.setBoarding(Boarding);

            CatList.add(cat);
            cat.writeList(CatList);

        } else if (Species.equals("Dog")) {

            Dog dog = new Dog();

            dog.setOwnerID(OwnerID);
            dog.readCounter();
            int c = dog.getDog_Counter();
            dog.generateID(c);
            PetID = dog.getDogID();
            dog.setName(PetName);
            dog.setSex(Sex);
            dog.setAge(Age);
            dog.setAllergies(Allergies);
            dog.setBoarding(Boarding);

            DogList.add(dog);
            dog.writeList(DogList);

        } else if (Species.equals("Hamster")) {

            Hamster hamster = new Hamster();

            hamster.setOwnerID(OwnerID);
            hamster.readCounter();
            int c = hamster.getHamster_Counter();
            hamster.generateID(c);
            PetID = hamster.getHamsterID();
            hamster.setName(PetName);
            hamster.setSex(Sex);
            hamster.setAge(Age);
            hamster.setAllergies(Allergies);
            hamster.setBoarding(Boarding);

            HamsterList.add(hamster);
            hamster.writeList(HamsterList);

        } else if (Species.equals("Lizard")) {

            Lizard lizard = new Lizard();

            lizard.setOwnerID(OwnerID);
            lizard.readCounter();
            int c = lizard.getLizard_Counter();
            lizard.generateID(c);
            PetID = lizard.getLizardID();
            lizard.setName(PetName);
            lizard.setSex(Sex);
            lizard.setAge(Age);
            lizard.setAllergies(Allergies);
            lizard.setBoarding(Boarding);

            LizardList.add(lizard);
            lizard.writeList(LizardList);

        } else {

            Rabbit rabbit = new Rabbit();

            rabbit.setOwnerID(OwnerID);
            rabbit.readCounter();
            int c = rabbit.getRabbit_Counter();
            rabbit.generateID(c);
            PetID = rabbit.getRabbitID();
            rabbit.setName(PetName);
            rabbit.setSex(Sex);
            rabbit.setAge(Age);
            rabbit.setAllergies(Allergies);
            rabbit.setBoarding(Boarding);

            RabbitList.add(rabbit);
            rabbit.writeList(RabbitList);

        }
        return PetID;
    }

    public void createApp(List<Appointment> AppoinmentList, String CustomerID, String CustomerName,
            String PetID, String PetName, String Date, String Time, String VetID, String VetName) {

        Appointment app = new Appointment();

        app.readCounter();
        int a = app.getAppCounter();
        app.generateID(a);
        app.setAppCustomerID(CustomerID);
        app.setAppCustomerName(CustomerName);
        app.setAppPetID(PetID);
        app.setAppPetName(PetName);
        app.setAppDate(Date);
        app.setAppTime(Time);
        app.setAppVetID(VetID);
        app.setAppVetName(VetName);

        AppoinmentList.add(app);
        app.writeList(AppoinmentList);
    }

    public void createBoarding(List<Boarding> BoardingList, String CustomerID, String CustomerName, String PetID, String PetName, String Species, String Allergies, String Sicknesslvl) {

        Boarding boarding = new Boarding();

        boarding.readCounter();
        int a = boarding.getBoardingCounter();
        boarding.generateID(a);
        boarding.setCusID(CustomerID);
        boarding.setCusName(CustomerName);
        boarding.setPetID(PetID);
        boarding.setPetName(PetName);
        boarding.setSpecies(Species);
        boarding.setAllergies(Allergies);
        boarding.setSicknesslvl(Sicknesslvl);

        BoardingList.add(boarding);
        boarding.writeList(BoardingList);
    }

    public void overwriteCustomer(List<Customer> CustomerList, String CustomerID, String F_name, String L_name, String Gender, String Address, String ContactNo, String Email, String DOB) {
        for (Customer customer : CustomerList) {
            Customer temp = customer;
            if (temp.getCustomerID().equals(CustomerID)) {
                temp.setF_name(F_name);
                temp.setL_name(L_name);
                temp.setGender(Gender);
                temp.setAddress(Address);
                temp.setContactNo(ContactNo);
                temp.setEmail(Email);
                temp.setDOB(DOB);
            }
            customer.writeList(CustomerList);
        }
    }

    public void overwritePet(List<Cat> CatList, List<Dog> DogList, List<Hamster> HamsterList, List<Lizard> LizardList, List<Rabbit> RabbitList,
            String PetID, String PetName, String Sex, String Species, int PetAge, String Allergies, boolean Boarding) {

        if (Species.equals("Cat")) {
            for (Cat cat : CatList) {
                Cat temp = cat;
                if (PetID.equals(temp.getCatID())) {
                    temp.setName(PetName);
                    temp.setSex(Sex);
                    temp.setAge(PetAge);
                    temp.setAllergies(Allergies);
                    temp.setBoarding(Boarding);
                }
                cat.writeList(CatList);
            }

        } else if (Species.equals("Dog")) {
            for (Dog dog : DogList) {
                Dog temp = dog;
                if (PetID.equals(temp.getDogID())) {
                    temp.setName(PetName);
                    temp.setSex(Sex);
                    temp.setAge(PetAge);
                    temp.setAllergies(Allergies);
                    temp.setBoarding(Boarding);
                }
                dog.writeList(DogList);
            }

        } else if (Species.equals("Hamster")) {
            for (Hamster hamster : HamsterList) {
                Hamster temp = hamster;
                if (PetID.equals(temp.getHamsterID())) {
                    temp.setName(PetName);
                    temp.setSex(Sex);
                    temp.setAge(PetAge);
                    temp.setAllergies(Allergies);
                    temp.setBoarding(Boarding);
                }
                hamster.writeList(HamsterList);
            }

        } else if (Species.equals("Lizard")) {

            for (Lizard lizard : LizardList) {
                Lizard temp = lizard;
                if (PetID.equals(temp.getLizardID())) {
                    temp.setName(PetName);
                    temp.setSex(Sex);
                    temp.setAge(PetAge);
                    temp.setAllergies(Allergies);
                    temp.setBoarding(Boarding);
                }
                lizard.writeList(LizardList);
            }

        } else {

            for (Rabbit rabbit : RabbitList) {
                Rabbit temp = rabbit;
                if (PetID.equals(temp.getRabbitID())) {
                    temp.setName(PetName);
                    temp.setSex(Sex);
                    temp.setAge(PetAge);
                    temp.setAllergies(Allergies);
                    temp.setBoarding(Boarding);
                }
                rabbit.writeList(RabbitList);
            }

        }
    }

    public void overwriteApp(List<Appointment> AppoinmentList, String AppID, String PetID, String Date, String Time, String VetID, String VetName) {
        for (Appointment app : AppoinmentList) {
            Appointment temp = app;
            if (temp.getAppID().equals(AppID)) {
                temp.setAppDate(Date);
                temp.setAppTime(Time);
                temp.setAppVetID(VetID);
                temp.setAppVetName(VetName);
            }
            app.writeList(AppoinmentList);
        }
    }

    public void deleteCustomer(List<Boarding> BoardingList, List<Customer> CustomerList,
            List<Cat> CatList, List<Dog> DogList, List<Hamster> HamsterList, List<Lizard> LizardList, List<Rabbit> RabbitList,
            String CustomerID) {

        Iterator<Customer> iter_Cus = CustomerList.iterator();
        while (iter_Cus.hasNext()) {
            Customer cus_temp = iter_Cus.next();
            if (CustomerID.equals(cus_temp.getCustomerID())) {

                Iterator<Cat> iter_Cat = CatList.iterator();
                while (iter_Cat.hasNext()) {
                    Cat cat_temp = iter_Cat.next();
                    if (CustomerID.equals(cat_temp.getOwnerID())) {
                        deleteBoarding(BoardingList, cat_temp.getCatID());
                        iter_Cat.remove();
                    }
                    cat_temp.writeList(CatList);
                }

                Iterator<Dog> iter_Dog = DogList.iterator();
                while (iter_Cat.hasNext()) {
                    Dog dog_temp = iter_Dog.next();
                    if (CustomerID.equals(dog_temp.getOwnerID())) {
                        deleteBoarding(BoardingList, dog_temp.getDogID());
                        iter_Dog.remove();
                    }
                    dog_temp.writeList(DogList);
                }

                Iterator<Hamster> iter_Hamster = HamsterList.iterator();
                while (iter_Hamster.hasNext()) {
                    Hamster hamster_temp = iter_Hamster.next();
                    if (CustomerID.equals(hamster_temp.getOwnerID())) {
                        deleteBoarding(BoardingList, hamster_temp.getHamsterID());
                        iter_Hamster.remove();
                    }
                    hamster_temp.writeList(HamsterList);
                }

                Iterator<Lizard> iter_Lizard = LizardList.iterator();
                while (iter_Lizard.hasNext()) {
                    Lizard lizard_temp = iter_Lizard.next();
                    if (CustomerID.equals(lizard_temp.getOwnerID())) {
                        deleteBoarding(BoardingList, lizard_temp.getLizardID());
                        iter_Lizard.remove();
                    }
                    lizard_temp.writeList(LizardList);
                }

                Iterator<Rabbit> iter_Rabbit = RabbitList.iterator();
                while (iter_Rabbit.hasNext()) {
                    Rabbit rabbit_temp = iter_Rabbit.next();
                    if (CustomerID.equals(rabbit_temp.getOwnerID())) {
                        deleteBoarding(BoardingList, rabbit_temp.getRabbitID());
                        iter_Rabbit.remove();
                    }
                    rabbit_temp.writeList(RabbitList);
                }
                iter_Cus.remove();
            }
            cus_temp.writeList(CustomerList);
        }

    }

    public void deletePet(List<Boarding> BoardingList, List<Cat> CatList, List<Dog> DogList, List<Hamster> HamsterList, List<Lizard> LizardList, List<Rabbit> RabbitList,
            String pet_ID) {
        switch (pet_ID.charAt(0)) {
            case 'C':
                Iterator<Cat> iter_Cat = CatList.iterator();
                while (iter_Cat.hasNext()) {
                    Cat cat_temp = iter_Cat.next();
                    if (pet_ID.equals(cat_temp.getCatID())) {
                        deleteBoarding(BoardingList, pet_ID);
                        iter_Cat.remove();
                    }
                    cat_temp.writeList(CatList);
                }
                break;
            case 'D':
                Iterator<Dog> iter_Dog = DogList.iterator();
                while (iter_Dog.hasNext()) {
                    Dog dog_temp = iter_Dog.next();
                    if (pet_ID.equals(dog_temp.getDogID())) {
                        deleteBoarding(BoardingList, pet_ID);
                        iter_Dog.remove();
                    }
                    dog_temp.writeList(DogList);
                }
                break;
            case 'H':
                Iterator<Hamster> iter_Hamster = HamsterList.iterator();
                while (iter_Hamster.hasNext()) {
                    Hamster hamster_temp = iter_Hamster.next();
                    if (pet_ID.equals(hamster_temp.getHamsterID())) {
                        deleteBoarding(BoardingList, pet_ID);
                        iter_Hamster.remove();
                    }
                    hamster_temp.writeList(HamsterList);
                }
                break;
            case 'L':
                Iterator<Lizard> iter_Lizard = LizardList.iterator();
                while (iter_Lizard.hasNext()) {
                    Lizard lizard_temp = iter_Lizard.next();
                    if (pet_ID.equals(lizard_temp.getLizardID())) {
                        deleteBoarding(BoardingList, pet_ID);
                        iter_Lizard.remove();
                    }
                    lizard_temp.writeList(LizardList);
                }
                break;
            case 'R':
                Iterator<Rabbit> iter_Rabbit = RabbitList.iterator();
                while (iter_Rabbit.hasNext()) {
                    Rabbit rabbit_temp = iter_Rabbit.next();
                    if (pet_ID.equals(rabbit_temp.getRabbitID())) {
                        deleteBoarding(BoardingList, pet_ID);
                        iter_Rabbit.remove();
                    }
                    rabbit_temp.writeList(RabbitList);
                }
                break;
        }
    }

    public void deleteBoarding(List<Boarding> BoardingList, String PetID) {
        Iterator<Boarding> iter_boarding = BoardingList.iterator();
        while (iter_boarding.hasNext()) {
            Boarding temp_boarding = iter_boarding.next();
            if (PetID.equals(temp_boarding.getPetID())) {
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
