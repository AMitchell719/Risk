import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {

    Dice dice;

    @Before
    public void setup() {
        dice = new Dice();
    }

    @Test
    public void testRoll() {
        int result = dice.getFaceValue();
        Assert.assertTrue(1 <= result && result <= 6);
        Assert.assertTrue(result != 0);
    }
}
