/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Viết chương trình nhập vào ba số nguyên. Hãy in ba số này ra màn hình theo
thứ tự tăng dần và chỉ dùng tối đa một biến phụ.
*/
package j250baitap;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class BAI6 {
	public void Sapxep(){
		Scanner sc = new Scanner(System.in);
		int t;
		System.out.println("Nhap a, b, c: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if (a < b){
			t = a;
			a = b;
			b = t;
		}
		if (a < c){
			t = a;
			a = c;
			c = t;
		}
		if (b < c){
			t = b;
			b = c;
			c = t;
		}
		System.out.println("Tang dan: " +c +" " +b+" " +a);
	}	
	public static void main(String[] args) {
		BAI6 obj = new BAI6();
		obj.Sapxep();
	}
}
