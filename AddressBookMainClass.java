package com.addressbook;

import java.util.*;

public class AddressBookMainClass {
    private static Scanner sc = new Scanner(System.in);
    private static AddressBook addressbookValue = new AddressBook();

    private static AddressBookMainClass addressbooks = new AddressBookMainClass();
    private Map<String, AddressBook> addressBookSystem = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program\n");

        addressbooks.addContacts();

    }

    public void addContacts() {

        System.out.println("Enter your choice");
        System.out.println(
                "1 : Add new contact    2 : Edit contact  3 : Delete contact  4: Add Multiple Contacts 5: Display Contacts");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:

                List<Contact> contacts = new ArrayList<>();
                System.out.println("Enter Your Address Book name ");
                String addresBookname = sc.next();

                System.out.println("Enter the First Name");
                String firstName = sc.next();

                System.out.println("Enter the Last Name");
                String lastName = sc.next();

                System.out.println("Enter the Address Name");
                String address = sc.next();

                System.out.println("Enter the City Name");
                String city = sc.next();

                System.out.println("Enter the State Name");
                String state = sc.next();

                System.out.println("Enter the Zip Name");
                int zip = sc.nextInt();

                System.out.println("Enter the PhoneNumber");
                long phoneNumber = sc.nextLong();

                System.out.println("Enter the email");
                String email = sc.next();

                Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                contacts.add(contact);
                addressbookValue.setContacts(contacts);
                addressBookSystem.put(addresBookname, addressbookValue);
                addressbooks.addContacts();

                break;
            case 2:
                System.out.println("Enter Your Address Book name ");
                String findAddressBook = sc.next();

                System.out.println("Enter the name of user to Edit");
                String nameToEdit = sc.next();

                System.out.println("Enter the First Name");
                String editFirstName = sc.next();

                System.out.println("Enter the Last Name");
                String editLastName = sc.next();

                System.out.println("Enter the Address Name");
                String editAddress = sc.next();

                System.out.println("Enter the City Name");
                String editCity = sc.next();

                System.out.println("Enter the State Name");
                String editState = sc.next();

                System.out.println("Enter the Zip Name");
                int editZip = sc.nextInt();

                System.out.println("Enter the PhoneNumber");
                long editPhoneNumber = sc.nextLong();

                System.out.println("Enter the email");
                String editEmail = sc.next();
                addressbooks.editContact(findAddressBook, nameToEdit, editFirstName, editLastName, editAddress, editCity,
                        editState, editZip, editPhoneNumber, editEmail);
                addressbooks.addContacts();

            case 3:
                System.out.println("Enter Your Address Book name ");
                String yourBookname = sc.next();
                System.out.println("Enter the person Name");
                String deletename = sc.next();

                addressbooks.deleteContactDetails(deletename, yourBookname);
                addressbooks.addContacts();
                break;
            case 4:

                addressbooks.addMultipleContacts();
                addressbooks.addContacts();
                break;
            case 5:
                addressbooks.displayContacts(addressBookSystem);
                addressbooks.addContacts();
                break;
            default:
                System.out.println("Please Enter correct choice");
        }

    }

    public void editContact(String findAddressBook, String name, String editFirstName, String editLastName,
                            String editAddress, String editCity, String editState, int editZip, long editPhoneNumber,
                            String editEmail) {

        AddressBook addressbook = new AddressBook();

        AddressBook addressbookdetails = addressBookSystem.get(findAddressBook);
        List<Contact> contactDetails = addressbookdetails.getContacts();
        for (int i = 0; i <= contactDetails.size() - 1; i++) {

            Contact contactperson = contactDetails.get(i);
            if (contactperson.getFirstName().equals(name)) {

                contactperson.setFirstName(editFirstName);
                contactperson.setLastName(editLastName);
                contactperson.setAddress(editAddress);
                contactperson.setCity(editCity);
                contactperson.setPhoneNumber(editPhoneNumber);
                contactperson.setState(editState);
                contactperson.setZip(editZip);
                contactperson.setEmail(editEmail);
                contactDetails.set(i, contactperson);
                addressbook.setContacts(contactDetails);
                addressBookSystem.put(findAddressBook, addressbook);
            }
        }
        addressbooks.displayContacts(addressBookSystem);
    }

    public void displayContacts(Map<String, AddressBook> addressBookSystem) {

        for (Map.Entry<String, AddressBook> set : addressBookSystem.entrySet()) {

            AddressBook values = set.getValue();
            List<Contact> contactDetails = values.getContacts();

            for (int i = 0; i <= contactDetails.size() - 1; i++) {
                Contact contactperson = contactDetails.get(i);
                if (!contactperson.getFirstName().equals("")) {

                    System.out.println("Conatct Details :");
                    System.out.println("Book  Name --- " + set.getKey());
                    System.out.println("FirstName :" + contactperson.getFirstName() + "      LastName :"
                            + contactperson.getLastName() + "     Address :" + contactperson.getAddress()
                            + "      City :" + contactperson.getCity() + "       State :" + contactperson.getState()
                            + "     Zip :" + contactperson.getZip() + "     Phone Number :"
                            + contactperson.getPhoneNumber());
                } else {

                    System.out.println("No Conatct Details available :");
                }
            }
        }

    }

    public void deleteContactDetails(String name, String yourBookname) {

        AddressBook addressbook = new AddressBook();

        AddressBook values = addressBookSystem.get(yourBookname);
        List<Contact> contactDetails = values.getContacts();

        for (int i = 0; i <= contactDetails.size() - 1; i++) {
            Contact contactperson = contactDetails.get(i);
            if (contactperson.getFirstName().equals(name)) {
                contactDetails.remove(i);
                addressbook.setContacts(contactDetails);
                addressBookSystem.put(yourBookname, addressbook);
            }
        }

        System.out.println("Contact deleted Successfully");
    }

    public void addMultipleContacts() {

        List<Contact> contacts = new ArrayList<>();
        System.out.println("Enter Your Address Book name ");
        String findAddressBook = sc.next();

        System.out.println("Enter the First Name");
        String firstName = sc.next();

        System.out.println("Enter the Last Name");
        String lastName = sc.next();

        System.out.println("Enter the Address Name");
        String address = sc.next();

        System.out.println("Enter the City Name");
        String city = sc.next();

        System.out.println("Enter the State Name");
        String state = sc.next();

        System.out.println("Enter the Zip Name");
        int zip = sc.nextInt();

        System.out.println("Enter the PhoneNumber");
        long phoneNumber = sc.nextLong();

        System.out.println("Enter the email");
        String email = sc.next();
        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        contacts.add(contact);

        addtoOurAdrressBook(contact, findAddressBook);

        System.out.println("Do you want add one more Contact Details");
        System.out.println("1 :Yes     2 :No");
        int choice = sc.nextInt();
        switch (choice) {

            case 1:
                addressbooks.addMultipleContacts();
                break;
            case 2:
                addressbooks.displayContacts(addressBookSystem);
                addressbooks.addContacts();
                break;
            default:
                System.out.println("Please Enter correct choice");

        }

        addressbooks.displayContacts(addressBookSystem);
        addressbooks.addContacts();

    }

    public void addtoOurAdrressBook(Contact contact, String addressBookName) {
        List<Contact> contactsLis = new ArrayList<>();
        AddressBook Addressvalues = new AddressBook();
        boolean isKeyPresent = addressBookSystem.containsKey(addressBookName);
        if (isKeyPresent) {
            AddressBook values = addressBookSystem.get(addressBookName);
            addressBookSystem.get(addressBookName);
            List<Contact> contactDetails = values.getContacts();
            contactDetails.add(contact);
            values.setContacts(contactDetails);
            addressBookSystem.put(addressBookName, values);
        } else {
            contactsLis.add(contact);
            Addressvalues.setContacts(contactsLis);
            addressBookSystem.put(addressBookName, Addressvalues);
        }
    }

}