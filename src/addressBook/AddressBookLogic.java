package addressBook;

public class AddressBookLogic {
    String firstName;
    String lastName;
    String address;
    String state;
    String city;
    String emailId;
    String zipc;
    String phoneNumber;

    AddressBookLogic( String firstName, String lastName, String address, String state, String city, String emailId, String zipc, String phoneNumber){
        this.firstName = firstName;
        this.lastName=lastName;
        this.address=address;
        this.state=state;
        this.city=city;
        this.emailId= emailId ;
        this.zipc=zipc;
        this.phoneNumber=phoneNumber;
    }

}
