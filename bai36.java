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
//in n so nguyen to dau tien
public class bai36 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("nhap vao n ");
        int n = sc.nextInt();
        int i,k,count;
        k=2;
        count=0;
        while(count<n){
            for(i=2;i*i<=k;i++)
                if(k%i==0)break;
           if(i*i>k){
               System.out.println(k);
               count++;
           }
           k++;
        }

    }
}
