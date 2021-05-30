package com.example.playstore;

import java.util.ArrayList;

public class PlaystoreData {
    private static String[] appNames = {
            "Instagram",
            "Twitter",
            "Youtube",
            "Telegram",
            "WhatsApp",
            "Line",
            "Facebook",
            "Spotify",
            "Netflix",
            "Gojek"
    };

    private static String[] appDetails = {
            "Berhubung dengan rakan, kongsi aktiviti anda atau lihat perkara baharu daripada orang lain di seluruh dunia. Teroka komuniti kami di mana anda boleh berasa bebas untuk menjadi diri anda sendiri dan berkongsi segala-galanya dari detik harian anda hingga sorotan kehidupan.",
            "Semua perkara yang berlaku di dunia pada hari ini, daripada peristiwa penting dan hiburan hinggalah kepada sukan, politik dan minat harian, akan dikongsi di Twitter terlebih dahulu. Lihat semua sudut bagi peristiwa yang berlaku. Sertai perbualan. Semua perkara penting yang berlaku di dunia sekarang dan yang menjadi tumpuan masyarakat ada di Twitter.",
            "Dapatkan aplikasi YouTube resmi untuk ponsel dan tablet Android. Lihat apa yang ditonton orang-orang di seluruh dunia -- dari video musik terpopuler hingga game, hiburan, berita, dan hal lainnya yang sedang tren. Berlanggananlah ke saluran yang Anda sukai, bagikan dengan teman, dan tonton di perangkat mana saja.",
            "Bagi mereka yang tertarik dengan privasi maksimum, Telegram menawarkan Obrolan Rahasia. Pesan Obrolan Rahasia dapat diprogram untuk dihancurkan secara otomatis dari kedua perangkat yang berpartisipasi. Dengan cara ini Anda dapat mengirim semua jenis konten yang hilang - pesan, foto, video, dan bahkan file. Obrolan Rahasia menggunakan enkripsi ujung ke ujung untuk memastikan bahwa pesan hanya dapat dibaca oleh penerima yang dituju.",
            "WhatsApp Messenger adalah aplikasi perpesanan GRATIS yang tersedia untuk Android dan ponsel cerdas lainnya. WhatsApp menggunakan koneksi Internet telepon Anda (4G/3G/2G/EDGE atau Wi-Fi, jika tersedia) yang memungkinkan Anda mengirim pesan dan menelepon teman dan keluarga. Beralihlah dari SMS ke WhatsApp untuk mengirim dan menerima pesan, panggilan, video, dokumen, dan Pesan Suara.",
            "LINE membentuk ulang komunikasi di dunia, memungkinkan kamu untuk tidak hanya menikmati layanan pesan, tetapi juga panggilan suara dan video gratis di mana pun kamu berada. Unduh LINE dan temukan alasan mengapa aplikasi ini populer di dunia dan menjadi aplikasi nomor 1 yang paling sering diunduh di 52 negara.",
            "Mengikuti berita teman kini lebih cepat dari sebelumnya, seperti mengetahui apa yang dilakukan teman, berbagi pembaruan, foto, dan video, mendapat pemberitahuan ketika teman menyukai dan mengomentari kiriman Anda, memainkan permainan dan menggunakan aplikasi favorit, dan jual beli secara lokal di Marketplace Facebook. Sekarang Anda dapat mengakses versi terbaru Facebook untuk Android lebih awal dengan menjadi penguji versi beta.",
            "Dengan Spotify, kamu memiliki akses ke dunia musik dan podcast. Kamu bisa mendengarkan artis dan album, atau membuat playlist sendiri berisi lagu-lagu favoritmu. Ingin menemukan musik baru? Pilih playlist sudah jadi yang sesuai dengan suasana hati atau dapatkan rekomendasi yang telah dipersonalisasi.",
            "Sedang mencari berbagai acara TV dan film dari seluruh belahan dunia yang saat ini sedang menjadi topik pembicaraan? Semuanya ada di Netflix. Kami punya serial, film, dokumenter, dan acara komedi stand-up spesial pemenang penghargaan.",
            "Gojek bukan hanya aplikasi penyedia layanan transportasi, pesan antar makanan, logistik, pembayaran, dan kebutuhan sehari-hari, loh. Gojek juga punya misi sosial untuk meningkatkan taraf hidup masyarakat. Caranya? Dengan saling membantu! Sampai hari ini, Gojek telah bermitra dengan lebih dari 1 juta driver, 125 ribu pedagang kuliner, dan 30 ribu penyedia jasa lainnya, semua tersebar di 50 kota di Indonesia.",
    };

    private static String[] appImages = {
            "https://dgi.or.id/wp-content/uploads/2016/06/Instagram-v051916.png",
            "https://www.pidas81.org/wp-content/uploads/2015/03/t2.png",
            "https://storage.googleapis.com/gweb-uniblog-publish-prod/images/YouTube.max-1100x1100.png",
            "https://miro.medium.com/max/1024/1*hLTrJX4KQ6dKFOUdF9h5Tg.png",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/WhatsApp.svg/1200px-WhatsApp.svg.png",
            "https://is1-ssl.mzstatic.com/image/thumb/Purple114/v4/60/22/49/60224947-05e8-fbd8-730d-89a8cf2f7da7/LINE.png/1200x630bb.png",
            "https://i.pinimg.com/originals/30/99/af/3099aff4115ee20f43e3cdad04f59c48.png",
            "https://i.pinimg.com/originals/7a/ec/a5/7aeca525afa2209807c15da821b2f2c6.png",
            "https://www.freepnglogos.com/uploads/netflix-logo-circle-png-5.png",
            "https://avatars1.githubusercontent.com/u/29785210?s=200&v=4"
    };

    static ArrayList<Playstore> getListData() {
        ArrayList<Playstore> list = new ArrayList<>();

        for (int position = 0; position < appNames.length; position++) {
            Playstore playstore = new Playstore();
            playstore.setsName(appNames[position]);
            playstore.setsDetail(appDetails[position]);
            playstore.setsPhoto(appImages[position]);
            list.add(playstore);
        }
        return list;
    }
}
