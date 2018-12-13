/**
 * The Proxy class implements the Proxy design pattern. Users now have the ability
 * to purchase undo actions, more Risk cards, and transfer their credits to other
 * Users. These actions will be implemented through a proxy
 * @author Aaron Mitchell
 * @version 0.5
 */
public class Proxy implements Purchase {

    private User user;
    private int credits;

    public Proxy(int n) {
        this.credits = n;
    }

    /**
     * Calls the purchaseUndo function in the User class
     * @return Returns the purchaseUndo function for the User
     * @see Purchase
     * @see User
     */
    @Override
    public int purchaseUndo() {
        return user.purchaseUndo();
    }

    /**
     * Calls the purchaseCard function in the User class
     * @return Returns the purchaseCard function for the User
     * @see Purchase
     * @see User
     */
    @Override
    public int purchaseCard() {
        return user.purchaseCard();
    }

    /**
     * Calls the transferCredit function in the User class
     * @return Returns the transferCredit function for the User
     * @see Purchase
     * @see User
     */
    @Override
    public int transferCredit() {
        return user.transferCredit();
    }

    /**
     * Calls the getCredit function in the User class
     * @return Returns the getCredit function for the User
     * @see Purchase
     * @see User
     */
    @Override
    public int getCredit() {
        return user.getCredit();
    }
}
