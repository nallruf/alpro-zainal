import java.util.Scanner;

public class PerulanganGenap {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        
        int n;
        System.out.print("Masukkan nilai n = ");
        n = inp.nextInt();

        int i = 1;

        while (i <= (2*n)) {
            if (i %2 == 0 ) {
                System.out.print(i +" ");
            }
            i+=1;
        }

        System.out.println(" ");



    }    
}
