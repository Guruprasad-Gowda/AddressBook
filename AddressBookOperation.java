package com.addressbook;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AddressBookOperation {
/*
    HashMap<String, AddressBook> addrBookMap = new HashMap<>();

    public void addContact() {

        PersonContact contact = new PersonContact();
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIn which Address Book you want to add your contact? ");
        String addrBookName = sc.nextLine();

        System.out.print("\nEnter First Name  : ");
        String firstName = sc.nextLine();
        if (!isPersonExist(addrBookName, firstName)) {
            contact.setFirstName(firstName);

            System.out.print("\nEnter Last Name  : ");
            String lastName = sc.nextLine();
            contact.setLastName(lastName);

            System.out.print("\nEnter Address  : ");
            String address = sc.nextLine();
            contact.setAddress(address);

            System.out.print("\nEnter City  : ");
            String city = sc.nextLine();
            contact.setCity(city);

            System.out.print("\nEnter State  : ");
            String state = sc.nextLine();
            contact.setState(state);

            System.out.print("\nEnter Phone Number  : ");
            String phoneNo = sc.nextLine();
            contact.setPhoneNo(phoneNo);

            System.out.print("\nEnter E-mail  : ");
            String email = sc.nextLine();
            contact.setEmail(email);

            System.out.print("\nEnter Zip  : ");
            int zip = sc.nextInt();
            contact.setZip(zip);

            showContact(contact);

            sc.nextLine();

            addInAddrBook(addrBookName, contact);
            System.out.print("\n\nYour contact Added !");
        } else {
            System.out.print("\nContact already exist !");
        }
    }

    public boolean isPersonExist(String addrBookName, String searchName) {

        AddressBook tempAddrObj = getAddressBook(addrBookName);
        if (tempAddrObj == null) {
            return false;
        } else {
            PersonContact personObj = tempAddrObj.getPersonList().stream()
                    .filter(keyObj -> searchName.equals(keyObj.getFirstName()))
                    .findAny()
                    .orElse(null);
            if (personObj == null) {
                return false;
            } else {
                return true;
            }
        }
    }

    public void addInAddrBook(String addrBookName, PersonContact contact) {

        int flag = 1;

        for (String keyName : addrBookMap.keySet()) {

            AddressBook addrBookObj = addrBookMap.get(keyName);

            if (addrBookName.equals(addrBookObj.getAddrName())) {

                addrBookObj.addContactToList(contact);
                flag = 0;
            }
        }
        if (flag == 1) {

            AddressBook addrBook = new AddressBook(addrBookName);
            addrBook.addContactToList(contact);
            addrBookMap.put(addrBookName, addrBook);
        }
    }

    public void editContact() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the Address Book name : ");
        String addrName = sc.nextLine();

        if (getAddressBook(addrName) == null) {
            System.out.print("\nCouldn't find the Address Book..");
        } else {
            int flag = 1;
            System.out.print("\nEnter the Person's First name : ");
            String editName = sc.nextLine();
            for (PersonContact personObj : getAddressBook(addrName).getPersonList()) {
                if (editName.equals(personObj.getFirstName())) {
                    System.out.print("\n--------------");
                    System.out.print("\n***Update Menu***");
                    System.out.print("\n--------------");
                    System.out.print("\n1.Update Last Name \n2.Update Address \n3.Update City \n4.Update State \n5.Update Phone Number \n6.Update e-mail \n7.Update Zip");
                    System.out.print("\n\nChoose your option for Edit : ");
                    int editOption = sc.nextInt();
                    editContactDetails(editOption, editName, personObj);
                    flag = 0;
                }
            }
            if (flag == 1) {
                System.out.print("\nCouldn't find the contact...");
            } else {
                System.out.print("\nYour contact updated !");
            }
        }
    }

    public void deleteContact() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the Address Book name : ");
        String addrName = sc.nextLine();

        if (getAddressBook(addrName) == null) {
            System.out.print("\nCouldn't find the Address Book..");
        } else {
            int flag = 1;
            System.out.print("\nEnter the Person's First name : ");
            String delName = sc.nextLine();
            AddressBook tempAddrObj = getAddressBook(addrName);
            List<PersonContact> tempPerList = tempAddrObj.getPersonList();

            PersonContact ContactToDelete = null;

            for (PersonContact personObj : tempPerList) {
                if (delName.equals(personObj.getFirstName())) {
                    ContactToDelete = personObj;
                    flag = 0;
                }
            }
            if (flag == 1) {
                System.out.print("\ncouldn't find the contact..");
            } else {
                tempPerList.remove(ContactToDelete);
                System.out.print("\nYour contact deleted..");
            }
        }
    }

    public void editContactDetails(int editOption, String editName, PersonContact personObj) {

        Scanner sc = new Scanner(System.in);
        switch (editOption) {
            case 1:
                System.out.print("\nEnter your new Last Name : ");
                String firstName = sc.nextLine();
                personObj.setLastName(firstName);
                break;
            case 2:
                System.out.print("\nEnter your new Address : ");
                String address = sc.nextLine();
                personObj.setAddress(address);
                break;
            case 3:
                System.out.print("\nEnter your new City : ");
                String city = sc.nextLine();
                personObj.setCity(city);
                break;
            case 4:
                System.out.print("\nEnter your new State : ");
                String state = sc.nextLine();
                personObj.setState(state);
                break;
            case 5:
                System.out.print("\nEnter your new Phone Number : ");
                String phoneNo = sc.nextLine();
                personObj.setPhoneNo(phoneNo);
                break;
            case 6:
                System.out.print("\nEnter your new E-mail : ");
                String email = sc.nextLine();
                personObj.setEmail(email);
                break;
            case 7:
                System.out.print("\nEnter your new Zip : ");
                int zip = sc.nextInt();
                personObj.setZip(zip);
                break;
            default:
                System.out.print("\nInvalid option");
        }
    }

    public void searchPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the city : ");
        String city = sc.nextLine();

        List<PersonContact> personList = null;

        for (String keyName : addrBookMap.keySet()) {

            AddressBook addrBookObj = addrBookMap.get(keyName);

            if (personList == null) {
                personList = addrBookObj.getPersonList().stream()
                        .filter(person -> city.equals(person.getCity()))
                        .collect(Collectors.toList());
            } else {
                List<PersonContact> tempList = addrBookObj.getPersonList().stream()
                        .filter(person -> city.equals(person.getCity()))
                        .collect(Collectors.toList());
                personList.addAll(tempList);
            }
        }

        for (PersonContact person : personList) {
            showContact(person);
        }


    }

    public AddressBook getAddressBook(String addrName) {

        for (String keyName : addrBookMap.keySet()) {

            AddressBook addrBookObj = addrBookMap.get(keyName);

            if (addrName.equals(addrBookObj.getAddrName())) {
                return addrBookObj;
            }
        }
        return null;
    }

    public void showAddrBook() {

        for (String keyName : addrBookMap.keySet()) {

            AddressBook addrBookObj = addrBookMap.get(keyName);

            System.out.print("\nAddress Book Name : " + addrBookObj.getAddrName());
            for (PersonContact personObj : addrBookObj.getPersonList()) {

                showContact(personObj);
            }
        }
    }

    public void showContact(PersonContact contact) {

        System.out.print("\n-----------------");
        System.out.print("\nFirst Name  : " + contact.getFirstName());
        System.out.print("\nLast Name   : " + contact.getLastName());
        System.out.print("\nAddress     : " + contact.getAddress());
        System.out.print("\nCity        : " + contact.getCity());
        System.out.print("\nState       : " + contact.getState());
        System.out.print("\nPone Number : " + contact.getPhoneNo());
        System.out.print("\nE-mail      : " + contact.getEmail());
        System.out.print("\nZip         : " + contact.getZip());
    }*/

}