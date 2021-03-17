/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 Viết chương trình nhập vào số x chỉ số đo của một góc, tính bằng phút. Cho
biết nó thuộc góc vuông thứ bao nhiêu của vòng tròn lượng giác.
Tính cos(x), dùng hàm do math.h cung cấp.
*/
package j250baitap;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class BAI9 {
	public void kiemtra(){
		Scanner sc =  new Scanner(System.in);
		System.out.println("Nhap so do x cua goc (phut): ");
		double angle = sc.nextDouble();
		angle = angle / 60;
		System.out.println("x thuoc goc vuong thu "+Math.ceil(angle/90));
		System.out.println("Cos(x) = "+Math.cos(angle * 3.14 / 180));
	}
	public static void main(String[] args) {
		BAI9 obj = new BAI9();
		obj.kiemtra();
	}
}
