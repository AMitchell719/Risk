import java.util.ArrayList;

/**
 * The BattleObservers class is used to implement the Observer and Observable classes.
 * It allows Users to be added to an ArrayList of Observers who will be notified
 * upon a Territory being attacked by a player. These methods require the Override
 * parameter
 * @author Aaron Mitchell
 * @version 0.5
 */
public class BattleObservers implements Observable {
    private ArrayList<Observer> battleObservers = new ArrayList<Observer>();

    /**
     * Adds a User to the Observer list
     * @param o The Observer to add
     * @see Observable
     * @see Observer
     */
    @Override
    public void addObserver(Observer o) {
        battleObservers.add(o);
    }

    /**
     * Adds a User to the Observer list
     * @param o The Observer to remove
     * @see Observable
     * @see Observer
     */
    @Override
    public void removeObserver(Observer o) {
        battleObservers.remove(o);
    }

    /**
     * Adds a User to the Observer list
     * @return The index for the list of Observers
     * @see Observable
     * @see Observer
     */
    @Override
    public int notifyBattleObservers() {

        int index = 0;
        for (Observer ob : battleObservers){
            ob.update();
            index++;
        }
        return index;
    }
}
