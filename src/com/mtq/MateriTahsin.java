package com.mtq;

public class MateriTahsin {

    private String[][] arPanduanSuroh = new String[115][5];
    private int[] arJumlahPanduan = new int[115];

    public MateriTahsin() {
        populateArJumlahPanduan();
        populateArPanduanSuroh();
    }


    public String getLinkSatuPanduan(int noSuroh, int panduanKe) {
        String linkUnduhSatuPanduan = arPanduanSuroh[noSuroh][panduanKe];
        return linkUnduhSatuPanduan;
    }

    public int cekJumlahPanduan (int noSuroh) {
        int jumlahPanduan = arJumlahPanduan[noSuroh];
        return jumlahPanduan;
    }

    public String dapatkanCaption (int namaSuroh) {
        String infoCaption = arPanduanSuroh[namaSuroh][0];
        return infoCaption;

    }

    private void populateArJumlahPanduan() {
        arJumlahPanduan[82] = 2;
        arJumlahPanduan[83] = 4;
        arJumlahPanduan[84] = 3;
        arJumlahPanduan[85] = 2;
        arJumlahPanduan[86] = 2;
        arJumlahPanduan[87] = 2;
        arJumlahPanduan[88] = 3;
        arJumlahPanduan[89] = 3;
        arJumlahPanduan[90] = 2;
        arJumlahPanduan[91] = 2;
        arJumlahPanduan[92] = 2;
        arJumlahPanduan[93] = 1;
        arJumlahPanduan[94] = 1;
        arJumlahPanduan[95] = 1;
        arJumlahPanduan[96] = 2;
        arJumlahPanduan[97] = 1;
        arJumlahPanduan[98] = 2;
        arJumlahPanduan[99] = 1;
        arJumlahPanduan[100] = 1;
        arJumlahPanduan[101] = 1;
        arJumlahPanduan[102] = 1;
        arJumlahPanduan[103] = 1;
        arJumlahPanduan[104] = 1;
        arJumlahPanduan[105] = 1;
        arJumlahPanduan[106] = 1;
        arJumlahPanduan[107] = 1;
        arJumlahPanduan[108] = 1;
        arJumlahPanduan[109] = 1;
        arJumlahPanduan[110] = 1;
        arJumlahPanduan[111] = 1;
        arJumlahPanduan[112] = 1;
        arJumlahPanduan[113] = 1;
        arJumlahPanduan[114] = 1;
    }

    private void populateArPanduanSuroh() {
        arPanduanSuroh[82][0] = "Abu Azam MTQ - Panduan suroh Al-Infitar";
        arPanduanSuroh[83][0] = "Abu Azam MTQ - Panduan suroh Al-Mutaffife";
        arPanduanSuroh[84][0] = "Abu Azam MTQ - Panduan suroh Al-Inshiqaq";
        arPanduanSuroh[85][0] = "Abu Azam MTQ - Panduan suroh Al-Buruj";
        arPanduanSuroh[86][0] = "Abu Azam MTQ - Panduan suroh At-Tariq";
        arPanduanSuroh[87][0] = "Abu Azam MTQ - Panduan suroh Al-A'la";
        arPanduanSuroh[88][0] = "Abu Azam MTQ - Panduan suroh Al-Gashiya";
        arPanduanSuroh[89][0] = "Abu Azam MTQ - Panduan suroh Al-Fajr";
        arPanduanSuroh[90][0] = "Abu Azam MTQ - Panduan suroh Al-Balad";
        arPanduanSuroh[91][0] = "Abu Azam MTQ - Panduan suroh Ash-Shams";
        arPanduanSuroh[92][0] = "Abu Azam MTQ - Panduan suroh Al-Lail";
        arPanduanSuroh[93][0] = "Abu Azam MTQ - Panduan suroh Adz-Dhuha";
        arPanduanSuroh[94][0] = "Abu Azam MTQ - Panduan suroh Al-Syarh";
        arPanduanSuroh[95][0] = "Abu Azam MTQ - Panduan suroh At-Tin";
        arPanduanSuroh[96][0] = "Abu Azam MTQ - Panduan suroh Al-Alaq";
        arPanduanSuroh[97][0] = "Abu Azam MTQ - Panduan suroh Al-Qadr";
        arPanduanSuroh[98][0] = "Abu Azam MTQ - Panduan suroh Al-Baiyina";
        arPanduanSuroh[99][0] = "Abu Azam MTQ - Panduan suroh Al-Zalzalah";
        arPanduanSuroh[100][0] = "Abu Azam MTQ - Panduan suroh Al-Adiyat";
        arPanduanSuroh[101][0] = "Abu Azam MTQ - Panduan suroh Al-Qari'a";
        arPanduanSuroh[102][0] = "Abu Azam MTQ - Panduan suroh At-Takathur";
        arPanduanSuroh[103][0] = "Abu Azam MTQ - Panduan suroh Al-Asr";
        arPanduanSuroh[104][0] = "Abu Azam MTQ - Panduan suroh Al-Humaza";
        arPanduanSuroh[105][0] = "Abu Azam MTQ - Panduan suroh Al-Fil";
        arPanduanSuroh[106][0] = "Abu Azam MTQ - Panduan suroh Quraish";
        arPanduanSuroh[107][0] = "Abu Azam MTQ - Panduan suroh Al-Ma'un";
        arPanduanSuroh[108][0] = "Abu Azam MTQ - Panduan suroh Al-Kautsar";
        arPanduanSuroh[109][0] = "Abu Azam MTQ - Panduan suroh Al-Kaafirun";
        arPanduanSuroh[110][0] = "Abu Azam MTQ - Panduan suroh An-Nashr";
        arPanduanSuroh[111][0] = "Abu Azam MTQ - Panduan suroh Al-Lahab";
        arPanduanSuroh[112][0] = "Abu Azam MTQ - Panduan suroh Al-Ikhlas";
        arPanduanSuroh[113][0] = "Abu Azam MTQ - Panduan suroh Al-Falaq";
        arPanduanSuroh[114][0] = "Abu Azam MTQ - Panduan suroh Al-Naas";

        arPanduanSuroh[82][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/082_Al-Infithor_1-10.mp3";
        arPanduanSuroh[82][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/082_Al-Infithor_11-19.mp3";
        arPanduanSuroh[83][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/083_Al-Muthoffifin_1-10.mp3";
        arPanduanSuroh[83][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/083_Al-Muthoffifin_11-20.mp3";
        arPanduanSuroh[83][3] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/083_Al-Muthoffifin_21-30.mp3";
        arPanduanSuroh[83][4] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/083_Al-Muthoffifin_31-36.mp3";
        arPanduanSuroh[84][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/084_Al-Insyiqoq_1-10.mp3";
        arPanduanSuroh[84][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/084_Al-Insyiqoq_11-20.mp3";
        arPanduanSuroh[84][3] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/084_Al-Insyiqoq_21-25.mp3";
        arPanduanSuroh[85][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/085_Al-Buruuj_1-10.mp3";
        arPanduanSuroh[85][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/085_Al-Buruuj_11-22.mp3";
        arPanduanSuroh[86][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/086_At-Thoriq_1-10.mp3";
        arPanduanSuroh[86][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/086_At-Thoriq_11-17.mp3";
        arPanduanSuroh[87][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/087_Al-A'la_1-10.mp3";
        arPanduanSuroh[87][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/087_Al-A'la_11-19.mp3";
        arPanduanSuroh[88][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/088_Al-Ghasyiyah_1-10.mp3";
        arPanduanSuroh[88][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/088_Al-Ghasyiyah_11-20.mp3";
        arPanduanSuroh[88][3] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/088_Al-Ghasyiyah_21-26.mp3";
        arPanduanSuroh[89][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/089_Al-Fajr_1-10.mp3";
        arPanduanSuroh[89][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/089_Al-Fajr_11-20.mp3";
        arPanduanSuroh[89][3] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/089_Al-Fajr_21-30.mp3";
        arPanduanSuroh[90][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/090_Al-Balad_1-10.mp3";
        arPanduanSuroh[90][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/090_Al-Balad_11-20.mp3";
        arPanduanSuroh[91][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/091_Asy-Syams_1-10.mp3";
        arPanduanSuroh[91][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/091_Asy-Syams_11-15.mp3";
        arPanduanSuroh[92][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/092_Al-Lail_1-10.mp3";
        arPanduanSuroh[92][2] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/092_Al-Lail_11-21.mp3";
        arPanduanSuroh[93][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/093_Ad-Dhuha_1-11.mp3";
        arPanduanSuroh[94][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/094_Asy-Syarh_1-8.mp3";
        arPanduanSuroh[95][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/095_At-Tiin_1-8.mp3";
        arPanduanSuroh[96][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/096_Al-'Alaq_1-10.mp3";
        arPanduanSuroh[96][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/096_Al-'Alaq_11-19.mp3";
        arPanduanSuroh[97][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/097_Al-Qodr_1-5.mp3";
        arPanduanSuroh[98][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/098_Al-Bayyinah_1-5.mp3";
        arPanduanSuroh[98][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/098_Al-Bayyinah_6-8.mp3";
        arPanduanSuroh[99][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/099_Az-Zalzalah_1-8.mp3";
        arPanduanSuroh[100][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/100_Al-'Aadiyaat_1-11.mp3";
        arPanduanSuroh[101][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/101_Al-Qoori'ah_1-11.mp3";
        arPanduanSuroh[102][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/102_At-Takaatsur_1-8.mp3";
        arPanduanSuroh[103][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/103_Al-'Ashr_1-3.mp3";
        arPanduanSuroh[104][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/104_Al-Humazah_1-9.mp3";
        arPanduanSuroh[105][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/105_Al-Fiil_1-5.mp3";
        arPanduanSuroh[106][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/106_Quroisy_1-4.mp3";
        arPanduanSuroh[107][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/107_Al-Maa'uun_1-7.mp3";
        arPanduanSuroh[108][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/108_Al-Kautsar_1-3.mp3";
        arPanduanSuroh[109][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/109_Al-Kaafiruun_1-6.mp3";
        arPanduanSuroh[110][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/110_An-Nashr_1-3.mp3";
        arPanduanSuroh[111][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/111_AlLahab_ 1-5.mp3";
        arPanduanSuroh[112][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/112_Al-Ikhlas_1-4.mp3";
        arPanduanSuroh[113][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/113_Al-Falaq_1-5.mp3";
        arPanduanSuroh[114][1] = "https://dl.dropboxusercontent.com/u/12785203/mtq_juz30/114_An-Naas_1-6.mp3";


    }

}

