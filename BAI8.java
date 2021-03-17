/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Viết chương trình giải phương trình bậc 2: ax2 + bx + c = 0 (a, b, c nhập từ
bàn phím). Xét tất cả các trường hợp có thể.
*/
package j250baitap;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class BAI8 {
	public void ptbac2(){
		Scanner sc = new Scanner(System.in);
		System.out.println("ax^2 + bx + c = 0");
		System.out.println("Nhap a, b, c: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if (a == 0)
			if (b == 0)
				System.out.println("Phuong trinh vo nghiem");
			else
				System.out.println("x = "+(double)(-c/b));
		else{
			float d = b * b - 4 * a * c;
			if (d > 0)
				System.out.println("x1 = "+(-b + Math.sqrt(d)) / (2 * a) + "\nx2 = "+(-b - Math.sqrt(d)) / (2 * a));
			else
				if (d == 0)
					System.out.println("x1 = x2 = "+(double)(-b / (2 * a)));
				else
					System.out.println("Phuong trinh vo nghiem");
		}
	}
	public static void main(String[] args) {
		BAI8 obj = new BAI8();
		obj.ptbac2();
	}
}
