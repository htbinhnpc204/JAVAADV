import java.util.Scanner;

public class Bai25 {
    public static int UCLN(int a, int b){
        while (a!=b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap a= ");
        int a = sc.nextInt();
        System.out.printf("Nhap b= ");
        int b = sc.nextInt();
        System.out.printf("Uoc chung lon nhat cua " +a+ " va " +b+ " la: "+ UCLN(a,b));
        System.out.printf("\nBoi chung nho nhat cua " +a+ " va " +b+ " la: "+(a*b)/(UCLN(a,b)));
    }
}
