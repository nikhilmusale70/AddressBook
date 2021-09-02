package addressBook;

import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to address book");
        AddressBookContact abc = new AddressBookContact();
        Scanner sc = new Scanner(System.in);
        int flag=0;
        while (flag == 0){
            System.out.println("****MENU**** \n1. Add a contact\n2. Edit a contact \n3. Delete a contact \n4. Print all the contacts\n5. Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    abc.addContact();
                    break;
                case 2:
                    abc.editContact();
                    break;
                case 3:
                    abc.deleteContact();
                    break;
                case 4:
                    abc.printBook();
                    break;
                case 5:
                    flag =1;
                    break;
            }
        }
    }
}
