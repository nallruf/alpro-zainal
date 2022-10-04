import java.util.Scanner;

public class Siakad {
    static Mahasiswa[] mhs = new Mahasiswa[1000];
    static Scanner inp = new Scanner(System.in);
    static int jmlData = 0;
   
    public static void main(String[] args) {
    
        int menu = 0;
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu = ");
            menu = inp.nextInt();
            if (menu == 1) {
               tambahData();
            } else if(menu == 2) {
              tampilData();
            }
        } while (menu != 3);

    }

    public static void tambahData(){
        String nama, nim;
        System.out.println("Silahkan tambahkan data ");
        System.out.print("Masukkan NIM anda = ");
        nim = inp.next();
        inp.nextLine();
        System.out.print("Masukkan Nama anda = ");
        nama = inp.nextLine();
        mhs[jmlData] = new Mahasiswa();
        mhs[jmlData].setNama(nama);
        mhs[jmlData].setNim(nim);
        jmlData++;
    }

    public static void tampilData(){
        System.out.println("Berikut data anda");
            for (int j = 0; j < jmlData; j++) {
                System.out.println("NIM : "+ mhs[j].getNim());
            System.out.println("Nama : "+ mhs[j].getNama());
            }
    }
}
