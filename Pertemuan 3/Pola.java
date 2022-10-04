import java.util.Scanner;

public class Pola {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        
        int n;
        System.out.print("Masukkan nilai n = ");
        n = inp.nextInt();

       for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                if ((j <= i || j>=(n+1)-i) && (j>=1 || j<=(n+1)-i)) {
                    System.out.print("*");
                } else {
                    System.out.println(" ");
                }
            }
            System.out.println();
       }
    }
}
