package addressBook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookContact {

    Scanner sc = new Scanner(System.in);
    ArrayList<AddressBookContact> book;
    ArrayList<ArrayList<AddressBookContact>> addBooks = new ArrayList<ArrayList<AddressBookContact>>();

    String firstName;
    String lastName;
    String address;
    String state;
    String city;
    String email;
    String zipCode;
    String phoneNumber;

    public void addAnotherContactBook() {
        addBooks.add(book = new ArrayList<AddressBookContact>());
    }

    public void printTotalNumberOfAddressBook() {
        System.out.println(addBooks.size());
    }

    public void whichAddressBookToPrint() {
        System.out.print("Enter index of address book :- ");
        int number = sc.nextInt();
        for (int i = 0; i < addBooks.get(number).size(); i++) {
            System.out.println("Contact " + (i + 1) + "\n");
            System.out.println((addBooks.get(number)).get(i).firstName);
            System.out.println((addBooks.get(number)).get(i).lastName);
            System.out.println((addBooks.get(number)).get(i).address);
            System.out.println((addBooks.get(number)).get(i).state);
            System.out.println((addBooks.get(number)).get(i).city);
            System.out.println((addBooks.get(number)).get(i).email);
            System.out.println((addBooks.get(number)).get(i).zipCode);
            System.out.println((addBooks.get(number)).get(i).phoneNumber);
            System.out.println((addBooks.get(number)).get(i).email);
        }
    }

    AddressBookContact() {

    }

    AddressBookContact(String firstName, String lastName, String address, String state, String city, String email, String zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void scan() {
        System.out.print("Enter your first name :- ");
        firstName = sc.nextLine();
        System.out.print("Enter your last name :- ");
        lastName = sc.nextLine();
        System.out.print("Enter your address :- ");
        address = sc.nextLine();
        System.out.print("Enter your city :- ");
        city = sc.nextLine();
        System.out.print("Enter your state:- ");
        state = sc.nextLine();
        System.out.print("Enter your zip code :- ");
        zipCode = sc.nextLine();
        System.out.print("Enter your phone number :- ");
        phoneNumber = sc.nextLine();
        System.out.print("Enter your email :- ");
        email = sc.nextLine();
    }

    public int duplicate() {
        for (int i = 0; i < book.size(); i++) {
            if (firstName.equals(book.get(i).firstName)) {
                return 1;
            }
        }
        return 0;
    }

    public void searchPeopleThroughState() {
        System.out.println("Enter State's name which you want to search :- ");
        String nameState = sc.nextLine();
        for (int i = 0; i < addBooks.size(); i++) {
            for (int j = 0; j < addBooks.get(i).size(); j++) {
                if (addBooks.get(i).get(j).state.equals(nameState)) {
                    printBookThroughBookObject(addBooks.get(i).get(j));
                }
            }
        }
    }

    public void countPeopleThroughState() {
        int count = 0;
        System.out.println("Enter State's name which you want to search :- ");
        String nameState = sc.nextLine();
        for (int i = 0; i < addBooks.size(); i++) {
            for (int j = 0; j < addBooks.get(i).size(); j++) {
                if (addBooks.get(i).get(j).state.equals(nameState))
                    count++;
            }
        }
        System.out.println("Number of people living in this state is :- " + count);
    }

    public void addContact() {
        System.out.print("Enter first name ,checking if its duplicate or not :- ");
        String fName = sc.nextLine();
        Optional<AddressBookContact> book1 = book.stream().filter(book -> book.firstName.equals(fName)).findFirst();
        if (book1.isPresent()) {
            System.out.println("Book is present");
        } else {
            System.out.println("Not an duplicate");
            scan();
            AddressBookContact ab = new AddressBookContact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
            book.add(ab);
            System.out.println("Book added succesfully");
        }
    }

    public void editContact() {
        System.out.print("Enter name of person whose you want to edit :- ");
        String name = sc.nextLine();
        int i;
        for (i = 0; i < book.size(); i++) {
            if (book.get(i).firstName.equals(name)) {
                scan();
                break;
            }
        }
        AddressBookContact abc = new AddressBookContact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
        book.set(i, abc);
    }

    public void deleteContact() {
        System.out.print("Enter name of person whose you want to delete :- ");
        String name = sc.nextLine();
        int i;
        for (i = 0; i < book.size(); i++) {
            if (book.get(i).firstName.equals(name)) {
                book.remove(i);
                break;
            }
        }

    }

    public void printBook() {
        for (int i = 0; i < book.size(); i++) {
            System.out.println("Contact " + (i + 1) + "\n");
            System.out.println("fname " + book.get(i).firstName);
            System.out.println("lname " + book.get(i).lastName);
            System.out.println("add " + book.get(i).address);
            System.out.println("city " + book.get(i).city);
            System.out.println("state " + book.get(i).state);
            System.out.println("zipcode " + book.get(i).zipCode);
            System.out.println("phonenum " + book.get(i).phoneNumber);
            System.out.println("EMAIL " + book.get(i).email);
            System.out.println();
        }
    }

    int contact = 1;

    public void printBookThroughBookObject(AddressBookContact addressBookContact) {
        System.out.println("Contact " + (contact++) + "\n");
        System.out.println(addressBookContact.firstName);
        System.out.println(addressBookContact.lastName);
        System.out.println(addressBookContact.address);
        System.out.println(addressBookContact.city);
        System.out.println(addressBookContact.state);
        System.out.println(addressBookContact.zipCode);
        System.out.println(addressBookContact.phoneNumber);
        System.out.println(addressBookContact.email);
        System.out.println();
    }

    public void searchPeopleWithState() {
        System.out.print("Enter firstName of the person :- ");
        String fname = sc.nextLine();

        System.out.print("Enter State of the person :- ");
        String stateName = sc.nextLine();

        List<AddressBookContact> searchPeopleWithStateList = book.stream().filter(book -> (book.firstName.equals(fname) && book.state.equals(stateName))).collect(Collectors.toList());
        for (int i = 0; i < searchPeopleWithStateList.size(); i++)
            printingWithObjectOfBook(searchPeopleWithStateList.get(i));
    }

    int cal = 1;

    public void printingWithObjectOfBook(AddressBookContact tpBOOK) {
        System.out.println("contact no. " + cal);
        System.out.println(tpBOOK.firstName);
        System.out.println(tpBOOK.lastName);
        System.out.println(tpBOOK.address);
        System.out.println(tpBOOK.city);
        System.out.println(tpBOOK.state);
        System.out.println(tpBOOK.zipCode);
        System.out.println(tpBOOK.phoneNumber);
        System.out.println(tpBOOK.email);
        System.out.println();
        cal++;

    }

    public void peopleViewWithTheState() {
        System.out.print("Enter State to view people in it :- ");
        String stateName = sc.nextLine();

        List<AddressBookContact> peopleViewWithStateList = book.stream().filter(book -> stateName.equals(book.city)).collect(Collectors.toList());
        System.out.println(peopleViewWithStateList.size());
        for (int i = 0; i < peopleViewWithStateList.size(); i++)
            printingWithObjectOfBook(peopleViewWithStateList.get(i));
    }

    public void countOfPeopleInState() {
        System.out.print("Enter State to count people in it :- ");
        String stateName = sc.nextLine();
        System.out.print("Total number of people in the state is :- ");
        System.out.println(book.stream().filter(book -> stateName.equals(book.city)).count());
    }

    public void sortedBookAlphabetically() {
        AddressBookContact[] sortedList = new AddressBookContact[book.size()];
        for (int j = 0; j < book.size() - 1; j++) {
            for (int i = 0; i < book.size() - 1; i++) {
                AddressBookContact temp = null;
                int compare = (book.get(i).firstName).compareTo((book.get(i + 1).firstName));
                if (compare <= 0) {
                    sortedList[i] = book.get(i);
                } else if (compare > 0) {
                    sortedList[i] = book.get(i + 1);
                    sortedList[i + 1] = book.get(i);
                    i++;
                    if (book.get(i + 1) != null) {
                        sortedList[i + 1] = book.get(i + 1);
                    }
                }

            }
        }
        List<AddressBookContact> sort = Arrays.asList(sortedList);

        System.out.println("Now printing book with sort" + sort.size());
        for (AddressBookContact bk : sort) {
            printingWithObjectOfBook(bk);
        }

    }

    public void sortEntryThroughCityStateZip() {
        System.out.println("You want to sort with? \n1. City\n2. State\n3. ZipCode");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                sortyByCity();
                break;
            case 2:
                sortyByState();
                break;
            case 3:
                sortyByZipCode();
                break;
        }
    }

    public void sortyByCity() {
        AddressBookContact[] sortedCityList = new AddressBookContact[book.size()];
        for (int j = 0; j < book.size() - 1; j++) {
            for (int i = 0; i < book.size() - 1; i++) {
                int compare = (book.get(i).city).compareTo((book.get(i + 1).city));
                if (compare <= 0) {
                    sortedCityList[i] = book.get(i);
                } else if (compare > 0) {
                    sortedCityList[i] = book.get(i + 1);
                    sortedCityList[i + 1] = book.get(i);
                    i++;
                    if (book.get(i + 1) != null) {
                        sortedCityList[i + 1] = book.get(i + 1);
                    }
                }

            }
        }
        List<AddressBookContact> sortCity = Arrays.asList(sortedCityList);

        System.out.println("Now printing book with sort City " + sortCity.size());
        for (AddressBookContact bk : sortCity) {
            printingWithObjectOfBook(bk);
        }
    }

    public void sortyByState() {
        AddressBookContact[] sortedStateList = new AddressBookContact[book.size()];
        for (int j = 0; j < book.size() - 1; j++) {
            for (int i = 0; i < book.size() - 1; i++) {
                int compare = (book.get(i).state).compareTo((book.get(i + 1).state));
                if (compare <= 0) {
                    sortedStateList[i] = book.get(i);
                } else if (compare > 0) {
                    sortedStateList[i] = book.get(i + 1);
                    sortedStateList[i + 1] = book.get(i);
                    i++;
                    if (book.get(i + 1) != null) {
                        sortedStateList[i + 1] = book.get(i + 1);
                    }
                }

            }
        }
        List<AddressBookContact> sortState = Arrays.asList(sortedStateList);

        System.out.println("Now printing book with sort City " + sortState.size());
        for (AddressBookContact bk : sortState) {
            printingWithObjectOfBook(bk);
        }
    }

    public void sortyByZipCode() {
        AddressBookContact[] sortedZipList = new AddressBookContact[book.size()];
        for (int j = 0; j < book.size() - 1; j++) {
            for (int i = 0; i < book.size() - 1; i++) {
                int compare = (book.get(i).zipCode).compareTo((book.get(i + 1).zipCode));
                if (compare <= 0) {
                    sortedZipList[i] = book.get(i);
                } else if (compare > 0) {
                    sortedZipList[i] = book.get(i + 1);
                    sortedZipList[i + 1] = book.get(i);
                    i++;
                    if (book.get(i + 1) != null) {
                        sortedZipList[i + 1] = book.get(i + 1);
                    }
                }

            }
        }
        List<AddressBookContact> sortZip = Arrays.asList(sortedZipList);

        System.out.println("Now printing book with sort City " + sortZip.size());
        for (AddressBookContact bk : sortZip) {
            printingWithObjectOfBook(bk);
        }
    }

    public void printInFile() throws IOException {
        Path path = Paths.get("C:\\Nikhil\\bridgelabz\\Address_Book\\TextFile\\AddressBook.txt");
        if (Files.exists(path)) {
            System.out.println("Files exists so writing on the file");
        } else {
            System.out.println("File does not exist so creatin a file");
            Files.createFile(path);
        }

        ArrayList<String> data = new ArrayList<>();
        data.add("First_Name Last_Name Address City State ZIpCode PhoneNumber Email");
        for (int i = 0; i < book.size(); i++) {
            data.add(book.get(i).firstName + "\t\t" + book.get(i).lastName + "\t" + book.get(i).address + "\t" +
                    book.get(i).city + "\t" + book.get(i).state + "\t" + book.get(i).zipCode +
                    "\t" + book.get(i).phoneNumber + "\t" + book.get(i).email);
        }
        Files.write(path, data);
        System.out.println("Data written on file Succesfully");
    }

    public void readingInFile() throws IOException {
        Path path = Paths.get("C:\\Nikhil\\bridgelabz\\Address_Book\\TextFile\\AddressBook.txt");
        List<String> data = new ArrayList<>();
        if (Files.exists(path)) {
            System.out.println("Files exists so reading the file");
            data = Files.readAllLines(path);
            System.out.println(data);
        } else {
            System.out.println("File does not exists");
        }

    }
}
