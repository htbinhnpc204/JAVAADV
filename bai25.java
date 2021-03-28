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
//uscln và bcnn
public class bai25{
    private static final Scanner sc = new Scanner(System.in);
    public static int USCLN(int a, int b){
       if(a==b) return a;
        while(a!=b){
           if(a>b) 
                a=a-b;
           else
               b=b-a;
                }
        return a;
    }
    public static int BCNN(int a,int b)
    {
        return (a*b/USCLN(a,b));
    }
    public static void main(String[] args) {
        System.out.println("nhap vao a ");
        int a=sc.nextInt();
        System.out.println("nhap vao b ");
        int b=sc.nextInt();
        System.out.println("USCLN la "+USCLN(a,b));
        System.out.println("BCNN la "+BCNN(a,b));
        
    }
}
