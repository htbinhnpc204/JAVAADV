/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ontap_C;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */

//nhap vao n,tinh tong s biet n chan:2+4.... va n le = 1+3...
public class bai47 {
    private static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("nhap vao n");
        int n= sc.nextInt();
        int  s=0;
        if(n%2==0)
            for(int i=0;i<=n;i+=2)
            {
                 s= s+i;
            }
        else{
            for(int j=1;j<=n;j++){
                s=s+j;
            }
        }
        System.out.println(s);
    }
}
