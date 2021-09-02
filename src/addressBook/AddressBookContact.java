package addressBook;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void addAnotherContactBook(){
        addBooks.add(book = new ArrayList<AddressBookContact>());
    }

    public void printTotalNumberOfAddressBook(){
        System.out.println(addBooks.size());
    }

    public void whichAddressBookToPrint(){
        System.out.print("Enter index of address book :- ");
        int number = sc.nextInt();
        for (int i=0; i<addBooks.get(number).size() ;i++) {
            System.out.println("Contact " + (i+1) +"\n");
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

    AddressBookContact(){

    }

    AddressBookContact(String firstName, String lastName, String address, String state, String city, String email, String zipCode, String phoneNumber){
        this.firstName = firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;
        this.phoneNumber=phoneNumber;
        this.email= email ;
    }

    public void scan(){
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

    public int duplicate(){
        for (int i=0; i<book.size(); i++) {
            if (firstName.equals(book.get(i).firstName)){
                return 1;
            }
        }
        return 0;
    }

    public void searchPeopleThroughState(){
        System.out.println("Enter State's name which you want to search :- ");
        String nameState = sc.nextLine();
        for (int i=0; i<addBooks.size();i++){
            for (int j=0; j<addBooks.get(i).size(); j++){
                if (addBooks.get(i).get(j).state.equals(nameState)){
                    printBookThroughBookObject(addBooks.get(i).get(j));
                }
            }
        }
    }

    public void addContact(){
        System.out.println("Enter the details of contact :- ");
        scan();
        if (duplicate()==1) {
            System.out.println("Sorry the contact already exists, thus the contact cannot be added");
        }
        else {
            AddressBookContact ab = new AddressBookContact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
            book.add(ab);
        }
    }

    public void editContact(){
        System.out.print("Enter name of person whose you want to edit :- ");
        String name = sc.nextLine();
        int i;
        for (i=0 ; i<book.size(); i++){
            if (book.get(i).firstName.equals(name)){
                scan();
                break;
            }
        }
        AddressBookContact abc = new AddressBookContact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
        book.set(i,abc);
    }

    public void deleteContact(){
        System.out.print("Enter name of person whose you want to delete :- ");
        String name = sc.nextLine();
        int i;
        for (i=0 ; i<book.size(); i++){
            if (book.get(i).firstName.equals(name)){
                book.remove(i);
                break;
            }
        }

    }

    public void printBook(){
        for (int i=0; i<book.size(); i++){
            System.out.println("Contact "+(i+1) +"\n");
            System.out.println(book.get(i).firstName);
            System.out.println(book.get(i).lastName);
            System.out.println(book.get(i).address);
            System.out.println(book.get(i).city);
            System.out.println(book.get(i).state);
            System.out.println(book.get(i).zipCode);
            System.out.println(book.get(i).phoneNumber);
            System.out.println(book.get(i).email);
            System.out.println();
        }
    }

    int contact = 1;

    public void printBookThroughBookObject(AddressBookContact addressBookContact){
        System.out.println("Contact "+(contact++) +"\n");
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

}
