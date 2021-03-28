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
//tim so fibo thu n
public class bai43 {
    private static final Scanner sc = new Scanner(System.in);
    public static int fibo(int n){
        int fi=2 , f1 = 0, f2 = 1;
        if(n == 1 || n == 2){
            return 1;
        }
        else{
            for(int i=2;i<=n;i++){
                fi = f1 + f2;
                f1 = f2;
                f2 = fi;
            }
            return fi;
        }
    }
    public static void main(String[] args) {
        System.out.println("nhap vao n<40 ");
        int n=sc.nextInt();
        System.out.println(fibo(n));
        
    }
}
