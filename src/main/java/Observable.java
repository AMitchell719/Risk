/**
 * The Observable interface is used as part of the Observer pattern to notify Users
 * that a territory and it's occupying User are under attack
 * @author Aaron Mitchell
 * @version 0.5
 */
public interface Observable {

    /**
     * Adds a User to the Observer list
     * @see BattleObservers
     * @see Observer
     */
    public void addObserver(Observer o);

    /**
     * Removes a User from the Observer list
     * @see BattleObservers
     * @see Observer
     */
    public void removeObserver(Observer o);

    /**
     * Notifies Users that a territory is under attack
     * @see BattleObservers
     * @see Observer
     */
    public int notifyBattleObservers();
}
