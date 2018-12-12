import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TweetPosterTest {

    TweetPoster tp;
    int testCountForTwitter;

    @Before
    public void setup() {
        tp = new TweetPoster();
        testCountForTwitter = 1;
    }

    @Test
    public void testIncrementCount(){
        tp.incrementCount(1);
        Assert.assertEquals(tp.getCount(), 1);
    }

    @Test
    public void testResetCount(){
        tp.incrementCount(1);
        Assert.assertEquals(tp.resetCount(), 0);
    }

    @Test
    public void testGetCount(){
        tp.incrementCount(2);
        Assert.assertEquals(tp.getCount(), 2);
    }
    /*
    @Test
    //If an exception is thrown, change the number being passed to incrementTwitterCount
    public void testPostingToTwitter() throws TwitterException {
        user.incrementTwitterCount(1);
        Twitter twitter = TwitterFactory.getSingleton();
        String message = "Player " + user.getUsername() + " has conquered " + user.getTwitterCount() + " territories";
        Status status = twitter.updateStatus(message);
        // You will need to update the Twitter4J properties file or read keys from a file for this to pass
    }
    */
}
