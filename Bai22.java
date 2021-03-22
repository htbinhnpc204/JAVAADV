import java.util.Scanner;

public class Bai22 {
    public static int countdem(int a) {
        int dem = 0;
        int sum = 0;
        int n = a;
        int i;
        for (i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.printf("\n"+i);
                dem++;
                sum += i;
            }
        }

        System.out.printf("\nCo uoc so la: " + dem);
        System.out.printf("\nTong uoc la: " + sum);

        return 0;
    }
        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            System.out.printf("Nhap so: ");
            int a = sc.nextInt();

            countdem(a);
        }}
