/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai11;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Tran Dai
 */


public class bai10 {
    public static void main(String[] args) throws IOException {
        int hm = 0,cp = 0;
        int w=0,l=0;
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        while (true) {            
        System.out.print("nhap (b-d-k e:Thoat) : ");
        char temp = sc.nextLine().charAt(0);
        if(temp == 'e') break;
        switch(temp){
            case 'k' :hm =1; break;
            case 'd' : hm= 2;break;
            case 'b' : hm = 3;break;
        }
        System.out.println("Ban : "+temp);
        cp = rd.nextInt(5);
        switch(cp%3){
            case 0 : temp ='b'; break;
            case 1 : temp = 'k';break;
            case 2 : temp = 'd';break;
        }
        System.out.println("May : "+temp);

        if(hm - cp  == 3 ||hm - cp == 0 ){
            System.out.println("Hoa");
        }
        if(hm - cp  == 2 ||hm - cp == -1){
            System.out.println("Thua");      
            l++;
        }
        if(hm - cp  == 1 ||hm - cp == -2){
            System.out.println("Thang");
            w++;
        }
        System.out.println("Ti so  Thang : "+w+"  Thua : "+l);   
        }


    }
}
