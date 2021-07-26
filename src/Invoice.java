public class Invoice {
    int number;
    Article article;

    // constructor
    Invoice(final int number, final Article article){
        this.setArticle(article);
        this.setNumber(number);
    }

    void setNumber(final int newNumber){
        this.number = newNumber;
    }

    void setArticle(final Article newArticle){
        this.article = newArticle;
    }

    double calculateSum(){
    return this.number * this.article.price;

    }

    int getNumber(){
        return this.number;
    }

    Article getArticle(){
        return this.article;
    }
}
