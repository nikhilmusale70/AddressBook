package addressBook;

public class AdressBookData {
    String firstName;
    String lastName;
    String address;
    String state;
    String city;
    String email;
    String zipCode;
    String phoneNumber;

    AdressBookData() {

    }

    AdressBookData(String firstName, String lastName, String address, String state, String city, String email, String zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
