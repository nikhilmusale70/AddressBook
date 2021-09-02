package addressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookContact {
    ArrayList<AddressBookContact> book;
    String firstName;
    String lastName;
    String address;
    String state;
    String city;
    String email;
    String zipCode;
    String phoneNumber;

    AddressBookContact(){

    }

    AddressBookContact(String firstName, String lastName, String address, String state, String city, String email, String zipc, String phoneNumber){
        this.firstName = firstName;
        this.lastName=lastName;
        this.address=address;
        this.state=state;
        this.city=city;
        this.email= email ;
        this.zipCode=zipCode;
        this.phoneNumber=phoneNumber;
    }

    public void addContact(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the details of contact :- ");
        book = new ArrayList<AddressBookContact>();
        scan();
        AddressBookContact ab = new AddressBookContact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
        book.add(ab);
    }

    public void scan(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your first name :- ");
        firstName = sc.nextLine();
        System.out.println("Enter your last name :- ");
        lastName = sc.nextLine();
        System.out.println("Enter your address :- ");
        address = sc.nextLine();
        System.out.println("Enter your city :- ");
        city = sc.nextLine();
        System.out.println("Enter your state:- ");
        state = sc.nextLine();
        System.out.println("Enter your zip code :- ");
        zipCode = sc.nextLine();
        System.out.println("Enter your phone number :- ");
        phoneNumber = sc.nextLine();
        System.out.println("Enter your email :- ");
        email = sc.nextLine();
    }


}
