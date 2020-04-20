public class Manusia {
    private String nama, ktp;
    private int umur;

    public Manusia(String nama, String ktp, int umur) {
        this.nama = nama;
        this.ktp = ktp;
        this.umur = umur;
    }

    public void makan(){
        System.out.println("Sedang makan");
    }

    public void makan(String nama){
        System.out.println( nama + " sedang makan");
    }

    public void tidur(String nama){
        System.out.println( nama + " sedang tidur");
    }

    public void makan(String nama, int umur){
        System.out.println( nama + " dengan umur " + umur + "sedang makan");
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
}
