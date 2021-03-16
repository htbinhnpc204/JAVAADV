import java.util.Scanner;

public class btap2 {

    static Scanner sc = new Scanner(System.in);
    
    double x, y;

    public btap2(){
    }

    static double distant(double x1, double y1, double x2,double y2){
        return Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
    }

    public static void main(String[] args) {
        btap2 toado1 = new btap2();
        btap2 toado2 = new btap2();

        System.out.println("Nhap vao x1: ");
        toado1.x = sc.nextDouble();
        System.out.println("Nhap vao y1: ");
        toado1.y = sc.nextDouble();
        System.out.println("Nhap vao x2: ");
        toado2.x = sc.nextDouble();
        System.out.println("Nhap vao y2: ");
        toado2.y = sc.nextDouble();
        double distant = distant(toado1.x, toado1.y, toado2.x, toado2.y);
        System.out.println(distant);
    }
}
