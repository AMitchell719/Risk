import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;

/**
 * The DadBot class is used to spawn a telegram bot that users can use to play the game. Users must
 * join the telegram application on their phone, and input the commands to play. We are assuming
 * that 2 players are using the application at this time. To add the ability to add more players,
 * you would need to edit the territory spawning function, and update the checks in the
 * onUpdateReceived loops
 * @author Aaron Mitchell
 * @version 0.4
 */

public class DadBot extends TelegramLongPollingBot{

    ArrayList<User> userList = new ArrayList<User>();
    ArrayList<String> container = new ArrayList<String>();

    Board board = new Board();

    ArrayList<Territory> territoryHolder = new ArrayList<Territory>();

    /**
     * Method used by the bot to identify the commands users are inputting. It can start the game,
     * add users to the game, attack territories, and fortify territories
     * @param update This is the message users are entering into the telegram application
     * @see DadBot
     */
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            container.clear();

            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            String username = update.getMessage().getFrom().getFirstName();

            String[] tokens = message_text.split(":");
            for (String t : tokens) {
                container.add(t);
            }

            message_text = container.get(0);




            // Start the game. Sets up the board, deck and Twitter functionality
            if(message_text.equals("/start@TeamHALBot")){
                SendMessage message = new SendMessage().setChatId(chat_id).setText(
                        "Welcome to the game of Risk, please enter /join@TeamHALBot " +
                        "to join. 3 players must be present to begin game! The first player will be player 1 and " +
                        "the next player will be player 2, while the final player will be player 3.");

                // Spawn board, deck and Twitter
                board.setupBoard();

                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                container.clear();
            }

            else if(message_text.equals("/join@TeamHALBot")) {

                // If user list is not 1 less than size, add the user to the list
                if (userList.size() != 1) {
                    userList.add(new User(username, 35));
                    SendMessage message = new SendMessage().setChatId(chat_id).setText(username + " you have joined the game");
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    container.clear();
                }

                // If user list is 1 less than required size, add user and begin the game
                else if (userList.size() == 1) {
                    userList.add(new User(username, 35));
                    SendMessage message = new SendMessage().setChatId(chat_id).setText(username + " you have joined the game." +
                            " The game of Risk will now begin!");

                    setupTelegramTerritories();

                        try {
                            execute(message); // Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }

                container.clear();
            }

            // Attack the specified territory
            else if(message_text.equals("/attack@TeamHALBot")){
                SendMessage attack = new SendMessage().setChatId(chat_id).setText("Player 2, NorthWest Territory has lost 5 armies!");
                board.getTerritoryName("Alaska").decrementArmies(1);

                try {
                    execute(attack); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                container.clear();
            }

            // Fortify specified territory
            else if(message_text.equals("/fortify@TeamHALBot")){

                SendMessage message = new SendMessage().setChatId(chat_id).setText("Player 1, fortifying your territory! You've" +
                        " gained 4 new armies!");

                board.getTerritoryName("Alaska").setArmyPower(24);
                board.getTerritoryName("Alaska").getUser().addArmyPower(4);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                container.clear();
            }

            // List territories for requesting player
            else if(message_text.equals("/list@TeamHALBot")){

                territoryHolder = board.getBoardTerritories();
                String usernameForTerritory = update.getMessage().getFrom().getFirstName();

                    for(int j = 0; j < 42; j++)
                    {
                        if(territoryHolder.get(j).getUser().getUsername().equals(usernameForTerritory))
                        {
                            SendMessage message = new SendMessage().setChatId(chat_id).setText(
                                    "Username: " + usernameForTerritory + "\n" +
                                    "Territory: " + territoryHolder.get(j).getTerritory() + "\n" +
                                    "Army Power: " + territoryHolder.get(j).getArmyPower() + "\n");

                            try {
                                execute(message); // Sending our message object to user
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                container.clear();
            }
        }
    }

    /**
     * Method used by the bot API to identify the bot username. Note that you must manually
     * update the name of the bot in the quotations after making the bot
     * @return Username of the bot created to play the game
     * @see DadBot
     */
    @Override
    public String getBotUsername() {
        return "Bot Name Here";
    }

    /**
     * Method used by the bot API to identify the bot's secret access key. You must manually update
     * this with the secret key, or use a properties file
     * @return Secret access key
     * @see DadBot
     */
    @Override
    public String getBotToken() {
        return "Secret Key Here";
    }

    /**
     * Function used to spawn territories for the 2 players who have joined the game through
     * the telegram messaging application
     * @see DadBot
     * @see Board
     */
    public void setupTelegramTerritories(){
        // Add player 1's territories to HashMap
        userList.get(0).addTerritory(board.getTerritoryName("Alaska"));
        board.setUserOccupant("Alaska", userList.get(0));
        board.getTerritoryName("Alaska").setArmyPower(1);

        // Add player 2's territories to HashMap
        userList.get(1).addTerritory(board.getTerritoryName("Quebec"));
        board.setUserOccupant("Quebec", userList.get(1));
        board.getTerritoryName("Quebec").setArmyPower(1);
    }
}
