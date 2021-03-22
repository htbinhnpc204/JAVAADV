
import java.util.Scanner;
    public class Bai20 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double tiendien;
            double KW;
            System.out.println("Nhap so KW tieu thu: ");
            KW = sc.nextDouble();
            if (KW <= 100)
                tiendien = KW * 500;
            else {
                if (KW <= 250)
                    tiendien = 500 * 100 + 800 * (KW - 100);
                else {
                    if (KW <= 350)
                        tiendien = 500 * 100 + 800 * (250 - 100) + 100 * (KW - 250);
                    else
                        tiendien = 500 + 100 + 800 * (250 - 100) + 1000 * (350 - 250) + 1500 * (KW - 350);

                }
            }
            System.out.println("Chi phi: " + tiendien);
        }
    }



