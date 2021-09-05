package addressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
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

    public void addContact(){
        System.out.print("Enter first name ,checking if its duplicate or not :- ");
        String fName = sc.nextLine();
        Optional<AddressBookContact> book1 = book.stream().filter(book -> book.firstName.equals(fName)).findFirst();
        if(book1.isPresent()){
            System.out.println("Book is present");
        }
        else {
            System.out.println("Not an duplicate");
            scan();
            AddressBookContact ab = new AddressBookContact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
            book.add(ab);
            System.out.println("Book added succesfully");
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
            System.out.println("fname "+book.get(i).firstName);
            System.out.println("lname "+book.get(i).lastName);
            System.out.println("add "+book.get(i).address);
            System.out.println("city "+book.get(i).city);
            System.out.println("state "+book.get(i).state);
            System.out.println("zipcode "+book.get(i).zipCode);
            System.out.println("phonenum "+book.get(i).phoneNumber);
            System.out.println("EMAIL "+book.get(i).email);
            System.out.println();
        }
    }

    public void searchPeopleWithState(){
        System.out.print("Enter firstName of the person :- ");
        String fname = sc.nextLine();

        System.out.print("Enter State of the person :- ");
        String stateName = sc.nextLine();

        List<AddressBookContact> searchPeopleWithStateList = book.stream().filter(book -> (book.firstName.equals(fname)&& book.state.equals(stateName))).collect(Collectors.toList());
        for (int i=0; i<searchPeopleWithStateList.size(); i++)
            printingWithObjectOfBook(searchPeopleWithStateList.get(i));
    }

    int cal=1;
    public void printingWithObjectOfBook(AddressBookContact tpBOOK){
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

    public void peopleViewWithTheState(){
        System.out.print("Enter State to view people in it :- ");
        String stateName = sc.nextLine();

        List<AddressBookContact> peopleViewWithStateList = book.stream().filter(book -> stateName.equals(book.city)).collect(Collectors.toList());
        System.out.println(peopleViewWithStateList.size());
        for (int i=0; i<peopleViewWithStateList.size(); i++)
            printingWithObjectOfBook(peopleViewWithStateList.get(i));
    }
}
