import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class BoardTest {

    Board board;
    User user;
    ArrayList<Territory> territories = new ArrayList<Territory>();
    Continent continent;
    Territory territory;

    @Before
    public void setup() throws Exception {
        board = new Board();
        board.setupBoard();
        user = new User("Aaron", 25);
        territory = new Territory("Alaska");
        continent = new Continent("South America", 2, territories);
    }

    @Test
    public void testGetContinents(){
        Assert.assertTrue(board.getContinents().size() == 6);
    }

    @Test
    public void testGetContinentName(){
        Assert.assertEquals(board.getContinentName("North America"), board.getContinentName("North America"));
    }

    @Test
    public void testGetBonusArmies(){
        Assert.assertTrue(board.getContinentName("North America").getBonusArmyAmount() == 5);
    }

    @Test
    public void testGetContainedTerritories(){
        Assert.assertTrue(board.getContinentName("North America").getTerritoriesOfContinent().size() == 9);
    }

    @Test
    public void testSetNumArmies(){
        board.getTerritoryName("Alaska").setNumArmies(100);
        Assert.assertEquals(board.getTerritoryName("Alaska").getArmyPower(), 100);
    }

    @Test
    public void testGetTerritoryName(){
        Territory test = board.getTerritoryName("Alaska");
        Assert.assertEquals(board.getTerritoryName("Alaska"), test);
    }

    @Test
    public void testSetUserOccupant(){
        board.getTerritoryName("Alaska").setOccupyingUser(user);
        Assert.assertEquals(board.getTerritoryName("Alaska").getUser().getUsername(), "Aaron");
    }

    @Test
    public void testGetOccupant(){
        board.getTerritoryName("Alaska").setOccupyingUser(user);
        Assert.assertEquals(board.getTerritoryName("Alaska").getUser(), user);
    }

    @Test
    public void testGetNumArmies(){
        board.getTerritoryName("Alaska").setNumArmies(100);
        Assert.assertEquals(board.getTerritoryName("Alaska").getArmyPower(), 100);
    }

    @Test
    public void testGetAdjacencies(){
        Assert.assertEquals(board.getTerritoryName("Yakutsk").getAdjacentTerritories().size(), 3);
    }

    @Test
    public void testCheckAdjacenciesTrue(){
        Assert.assertTrue(board.checkAdjacencies("Alaska", "Alberta"));
    }

    @Test
    public void testCheckAdjacenciesFalse(){
        Assert.assertFalse(board.checkAdjacencies("Alaska", "Yakutsk"));
    }

    @Test
    public void testUndoFortify(){
        board.getTerritoryName("Greenland").setNumArmies(20);
        board.undoFortify("Greenland", 2);
        Assert.assertEquals(board.getNumArmies("Greenland"), 18);
    }

    @Test
    public void testUndoAttack(){
        board.getTerritoryName("Alberta").setNumArmies(20);
        board.undoAttack("Alberta", 2);
        Assert.assertEquals(board.getNumArmies("Alberta"), 22);
    }
}
