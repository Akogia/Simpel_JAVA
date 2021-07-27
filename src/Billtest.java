import org.junit.Test;

public class Billtest extends junit.framework.TestCase{
    Bill b;

    public void setUp(){
        Client c = new Client("Hannah Hannah","street 125, SimCity");
        b = new Bill(c);
    }
    @Test
    public void testDiscountByNewBill(){
        assertEquals("0€ by new client without discount", 0.0, b.getDiscount());
    }

    @Test
    public void testDiscountValue(){
        b.setDiscount(0.1);
        assertEquals("Discount should be ", 0.1, b.getDiscount());
    }
    
}
