package addressBook;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) throws IOException, CsvValidationException {
        System.out.println("Welcome to address book");
        AddressBookContact abc = new AddressBookContact();
        Scanner sc = new Scanner(System.in);
        abc.addAnotherContactBook();
        int flag=0;
        while (flag == 0){
            System.out.println("****MENU**** \n1. Add a contact\n2. Edit a contact \n3. Delete a contact \n4. Print all the contacts" +
                    "\n5. Add Another AddressBook \n6. Show Number Of AddressBook \n7. Printing different contact books \n8. Exit" +
                    "\n9. Search through state \n10. Count of contact in a state \n11. Count people in a state " +
                    "\n12. Sort book \n13. Sort Entry through city" + "\n14. Printing in a file" + "\n15. Reading from file"
            +"\n16. Write in csv file" +"\n17. Read a csv file");
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
                    abc.searchPeopleThroughState();
                    break;
                case 10:
                    abc.countPeopleThroughState();
                    break;
                case 11:
                    abc.countOfPeopleInState();
                    break;
                case 12:
                    abc.sortedBookAlphabetically();
                    break;
                case 13:
                    abc.sortEntryThroughCityStateZip();
                case 14:
                    abc.printInFile();
                    break;
                case 15:
                    abc.readingInFile();
                    break;
                case 16:
                    abc.writeDataWithCSV();
                    break;
                case 17:
                    abc.readFromCSVFile();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
