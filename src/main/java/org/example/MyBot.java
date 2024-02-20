package org.example;

import net.thauvin.erik.crypto.CryptoPrice;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyBot extends TelegramLongPollingBot {
    public MyBot() {
        super("7057701272:AAGDeEOl7_m6HZ0m8gJzq-Ea97Bb8rIpSPo");

    }

    public void onUpdateReceived (Update update) {
        var chatId = update.getMessage().getChatId();
        var text = update.getMessage().getText();

        try {
            var message = new SendMessage();
            message.setChatId(chatId);

            if (text.equals("/start")) {
                message.setText("Hello");

            } else if (text.equals("btc")) {
                var price = CryptoPrice.spotPrice("BTC");
                message.setText("BTC price:" + price.getAmount().doubleValue());
            } else if (text.equals("eth")) {
                var price = CryptoPrice.spotPrice("ETH");
                message.setText("ETH price:" + price.getAmount().doubleValue());
            } else if (text.equals("bch")) {
                var price = CryptoPrice.spotPrice("BCH");
                message.setText("BCH price:" + price.getAmount().doubleValue());
            } else if (text.equals("all")) {
                var price1 = CryptoPrice.spotPrice("BTC");
                var price2=CryptoPrice.spotPrice("ETH");
                var price3=CryptoPrice.spotPrice("BCH");
                message.setText("BTC price:" + price1.getAmount().doubleValue() + "\n" + "ETH price:" + price2.getAmount().doubleValue() + "\n" + "BCH price:" + price3.getAmount().doubleValue());
            } else if (text.equals("btc,eth")) {
                var price1 = CryptoPrice.spotPrice("BTC");
                var price2 = CryptoPrice.spotPrice("ETH");
                message.setText("BTC price:" + price1.getAmount().doubleValue() + "," + "ETH price:" + price2.getAmount().doubleValue());
            } else if (text.equals("btc,eth,doge")) {
                var price1 = CryptoPrice.spotPrice("BTC");
                var price2 = CryptoPrice.spotPrice("ETH");
                var price4=CryptoPrice.spotPrice("DOGE");
                message.setText("BTC price:" + price1.getAmount().doubleValue() + "," + "ETH price:" + price2.getAmount().doubleValue() + "," + "DOGE price:" + price4.getAmount().doubleValue());

        } else {message.setText("Unknown command!");
        }

            execute(message);
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }


   public String getBotUsername (){
       return "mysuperbot885_bot";
   }

}