package com.mtq; /**
 * Created by guntar on 21/07/17.
 */

import org.telegram.telegrambots.api.methods.send.SendAudio;
import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.*;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MTQbankmateri extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        Ayman inputanUser = new Ayman();
        MateriTahsin materiTahsin = new MateriTahsin();

        int noSuroh, awalAyat, akhirAyat;

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String user_first_name = update.getMessage().getChat().getFirstName();
            String user_last_name = update.getMessage().getChat().getLastName();
            String user_username = update.getMessage().getChat().getUserName();
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();

            if (message_text.length() > 7) {
                String requestAyman = message_text;
                String subRequestAyman = requestAyman.substring(0, Math.min(requestAyman.length(), 6));
                String pesanAsli = requestAyman.substring(7);
//                System.out.println("Pesan aslinya '" + pesanAsli +"'");

                if (subRequestAyman.equals("/ayman")) {
                    inputanUser.inputanQuran(pesanAsli);
                    if (pesanAsli.contains("?") == true) {

                        String panduanAyman = "🔰Bacaan Syeikh Ayman Sowaid🔰" + '\n' + '\n' +"Antum dapat menyimak bacaan Syeikh Ayman Sowaid dengan dua cara: 1) mengunduh satu suroh 2) mengunduh ayat per ayat."+ '\n' + '\n' + "Untuk mengunduh satu suroh, gunakan perintah /ayman diikuti dengan nomer suroh (misal /ayman 84). Suroh yang dapat diunduh hanyalah suroh ke-41 s.d. suroh ke-114"+ '\n' + '\n' + "Jika antum ingin mengunduh ayat per ayat, maka gunakan perintah /ayman diikuti nomer suroh dan ayat ke berapa sampai ke berapa, dipisahkan dengan tanda titik dua (misal /ayman 77:46-50). Ayat-ayat yang dapat antum akses adalah ayat-ayat dari suroh ke-25 s.d. ke-114";
                        SendMessage mintaPanduanSuroh = new SendMessage()
                                .setChatId(chat_id)
                                .setText(panduanAyman);
                        try {
                            sendMessage(mintaPanduanSuroh);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }

                    } else if (pesanAsli.contains(":") == true) {
                        System.out.println(user_username + " mengakses unduh per ayat Ayman");

                        if (pesanAsli.contains("-") == true) {
                            System.out.println("Pesan miliki - berarti > 1 ayat");
                            String[] pisahSurohdanAyatnya = pesanAsli.split(":");
                            String[] pisahAyatMuladanAkhir = pisahSurohdanAyatnya[1].split("-");
                            noSuroh = Integer.parseInt(pisahSurohdanAyatnya[0]);
                            awalAyat = Integer.parseInt(pisahAyatMuladanAkhir[0]);
                            akhirAyat = Integer.parseInt(pisahAyatMuladanAkhir[1]);

                            // cek apakah masih dalam batas suroh yg tersedia
                            if (noSuroh < 25) {
                                String textSurohTakTersedia = "Mohon maaf, untuk saat ini bacaan ayat per ayat yang tersedia hanyalah mulai dari suroh ke-25 s.d. suroh ke-114.";
                                SendMessage infoSurohTakTersedia = new SendMessage()
                                        .setChatId(chat_id)
                                        .setText(textSurohTakTersedia);
                                try {
                                    sendMessage(infoSurohTakTersedia);
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                // cek apakah awal dan akhir ayat melebihi batas dari suroh ybs
                                if (awalAyat < 1) awalAyat = 1;
                                if (awalAyat > inputanUser.cekJumlahAyat(noSuroh))  awalAyat = inputanUser.cekJumlahAyat
                                        (noSuroh);
                                if (akhirAyat > inputanUser.cekJumlahAyat(noSuroh)) akhirAyat = inputanUser.cekJumlahAyat
                                        (noSuroh);

                                int jumlahAyatDiminta = akhirAyat - awalAyat + 1;
//                                System.out.println("Meminta " + jumlahAyatDiminta + " ayat");
//                                System.out.println("Akhir ayat = " + akhirAyat);

                                for (int i = awalAyat; i <= akhirAyat; i++) {
                                    SendAudio pesanBanyakAyat = new SendAudio()
                                            .setChatId(chat_id)
                                            .setAudio(inputanUser.getLinkSatuAyat(noSuroh, i))
                                            .setCaption(inputanUser.namaSuroh(noSuroh) + ": " + i);
                                    try {
                                        sendAudio(pesanBanyakAyat );
                                    } catch (TelegramApiException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            System.out.println(user_username + " mengakses satu satu ayat satu ayat Ayman");
                            String[] suroh1ayat = pesanAsli.split(":");
                            noSuroh = Integer.parseInt(suroh1ayat[0]);
                            awalAyat = Integer.parseInt(suroh1ayat[1]);
                            if (noSuroh < 25) {
                                String textSurohTakTersedia = "Mohon maaf, untuk saat ini bacaan ayat per ayat yang tersedia hanyalah mulai dari suroh ke-25 s.d. suroh ke-114.";
                                SendMessage infoSurohTakTersedia = new SendMessage()
                                        .setChatId(chat_id)
                                        .setText(textSurohTakTersedia);
                                try {
                                    sendMessage(infoSurohTakTersedia);
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                SendAudio pesanSatuAyat = new SendAudio()
                                        .setChatId(chat_id)
                                        .setAudio(inputanUser.getLinkSatuAyat(noSuroh, awalAyat))
                                        .setCaption(inputanUser.namaSuroh(noSuroh) + ": " + awalAyat);
                                try {
                                    sendAudio(pesanSatuAyat );
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else {
                        System.out.println(user_username + " mengakses satu suroh Ayman");
                        int nomerSurohSaja = Integer.parseInt(pesanAsli);
                        if (nomerSurohSaja < 41) {
                            String textSurohTakTersedia = "Mohon maaf, untuk saat ini bacaan suroh yang tersedia hanyalah mulai dari suroh ke-41 s.d. suroh ke-114.";
                            SendMessage infoSurohTakTersedia = new SendMessage()
                                    .setChatId(chat_id)
                                    .setText(textSurohTakTersedia);
                            try {
                                sendMessage(infoSurohTakTersedia);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        } else {
                            SendAudio pesanSatuSuroh = new SendAudio()
                                    .setChatId(chat_id)
                                    .setAudio(inputanUser.inputanQuran(nomerSurohSaja))
                                    .setCaption(inputanUser.namaSuroh(nomerSurohSaja));
                            try {
                                sendAudio(pesanSatuSuroh);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                // Bagian Panduan Tahsin
                String requestPanduan = message_text;
                String subRequestPanduan= requestAyman.substring(0, Math.min(requestPanduan.length(), 8));
                String pesanAsliPanduan = requestPanduan.substring(9);
//                System.out.println("subRequestPanduan '" + subRequestPanduan +"'");
//                System.out.println("Pesan aslinya '" + pesanAsliPanduan +"'");

                if (subRequestPanduan.equals("/panduan")) {

                    if (pesanAsliPanduan.contains("?") == true) {
                        String infoPanduanSuroh = "🔰Panduan Tahsin🔰" + '\n' + '\n' +"Panduan pembacaan ayat per ayat untuk suroh di juz 30 ini dimaksudkan untuk menunjukkan bagaimana cara pembacaan yang benar." + '\n' + '\n' +
                                "Untuk saat ini, materi yang tersedia adalah panduan untuk Suroh ke 82 hingga suroh ke-114."+ '\n' + '\n' + "Penggunaan:"+ '\n' + "Audio panduan dibagi per 10 ayat. Jika antum ingin dapatkan seluruh panduan untuk suroh tertentu, langsung gunakan nomer suroh. Jika antum hanya ingin panduan di ayat tertentu, maka masukkan angka bagian panduannya; pisahkan nomer suroh dan bagian panduan dengan tanda titik dua (:)."+ '\n' + '\n' + "Contoh:"+ '\n' + "/panduan 83 = untuk seluruh panduan di suroh ke-83."+ '\n' + "/panduan 83:2 = untuk panduan ke-2 (ayat 11 s.d. 20) dari suroh ke-83";
                        SendMessage mintaPanduanSuroh = new SendMessage()
                                .setChatId(chat_id)
                                .setText(infoPanduanSuroh);
                        try {
                            sendMessage(mintaPanduanSuroh);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    } else if (pesanAsliPanduan.contains(":") == true) {
                        System.out.println(user_username + " request satu panduan saja");
                        String[] dapatkanInfoPanduanKe = pesanAsliPanduan.split(":");
                        noSuroh = Integer.parseInt(dapatkanInfoPanduanKe[0]);

                        if (noSuroh < 82) {
                            System.out.println("Yang direquest tidak tersedia");
                            SendMessage maafTakTersedia = new SendMessage()
                                    .setChatId(chat_id)
                                    .setText("Mohon maaf, " + user_first_name + " " + user_last_name + ". Untuk saat ini panduan yang tersedia hanyalah untuk suroh ke-82 s.d. ke-114");
                            try {
                                sendMessage(maafTakTersedia);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        } else {
                            int panduanKe = Integer.parseInt(dapatkanInfoPanduanKe[1]);
                            SendAudio pesanPanduanSatuan = new SendAudio()
                                    .setChatId(chat_id)
                                    .setAudio(materiTahsin.getLinkSatuPanduan(noSuroh, panduanKe))
                                    .setCaption(materiTahsin.dapatkanCaption(noSuroh));
                            try {
                                sendAudio(pesanPanduanSatuan);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        System.out.println(user_username + " mengakses pesan seluruh paket panduan");
                        int nomerSurohSaja = Integer.parseInt(pesanAsliPanduan);
                        if (nomerSurohSaja <82) {
                            System.out.println("Yang direquest tidak tersedia");
                            SendMessage maafTakTersedia = new SendMessage()
                                    .setChatId(chat_id)
                                    .setText("Mohon maaf, " + user_first_name + " " + user_last_name + ". Untuk saat ini panduan yang tersedia hanyalah untuk suroh ke-82 s.d. ke-114");
                            try {
                                sendMessage(maafTakTersedia);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        } else {
                            int panduanKe2 = materiTahsin.cekJumlahPanduan(nomerSurohSaja);
                            for (int i = 1; i <= panduanKe2; i++) {
                                SendAudio pesanSatuPaketPanduan = new SendAudio()
                                        .setChatId(chat_id)
                                        .setAudio(materiTahsin.getLinkSatuPanduan(nomerSurohSaja, i))
                                        .setCaption(materiTahsin.dapatkanCaption(nomerSurohSaja));
                                try {
                                    sendAudio(pesanSatuPaketPanduan);
                                } catch (TelegramApiException e) {
                                    e.printStackTrace();
                                }
                            }
                        }



                    }

/*
                    int nomerSurohSaja = Integer.parseInt(pesanAsliPanduan);
                    SendAudio pesanSatuSuroh = new SendAudio()
                            .setChatId(chat_id)
//                            .setAudio(materiTahsin.getLinkSatuPanduan(nomerSurohSaja))
                            .setCaption(inputanUser.namaSuroh(nomerSurohSaja));
                    try {
                        sendAudio(pesanSatuSuroh);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    */

                }


            }



            if (message_text.equals("/start")) {
                System.out.println("User accessing the bot: " + user_username +" of " + user_first_name + " " +
                        user_last_name);
                String teksPembuka = "Assalamu'alaykum warahmatullaahiwabarakaatuh, " + user_first_name + " " + user_last_name +". Semoga Allah rahmati antum dan berikan antum kemuliaan melalui Al Qur'an." + '\n' + '\n' + "Bot MTQ Bank Materi merupakan bot pendukung program tahfizh dan tahsin MTQ Online yang dilangsungkan via telegram (www.tahfizhonline.com)." + '\n' + '\n' + "Dengan bot ini, antum dapat mengakses panduan bacaan untuk suroh di juz 30 dan bacaan dari syeikh Ayman Sowaid." + '\n' + '\n' + "Perintah yang tersedia adalah /panduan dan /ayman. Gunakan tanda tanya setelah perintah (misal: /panduan ?) untuk mendapatkan petunjuk lebih lanjut.";
                SendMessage pesanTeksPembuka = new SendMessage()
                        .setChatId(chat_id)
                        .setText(teksPembuka);
                SendPhoto pesanFotoPembuka = new SendPhoto()
                        .setChatId(chat_id)
                        .setPhoto("AgADBQADsacxG1LjqFcRDCPucPBL9H4RzDIABAJ6kIseCxAWtbUAAgI")
                        .setCaption("");
                try {
                    sendPhoto(pesanFotoPembuka);
                    sendMessage(pesanTeksPembuka);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }


            if (message_text.equals("/makhroj 'ain")) {

                String textAin = "Huruf ع berasal dari tenggorokan bagian tengah, wasathul halq (ِوَ سَطُ لْحَلْق)" + '\n' + "Beberapa kesalahan yang biasa terjadi dalam pelafalan huruf ع antara lain:" + '\n' + "1. mengucapkan ع secara mengambang, karena kembalinya terlampau sedikit; shg mirip alif tebal" + '\n' + "2. memutus suara عdalam kondisi sukun" + '\n' + "3. menebalkan ع saat bertemu dengan huruf-huruf tebal" + '\n' + "4. membaca ع mirip hamzah";

                SendMessage pesanTeksMakhroj = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText(textAin);

                SendPhoto pesanFotoMakhroj = new SendPhoto()
                        .setChatId(chat_id)
                        .setPhoto("AgADBQADv6cxG1LjqFdpdEky-G7KrnUOzDIABFpgN2gNCayJm7oAAgI")
                        .setCaption("Makhroj huruf 'ain");

                try {
                    sendPhoto(pesanFotoMakhroj);
                    sendMessage(pesanTeksMakhroj); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }





/*
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("✳️ " + user_last_name + " " + infoSetoran);
                try {
                    sendMessage(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
*/

            }
    }





    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "MTQ Bank Materi Bot";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "412365466:AAGLovUBFxeLjl-yOAWXzp1owkP7pfk18zQ";
    }

}
