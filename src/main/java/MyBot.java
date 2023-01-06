import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return "5948124271:AAGsbjloXxyRc-YC1AMegt2hrIf74IBoKeE";
    }

    @Override
    public String getBotUsername() {
        return "family_shop_germany_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()){
            Message message = update.getMessage();
            GetFile getFile = new GetFile(message.getDocument().getFileId());

            try {
                File tgFile = execute(getFile);
`
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
