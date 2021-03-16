import java.util.Scanner;

public class btap3 {

    static Scanner sc = new Scanner(System.in);
    
    double x, y, r;

    public btap3(){
    }

    static double distant(double x1, double y1, double x2,double y2){
        return Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
    }

    public static void main(String[] args) {
        btap3 toadoC = new btap3();
        System.out.println("Nhap toa do C(x, y): ");
        toadoC.x = sc.nextDouble();
        toadoC.y = sc.nextDouble();

        System.out.println("Nhap ban kinh Rc: ");
        toadoC.r = sc.nextDouble();
        toadoC.r = Math.round(toadoC.r*10) / 10.0; 
        btap3 toadoM = new btap3();
        System.out.println("Nhap toa do M(x, y): ");
        toadoM.x = sc.nextDouble();
        toadoM.y = sc.nextDouble();

        double distant = distant(toadoC.x, toadoC.y, toadoM.x, toadoM.y);
        if(distant == toadoC.r)
            System.out.println("M nam tren C()");
        else if(distant > toadoC.r)
            System.out.println("M nam ngoai C()");
        else
            System.out.println("M nam trong C()");
    }
}
