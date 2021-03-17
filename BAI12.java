/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Viết chương trình giải hệ phương trình 2 ẩn:
a1x + b1y = c1
a2x + b2y = c2
Các hệ số a1, a2, b1, b2, c1, c2 nhập từ bàn phím. Xét tất cả các trường hợp cụ thể.
*/
package j250baitap;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class BAI12 {
	public void pthaian(){
		Scanner sc = new Scanner(System.in);
		System.out.println("a1x + b1y = c1");
		System.out.println("Nhap a1, b1, c1:");
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		int c1 = sc.nextInt();
		System.out.println("\na2x + b2y = c2");
		System.out.println("Nhap a2, b2, c2:");
		int a2 = sc.nextInt();
		int b2 = sc.nextInt();
		int c2 = sc.nextInt();
		double d = ( a1 * b2 - a2 * b1 );
		double dx = ( c1 * b2 - c2 * b1 );
		double dy = ( a1 * c2 - a2 * c1 );
		if (d == 0)
			if (dx + dy == 0)
				System.out.println("He phuong trinh co vo so nghiem");
			else
				System.out.println("He phuong trinh vo nghiem");
		else{
			System.out.println("He phuong trinh co nghiem x = "+(dx / d) + " ,y = "+(dy / d));
		}
	}
	public static void main(String[] args) {
		BAI12 obj = new BAI12();
		obj.pthaian();
	}
}
