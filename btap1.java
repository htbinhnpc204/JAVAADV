import java.util.Scanner;

public class btap1 {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nhap vao dien tich S: ");
        double S = sc.nextDouble();
        double r = Math.sqrt(S/(4*Math.PI));
        System.out.println("The tich V la: " + (4 * Math.PI * Math.pow(r, 3) / 3));
    }
}
