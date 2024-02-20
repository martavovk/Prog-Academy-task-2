package org.example;

import net.thauvin.erik.crypto.CryptoPrice;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyBot extends TelegramLongPollingBot {
    public MyBot() {
        super("7057701272:AAGDeEOl7_m6HZ0m8gJzq-Ea97Bb8rIpSPo");

    }

    public void onUpdateReceived (Update update) {
        var chatId = update.getMessage().getChatId();
        var text = update.getMessage().getText();

        try {
            if (text.equals("/start")) {
                sendMessage(chatId,"Hello");
            } else if (text.equals("btc")) {
                sendPicture(chatId,"Bitcoin.png");
                sendPrice(chatId,"BTC");


            } else if (text.equals("eth")) {
                sendPicture(chatId,"Eth.png");
                sendPrice(chatId,"ETH");
            } else if (text.equals("bch")) {
                sendPicture(chatId,"Bch.png");
                sendPrice(chatId,"BCH");
            } else if (text.equals("all")) {
                sendPrice(chatId,"BCH");
                sendPrice(chatId,"ETH");

            } else if (text.equals("btc,eth")) {
                var price1 = CryptoPrice.spotPrice("BTC");
                var price2 = CryptoPrice.spotPrice("ETH");
                sendMessage(chatId,"BTC price:" + price1.getAmount().doubleValue() + "," + "ETH price:" + price2.getAmount().doubleValue());
            } else if (text.equals("btc,eth,doge")) {
                var price1 = CryptoPrice.spotPrice("BTC");
                var price2 = CryptoPrice.spotPrice("ETH");
                var price4=CryptoPrice.spotPrice("DOGE");
                sendMessage(chatId,"BTC price:" + price1.getAmount().doubleValue() + "," + "ETH price:" + price2.getAmount().doubleValue() + "," + "DOGE price:" + price4.getAmount().doubleValue());

        } else {sendMessage(chatId,"Unknown command!");
        }

        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
    void sendPrice(long chatId,String name) throws Exception{
        var price = CryptoPrice.spotPrice("name");
        sendMessage(chatId,name+"price:" + price.getAmount().doubleValue());
    }
    void sendPicture(long chatId,String name) throws Exception{
        var photo=getClass().getClassLoader().getResourceAsStream(name);
        var message=new SendPhoto();
        message.setChatId(chatId);
        message.setPhoto(new InputFile(photo,name));
        execute(message);
    }
    void sendMessage(long chatId,String text) throws Exception{
        var message=new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        execute(message);
}

   public String getBotUsername (){
       return "mysuperbot885_bot";
   }

}