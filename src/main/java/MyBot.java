import org.apache.commons.io.FileUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;
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
            String chatId = message.getChatId().toString();
//            Document document = message.getDocument();
//            try {
//                saveFileToFolder(document.getFileId(), document.getFileName());
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }file //
//            Voice voice = message.getVoice();
//            try {
//                saveFileToFolder(voice.getFileId(), "voice.mp3");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
            if (message.hasText()){
                String text = message.getText();
                if (text.equals("/start")){
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Assalomu Aleykum.\n" +
                            "Family Shop Germany do'konimizning rasmiy botiga Xush kelibsiz!\n" +
                            "Itimos tilni tanlang:\n" +
                            "Pojalyusta viberite yazik:\n" +
                            "1 - uz\n" +
                            "2 - ru");
                    sendMessage.setChatId(chatId);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                } else if (text.equals("1")) {

                }else if (text.equals("2")) {

                }

            }
            else if(message.hasAudio()){
                System.out.println("Audio");
            }
            else if (message.hasDocument()){
                System.out.println("File");
            }
        }
        else if (update.hasCallbackQuery()){

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
