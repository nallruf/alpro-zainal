import java.util.Scanner;

/**
 * Penjumlahan
 */
public class Penjumlahan {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int x,y, hasil;
        System.out.println("Selamat Datang di Program Penjumlahan");
        System.out.print("Masukkan Nilai X = ");
        x = inp.nextInt();
        System.out.print("Masukkan Nilai Y = ");
        y = inp.nextInt();
        hasil = x + y;
        System.out.println("Hasil Penjumlahan "+x+" + "+y+" = "+hasil);
    }
}