public class Bill {
    // attributes
    final static int MAX_INVOICE = 100;
    static int nextBillNr = 10000;
    double discount;

    // association
    Client billReceiver;

    // Array of MAX_INVOICE cells
    Invoice[] billInvoice = new Invoice[Bill.MAX_INVOICE];
    int invoiceNumber = 0;
    final int billnumber;

    // constructor
    Bill(Client receiver){
        this.billReceiver = receiver;
        this.billnumber = Bill.calcNextBillNr();
    }

    static int calcNextBillNr(){
        return Bill.nextBillNr++;
    }

    void setDiscount(final double newDiscount){
        this.discount = newDiscount;
    }


    void addInvoice(final Invoice invoice){
        if(invoiceNumber>= Bill.MAX_INVOICE){
            System.out.print("Maximal limitation of invoices are reached");
            return;
        }
        this.billInvoice[invoiceNumber] = invoice;
        this.invoiceNumber++;
    }

    void setInvoice(final Client receiver){
        this.billReceiver = receiver;
    }

    /** 
     * @return double
     */
    double getDiscount(){
        return this.discount;
    }

    
    /** 
     * @return Client
     */
    Client getBillReceiver(){
        return this.billReceiver;
    }

    
    /** 
     * @return double
     */
    double calcNetPrice(){
        double sum = 0;
        for(int i=0;i<this.invoiceNumber;i++){
            Invoice iv = this.billInvoice[i];
            sum += iv.calculateSum();
        }
        return sum * (1 - this.getDiscount());
    }

        /** 
     * @return double
     */
    double calcVAT(){
        double sum = 0;
        for(int i = 0; i < this.invoiceNumber; i++){
            Invoice iv = this.billInvoice[i];
            sum += iv.calculateSum() * iv.getArticle().getTax();
        }
        return sum * (1 - this.getDiscount());
    }
    
    /** 
     * @return double
     */
    double calcBrutPrice(){
        return this.calcNetPrice() + this.calcVAT();
    }

    void getBillInformation(){
        System.out.println("To:");
        System.out.println(this.billReceiver.name);
        System.out.println(this.billReceiver.address);
        System.out.print("Article: ");
        for(int i=0;i<invoiceNumber;i++){
            Invoice iv = this.billInvoice[i];
            System.out.print(iv.getNumber());
            System.out.print("x Nr. ");
            System.out.print(iv.getArticle().getArticleNr());
            System.out.print(" ");
            System.out.println(iv.getArticle().getDescription());
        }
        System.out.println("Net: ");
        System.out.println(this.calcNetPrice());
        System.out.println("VAT: ");
        System.out.println(this.calcVAT());
        System.out.println("Total amount: ");
        System.out.println(this.calcBrutPrice());
    }
}
