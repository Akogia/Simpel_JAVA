public class Client {
    // attributes
    String name;
    String address;
    String email;


    // constructor
    Client(final String name, final String address){
        this.setAddress(address);
        this.setName(name);
    }

    Client(final String name, final String address, final String email){
        this.setAddress(address);
        this.setName(name);
        this.setEmail(email);
    }

    // methods
    void setName(final String newName){
        this.name = newName;
    }
    
    void setAddress(final String newAddress){
        this.address = newAddress;
    }
    
    void setEmail(final String newEmail){
        this.email = newEmail;
    }

    String getName(){
        return this.name;
    }

    String getAddress(){
        return this.address;
    }

    String getEmail(){
        return this.email;
    }
}
