/**
 * The Purchase interface allows for the use of a proxy pattern so Users can purchase things like 
 * undo actions, more cards, and transfer credits to other Users
 * @author Aaron Mitchell
 * @version 0.5
 */
public interface Purchase {
    public int purchaseUndo();
    public int purchaseCard();
    public int transferCredit();
    public int getCredit();
}
