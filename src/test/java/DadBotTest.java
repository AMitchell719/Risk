import org.junit.Test;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.ApiContextInitializer;

public class DadBotTest {

    @Test
    public void setupBot(){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new DadBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
