public class Bill {
    // attributes
    double amount = 0;
    double tax;
    double discount;

    // association
    Client billReceiver;

    // methods
    void setDiscount(final double newDiscount){
        this.discount = newDiscount;
    }

    void setTax(final double newTax){
        this.tax = newTax;
    }

    void addInvoice(final int quantity, final double singlePrice){
        this.amount += quantity * singlePrice;
    }

    void setInvoice(final Client receiver){
        this.billReceiver = receiver;
    }

    double getAmount(){
        return this.amount;
    }

    double getTax(){
        return this.tax;
    }

    double getDiscount(){
        return this.discount;
    }

    Client getBillReceiver(){
        return this.billReceiver;
    }

    double calcNetPrice(){
        return this.getAmount() * (1- this.getDiscount());
    }

    double totalAmount(){
        return this.calcNetPrice() * this.getTax();
    }

    void getBillInformation(){
        System.out.println("To:");
        System.out.println(this.billReceiver.name);
        System.out.println(this.billReceiver.address);
        System.out.print("Net: ");
        System.out.println(this.calcNetPrice());
        System.out.println("Tax: ");
        System.out.println(this.getTax());
        System.out.println("Total amount: ");
        System.out.println(this.totalAmount());
    }
}
