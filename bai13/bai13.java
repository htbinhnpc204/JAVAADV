/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Dai
 */
public class bai13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("nhap ngay thang nam (vd: 24/01/2001) : ");
        String ds = sc.nextLine();
        try {
            d= formatter.parse(ds);
            System.out.println("hop le");
        } catch (ParseException ex) {
//            Logger.getLogger(bai13.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("khong hop le");
        }
        
        formatter = new SimpleDateFormat("EEEE");
        System.out.println(formatter.format(d));
    }
}
