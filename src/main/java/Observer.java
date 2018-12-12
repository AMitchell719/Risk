/**
 * The Observer interface is used as part of the Observer pattern to notify Users
 * that a territory and it's occupying User are under attack
 * @author Aaron Mitchell
 * @version 0.5
 */
public interface Observer {

    /**
     * This method must be overridden in the respective class implementing the Observer pattern
     * @see User
     */
    public void update();
}
