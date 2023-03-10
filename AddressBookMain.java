package com.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {

        AddressBookOperation operate = new AddressBookOperation();
        Scanner sc = new Scanner(System.in);
        int continueFlag;
        do {
            System.out.print("\n-------------");
            System.out.print("\n### Address Book Menu ###");
            System.out.print("\n-------------");
            System.out.print("\n1.Add Contact \n2.Edit Contact \n3.Delete Contact \n4.Display Address Book\n5.Search Person");
            System.out.print("\n\nChoose your option : ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    operate.addContact();
                    break;
                case 2:
                    operate.editContact();
                    break;
                case 3:
                    operate.deleteContact();
                    break;
                case 4:
                    operate.showAddrBook();
                    break;
                case 5:
                    operate.searchPerson();
                    break;
                default:
                    System.out.print("\nInvalid option");
            }
            System.out.print("\n\nDo you want to continue? Press 1 : ");
            continueFlag = sc.nextInt();

        } while (continueFlag == 1);

        System.out.print("\nThank you for using Address Book System !!");
        sc.close();
    }


}