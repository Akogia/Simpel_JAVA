public class Article {
    long articleNr;
    String description;
    double price;
    double tax;

    // constructor
    Article (final long articleNr, final String description, final double price, double tax){
        this.setPrice(price);
        this.setArticleNr(articleNr);
        this.setDescription(description);
        this.setTax(tax);
    }

    /** 
     * @param newNr
     */
    void setArticleNr(long newNr){
        this.articleNr = newNr;
    }

        /** 
     * @param tax
     */
    void setTax(double newTax){
        this.tax = newTax;
    }

    double getTax(){
        return this.tax;
    }

    
    /** 
     * @param newDescription
     */
    void setDescription(String newDescription){
        this.description = newDescription;
    }

    
    /** 
     * @param newPrice
     */
    void setPrice(double newPrice){
        this.price = newPrice;
    }

    
    /** 
     * @return int
     */
    public long getArticleNr(){
        return this.articleNr;
    }

    
    /** 
     * @return String
     */
    public String getDescription(){
        return this.description;
    }

    
    /** 
     * @return double
     */
    public double getPrice(){
        return this.price;
    }

    //public void getArticleInformation(){
    //    System.out.println("Article ");
    //    System.out.println(this.getDescription());
    //    System.out.println("Nr: ");
    //    System.out.println(this.getArticleNr());
    //    System.out.println("price: ");
    //    System.out.println(this.getPrice());
    //}
}
