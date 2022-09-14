import java.util.Scanner;

public class Percabangan {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        String nama;
        int nilai;

        System.out.println("Selamat Datang");
        System.out.print("Masukkan Nama : ");
        nama = inp.nextLine();
        System.out.print("Masukkan Nilai : ");
        nilai = inp.nextInt();

        if (nilai >= 60){
            System.out.println("Selamat "+nama+", Anda Lulus");
        }else{
            System.out.println("Mohon Maaf "+ nama +", Anda Belum Lulus");
        }
    }
}
