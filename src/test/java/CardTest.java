import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

    Card card;
    Territory territory;

    @Before
    public void setup(){
        territory = new Territory("Brazil");
        card = new Card("Infantry", territory);
    }

    @Test
    public void testCard() {
        Assert.assertEquals(card.getType(), "Infantry");
    }

    @Test
    public void testGetName(){
        Assert.assertEquals(card.getName(), "Brazil");
    }
}
