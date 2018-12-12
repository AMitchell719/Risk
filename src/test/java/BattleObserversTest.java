import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import junit.framework.TestCase;

public class BattleObserversTest extends TestCase {

    BattleObservers BattleObserver = new BattleObservers();
    User p1 = new User("Aaron", 123);
    User p2 = new User("Chad", 123);

    @Test
    public void testAddObserver() {
        BattleObserver.addObserver(p1);
        BattleObserver.addObserver(p2);
        assertNotNull(BattleObserver);
    }

    @Test
    public void testRemoveObserver() {
        BattleObserver.addObserver(p1);
        BattleObserver.addObserver(p2);
        BattleObserver.removeObserver(p2);
        assertEquals(1, BattleObserver.notifyBattleObservers());
    }

    @Test
    public void testNotifyBattleObservers() {
        BattleObserver.addObserver(p1);
        BattleObserver.addObserver(p2);
        assertEquals(2, BattleObserver.notifyBattleObservers());
    }
}
