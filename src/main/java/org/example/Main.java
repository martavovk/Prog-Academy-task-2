package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws Exception {
        TelegramBotsApi api=new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot (new MyBot());

    }
}




//mysuperbot885_bot
//7057701272:AAGDeEOl7_m6HZ0m8gJzq-Ea97Bb8rIpSPo