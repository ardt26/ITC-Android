public class Mahasiswa extends Manusia implements Bernyanyi{
    private String nim;
    private double IPK;

    public Mahasiswa(String nama, String ktp, int umur, String nim, double IPK) {
        super(nama, ktp, umur);
        this.nim = nim;
        this.IPK = IPK;
    }

    void belajar(){
        System.out.println("Sedang belajar");
    }

    void doTugas(){
        System.out.println("Ngerjain tugas");
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public double getIPK() {
        return IPK;
    }

    public void setIPK(double IPK) {
        this.IPK = IPK;
    }

    @Override
    public void makan(String nama) {
        super.makan(nama);
    }

    @Override
    public void tidur(String nama) {
        super.tidur(nama);
    }

    @Override
    public void bernada() {
        System.out.println(super.getNama() + " sedang bernyanyi");
    }

    @Override
    public void menari(String gerakan) {
        System.out.println(super.getNama() + " joget " + gerakan);
    }
}
