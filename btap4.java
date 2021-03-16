import java.util.Scanner;
public class btap4 {
    static Scanner sc = new Scanner(System.in);
    
    double a, b, c;

    public btap4(){
    }

    static boolean isTriangle(double a, double b, double c){
        return (a+b) > c || (a+c)>b || (b+c) > a;
    }

    void typeTriagle(){
        int f=0;
        if ( a == b || b == c || c == a ) f += 1;
        if ( a == b && b == c ) f += 1;
        if ( a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a )
        f += 3;
        switch ( f ) {
            case 0: System.out.println( "Tam giac thuong\n" ); break;
            case 1: System.out.println( "Tam giac can\n" ); break;
            case 2: System.out.println( "Tam giac deu\n" ); break;
            case 3: System.out.println( "Tam giac vuong\n" ); break;
            case 4: System.out.println( "Tam giac vuong can\n" );
        }
        double p = (a +b +c)/2;
        System.out.println("Dien tich: "+((p-a)*(p-b)*(p-c)));
    }

    public static void main(String[] args) {
        btap4 tgiac = new btap4();
        System.out.println("Nhap vao 3 canh cua tam giac: ");
        tgiac.a = sc.nextDouble();
        tgiac.b = sc.nextDouble();
        tgiac.c = sc.nextDouble();

        if(!isTriangle(tgiac.a, tgiac.b, tgiac.c))
            System.out.println("Khong phai tam giac");
        else{
            tgiac.typeTriagle();
        }
    }
}