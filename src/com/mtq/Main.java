package com.mtq; /**
 * Created by guntar on 21/07/17.
 */

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new MTQbankmateri());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("com.mtq.MTQbankmateri successfully started!");
    }
}
