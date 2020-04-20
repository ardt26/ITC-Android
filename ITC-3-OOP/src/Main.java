public class Main {

    public static void main(String[] args) {
        Mahasiswa anjar = new Mahasiswa("Bagas","123",19,"123180999",4.0);
        anjar.setNama("Anjar");
        anjar.setNim("123180056");
        anjar.setIPK(4.0);

        System.out.println("Nama : " + anjar.getNama());
        System.out.println("NIM : " + anjar.getNim());
        System.out.println("IPK : " + anjar.getIPK());

        anjar.belajar();
        anjar.doTugas();

        Manusia manusia = new Manusia("Bagas","234", 18);
        Mahasiswa mahasiswa = new Mahasiswa("Rama","123",20,"123180053",4.0);

        System.out.println("Nama : " + manusia.getNama());
        System.out.println("KTP : " + manusia.getKtp());
        System.out.println("Umur : " + manusia.getUmur());
        System.out.println();

        manusia.makan(manusia.getNama());
        manusia.tidur(manusia.getNama());
        System.out.println();

        System.out.println("Nama : " + mahasiswa.getNama());
        System.out.println("KTP : " + mahasiswa.getKtp());
        System.out.println("NIM : " + mahasiswa.getNim());
        System.out.println("Umur : " + mahasiswa.getUmur());
        System.out.println("IPK : " + mahasiswa.getIPK());
        System.out.println();

        mahasiswa.makan(mahasiswa.getNama());
        mahasiswa.tidur(mahasiswa.getNama());
        System.out.println();

        mahasiswa.bernada();
        mahasiswa.menari("Tik-tok");
	}
}
