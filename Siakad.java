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
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. UAS");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu = ");
            menu = inp.nextInt();
            if (menu == 1) {
               tambahData();
            } else if(menu == 2) {
              tampilData();
            } else if(menu == 3){
                urutkanData();
            } else if(menu == 4){
                cariData();
            } else if(menu == 5){
                editData();
            } else if(menu == 6){
                hapusData();
            } else if(menu == 7){
                uas();
            }
        } while (menu != 8);

    }

    // START SORT DATA
    public static void urutkanData(){
        System.out.println("Pilih algoritma pengurutan");
        System.out.println("1. Exchange Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Quick Sort");
        System.out.println("5. Shell Sort");
        System.out.println("Pilih algoritma = ");
        int menu = inp.nextInt();
        switch (menu) {
            case 1:
                exchangeSort();
                break;
            case 2:
                selectionSort();
                break;
            case 3:
                bubbleSort(mhs);
                break;
            case 4:
                quickSort(mhs, 0, jmlData-1);
                break;
            case 5:
                shellSort(mhs);
                break;
        }
    }
    
    public static void exchangeSort(){
        for (int x =0; x<jmlData; x++){
            for(int y = x+1; y<jmlData ;y++){
                if (mhs[x].getNim()>mhs[y].getNim()) {
                    Mahasiswa temp = mhs[x];
                    mhs[x] = mhs[y];
                    mhs[y] = temp;
                }
            }
        }  
    }
        
    public static void selectionSort(){
        int i, j;   
        int n=mhs.length;
        for(i=0; i< n-1;i++){
            int currMin = i;
            for (j=i+1; j<n; j++){
                if(mhs[j] == null){
                    continue;
                }
                if(mhs[j].getNim() < mhs[currMin].getNim()){
                    currMin=j;
                }            
            Mahasiswa temp = mhs[currMin];   
            mhs[currMin] = mhs[i]; 
            mhs[i]=temp;
            }
        }
    }
    
    public static void bubbleSort(Mahasiswa[] target){
        int n = target.length;
        for (int i=0; i<n-1;i++){
            for (int j=0; j<n-i; j++){
                if(target[j] == null){
                    continue;
                }
                if(target[j+1] == null){
                    continue;
                }
                if (target[j].getNim()>target[j+1].getNim()){
                    Mahasiswa temp = target[j];
                    target[j] = target[j+1];
                    target[j+1]=temp;
                }
            }
        }
    }

    public static void quickSort(Mahasiswa[] target, int low, int high){
        if(low < high){
            int p = partition(target, low, high);
            quickSort(target, low, p-1);
            quickSort(target, p+1, high);
        }
    }

    static int partition(Mahasiswa[] target, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(target[j].getNim()<target[low].getNim())
                swap(target, ++p, j);
    
        swap(target, low, p);
        return p;
    }

    static void swap(Mahasiswa[] target, int low, int pivot){
        Mahasiswa tmp = target[low];
        target[low] = target[pivot];
        target[pivot] = tmp;
    }

    public static void shellSort(Mahasiswa[] target){
        int n = target.length;
        for (int gap = n/2; gap > 0; gap/=2){
            for (int i = gap; i < n; i+= 1){
                Mahasiswa temp = target[i];
                int j = i;  
                if(target[j] == null){
                    continue;
                }
                for (j = i; j>=gap && target[j-gap].getNim()>temp.getNim(); j-= gap){
                    target[j] = target[j-gap];
                }
                target[j] = temp;
            }
        }
    }
    //END SORT DATA

    // START TAMBAH DATA
    public static void tambahData(){
        String ulang = "y";
        do {
            String nama;
            int nim;
            System.out.println("Silahkan tambahkan data ");
            System.out.print("Masukkan NIM anda = ");
            nim = inp.nextInt();
            inp.nextLine();
            System.out.print("Masukkan Nama anda = ");
            nama = inp.nextLine();
            mhs[jmlData] = new Mahasiswa();
            mhs[jmlData].setNama(nama);
            mhs[jmlData].setNim(nim);
            jmlData++;

            System.out.println("apakah ingin menambahkan data lagi(y/t)");
            ulang = inp.nextLine();
        } while (ulang.equalsIgnoreCase("y"));

    }
    // END TAMBAH DATA

    //START TAMPIL DATA 
    public static void tampilData(){
        System.out.println("Berikut data anda :");
            for (int j = 0; j < jmlData; j++) {
            System.out.println("--------------------------------------"); 
            System.out.println("Data ke-"+(j+1)); 
            System.out.println("\nNama:" + mhs[j].getNama()); 
            System.out.println("NIM:" + mhs[j].getNim()); 
            System.out.println("--------------------------------------"); 
            // System.out.println("Nama : "+ mhs[j].getNama());
            }
    }
    // END TAMPIL DATA

    // START CARI DATA
    public static void cariData(){
        int search;
        System.out.println("--------------------------------------"); 
        System.out.println("NIM yang ingin dicari: ");
        System.out.println("--------------------------------------"); 
        search = inp.nextInt();
        int pilih;
        System.out.println("Pilih Algoritma Pencarian");
        System.out.println("1. Binary Search");
        System.out.println("2. Linear Search");
        System.out.print("Silahkan pilih algoritma: ");
        pilih = inp.nextInt();
        switch(pilih){
            case 1:
            binarySearch(search);
            break;
            case 2:
            linearSearch(search);
            break;
        }

    }

    public static void linearSearch(int target){
        int result = getLinear(mhs, target);
        if (result == -1){
            System.out.println("Data Tidak Ada");
           }
           else{
            System.out.println("--------------------------------------"); 
            System.out.println("Data Yang Anda Cari :"); 
            System.out.println("\nnama:" + mhs[result].getNama()); 
            System.out.println("nim:" + mhs[result].getNim()); 
            System.out.println("--------------------------------------"); 
           }
    }

    public static int getLinear(Mahasiswa[] arr, int x) {
        for (int i = 0; i<arr.length; i++){
            if (arr[i].getNim()==x){
                return i;
            }
        }
        return -1;
    }

    public static void binarySearch(int target){
        int result = getBinary(mhs, jmlData-1, 0, target);
        if (result == -1){
         System.out.println("Data Tidak Ada");
        }
        else{
         System.out.println("--------------------------------------"); 
         System.out.println("Data Yang Anda Cari :"); 
         System.out.println("\nnama:" + mhs[result].getNama()); 
         System.out.println("nim:" + mhs[result].getNim()); 
         System.out.println("--------------------------------------"); 
        }
     }
 
     public static int getBinary(Mahasiswa[] arr, int r, int l, int x) {
         if (r>=l){
             int mid = (l + r)/2;
             if (arr[mid].getNim()==x){
                 return mid;
             }
             if (arr[mid].getNim()>x){
                 return getBinary(arr, mid-1, l, x );
             }
             return getBinary(arr, r, mid+1, x);
         }
         return -1;
     }
    // END CARI DATA 

    // START EDIT DATA
    public static void editData(){
        long nim;
        String nama;

        System.out.println("Data Ke Berapa Yang Ingin Diedit? : ");
        int index = inp.nextInt();
        inp.nextLine();
        
        System.out.println("--------------------------------------"); 
        System.out.print("Data Yang Akan Diedit : ");
        System.out.println("\nNama : "+ mhs[index-1].getNama());
        System.out.println("NIM : "+ mhs[index-1].getNim());
        System.out.print("\nEdit Data Tersebut? (y/n) : ");
        String opsi =inp.next();
        System.out.println("--------------------------------------");
        inp.nextLine();
        switch (opsi) {
            case "y":
                System.out.print("\nNama : ");
                nama = inp.nextLine();
        
                System.out.print("NIM : ");
                nim = inp.nextLong();
                inp.nextLine();
        
                mhs[index - 1].setNim(nim);
                mhs[index - 1].setNama(nama);
        
                System.out.println();
                break;
            
            case "n":
                editData();
                break;
        }  
    }
    // END EDIT DATA

    // START HAPUS DATA
    public static void hapusData(){
        System.out.println("Data Ke Berapa Yang Ingin Dihapus? : ");
        int index = inp.nextInt();
        inp.nextLine();

        System.out.println("--------------------------------------"); 
        System.out.println("Data Yang Akan Dihapus : ");
        System.out.println("\nNama : "+ mhs[index-1].getNama());
        System.out.println("NIM : "+ mhs[index-1].getNim());
        System.out.print("\nHapus Data Tersebut? (y/n) : ");
        String opsi =inp.next();
        System.out.println("--------------------------------------");
        inp.nextLine();
        switch (opsi) {
            case "y":
                for(int i = index; i < jmlData; i++) {
                    mhs[index - 1].setNim(mhs[index].getNim());
                    mhs[index - 1].setNama(mhs[index].getNama());
                }
                break;
    
            case "n":
                hapusData();;
                break;
        }  
        jmlData -= 1;
        System.out.println();
    }
    // END HAPUS DATA

    // START UAS
    public static String uas() {
        int jarak = jmlData;
        int susut = 13;
        int urut = 0;
        Mahasiswa temp;

        if(jmlData != 0) {
            do {
                jarak = (jarak * 10) / susut;

                if(jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                } 

                for(int i = 0; (i + jarak) < jmlData; i++) {
                    if(mhs[i].getNim() > mhs[i + jarak].getNim()) {
                        temp = mhs[i];
                        mhs[i]=mhs[i+jarak];
                        mhs[i+jarak]=temp;
                        urut = 0;
                    }
                }
            } while(urut == 0);
        } else {
            return "Tidak Ada Data";
        }

       return  "Data telah diurutkan, silakan tampilkan data!";
       
    }
    // END UAS
}
