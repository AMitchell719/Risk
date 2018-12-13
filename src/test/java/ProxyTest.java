import org.junit.Test;
import junit.framework.TestCase;

public class ProxyTest extends TestCase{

    User user = new User(20);

    @Test
    public void testPurchaseCard() {
        assertEquals(17, user.purchaseCard());
    }

    @Test
    public void testPurchaseUndo() {
        assertEquals(15, user.purchaseUndo());
    }

    @Test
    public void testTransferCredit() {
        assertEquals(20, user.transferCredit());

    }

    @Test
    public void testGetCredit() {
        assertEquals(20, user.getCredit());
    }
}
