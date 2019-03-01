import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    public String getBotUsername() {
        return "my_new_youtube_bot";
    }

    public String getBotToken() {
        return "720463305:AAETvlYKjL1GWhZ_EADVLahcwzhVk0RLIhI";
    }

    public synchronized void sendMsg(String chatId, String s) {
        if (s.equals("/start")) {
            s = "Hello World";
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
            sendMessage.setChatId("471262871");
            sendMessage.setText("user id: " + chatId + "\n" + s);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
