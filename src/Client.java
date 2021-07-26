public class Client {
    // attributes
    String name;
    String address;


    // constructor
    Client(final String name, final String address){
        this.setAddress(address);
        this.setName(name);
    }

    // methods
    void setName(final String newName){
        this.name = newName;
    }
    
    void setAddress(final String newAddress){
        this.address = newAddress;
    }

    String getName(){
        return this.name;
    }

    String getAddress(){
        return this.address;
    }
}
