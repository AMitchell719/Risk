/**
 * The Card class will be used to store information about the playing
 * cards that User's will collect and turn in for bonuses
 * @author Aaron Mitchell
 * @version 0.5
 */

public class Card {

    private Territory territory;
    private String classifier;

    public Card (String classifier, Territory territory)
    {
        this.classifier = classifier;
        this.territory = territory;
    }

    /**
     * Grabs the name and type of the card
     * @return Returns the card name along with its type
     * @see Card
     */
    public String getName()
    {
        return territory.getName();
    }

    /**
     * Grabs the type assigned to the card
     * @return Returns the type assigned to the card
     * @see Card
     */
    public String getType()
    {
        return classifier;
    }
}
