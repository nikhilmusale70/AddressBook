package addressBook;

import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to address book");
        AddressBookContact abc = new AddressBookContact();
        Scanner sc = new Scanner(System.in);
        abc.addAnotherContactBook();
        int flag=0;
        while (flag == 0){
            System.out.println("****MENU**** \n1. Add a contact\n2. Edit a contact \n3. Delete a contact \n4. Print all the contacts" +
                    "\n5. Add Another AddressBook \n6. Show Number Of AddressBook \n7. Printing different contact books " +
                    "\n8. Exit \n9. Search people by name and state \n10 People view in state \n11. Count people in a state \n12. Sort book");
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
                    abc.addAnotherContactBook();
                    break;
                case 6:
                    abc.printTotalNumberOfAddressBook();
                    break;
                case 7:
                    abc.whichAddressBookToPrint();
                case 8:
                    flag =1;
                    break;
                case 9:
                    abc.searchPeopleWithState();
                    break;
                case 10:
                    abc.peopleViewWithTheState();
                    break;
                case 11:
                    abc.countOfPeopleInState();
                    break;
                case 12:
                    abc.sortedBookAlphabetically();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
