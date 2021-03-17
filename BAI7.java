/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
Viết chương trình giải phương trình bậc 1: ax + b = 0 (a, b nhập từ bàn phím).
Xét tất cả các trường hợp có thể.
*/
package j250baitap;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class BAI7 {
	public void ptbac1(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Nhap a, b: ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		System.out.println(+a+"x + "+b +" = 0");
		if (a == 0){
			if (b == 0)
				System.out.println("Phuong trinh vo so nghiem");
			else
				System.out.println("Phuong trinh vo nghiem");
		}
		else
			System.out.println("Phuong trinh co nghiem x = "+(double)(-b/a));
	}
	public static void main(String[] args) {
		BAI7 obj = new BAI7();
		obj.ptbac1();
	}
}
