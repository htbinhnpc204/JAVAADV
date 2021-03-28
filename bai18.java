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
public class bai18{

    private static Scanner sc = new Scanner(System.in);
        public static void main(String[] args) {
            System.out.println("nhap vao so giờ");
            int h=sc.nextInt();
            System.out.println("so tuan la "+ h/(24*7));
            System.out.println("so ngay la "+ (h%(24*7))/24);
            System.out.println("so gio la "+ (h%(24*7))%24);
    }
    }
