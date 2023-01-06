import org.apache.commons.io.FileUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;

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
            Document document = message.getDocument();
            try {
                saveFileToFolder(document.getFileId(), document.getFileName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void saveFileToFolder(String fileId, String fileName) throws Exception{
        GetFile getFile = new GetFile(fileId);
        File tgFile = execute(getFile);
        String fileUrl = tgFile.getFileUrl(getBotToken());

        URL url = new URL(fileUrl);
        InputStream inputStream = url.openStream();

        FileUtils.copyInputStreamToFile(inputStream, new java.io.File(fileName));
    }


}
