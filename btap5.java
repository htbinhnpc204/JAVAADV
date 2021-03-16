import java.util.Scanner;

class position {
    int x, y;
}

public class btap5 extends position {

    position a = new position();
    position b = new position();
    position c = new position();

    static Scanner sc = new Scanner(System.in);

    static double getArea(position a, position b, position c){
        return 0.5 * Math.abs(a.x * b.y - b.x * a.y + b.x * c.y - c.x * b.y + c.x * a.y - a.x * c.y);
    }

    double getArea() {
        return 0.5 * Math.abs(a.x * b.y - b.x * a.y + b.x * c.y - c.x * b.y + c.x * a.y - a.x * c.y);
    }

    public static void main(String[] args) {
        btap5 tgiac1 = new btap5();
        System.out.println("Nhap toa do cua dinh A(x, y): ");
        tgiac1.a.x = sc.nextInt();
        tgiac1.a.y = sc.nextInt();
        System.out.println("Nhap toa do cua dinh B(x, y): ");
        tgiac1.b.x = sc.nextInt();
        tgiac1.b.y = sc.nextInt();
        System.out.println("Nhap toa do cua dinh C(x, y): ");
        tgiac1.c.x = sc.nextInt();
        tgiac1.c.y = sc.nextInt();
        System.out.println("Nhap toa do cua dinh M(x, y): ");
        position M = new position();
        M.x = sc.nextInt();
        M.y = sc.nextInt();

        double area = tgiac1.getArea();

        double d = getArea(M, tgiac1.a, tgiac1.b) + getArea(M, tgiac1.a, tgiac1.c) + getArea(M, tgiac1.b, tgiac1.c) - area;

        if( d > 0 ){
            System.out.println("M nam ngoai tam giac ABC");
        }
        else if ( getArea(M, tgiac1.a, tgiac1.b) == 0 
                    || getArea(M, tgiac1.a, tgiac1.c) == 0 
                    || getArea(M, tgiac1.b, tgiac1.c) == 0 )
            System.out.println("M nam tren canh tam giac ABC");
        else
            System.out.println("M nam trong tam giac ABC");
    }
}
