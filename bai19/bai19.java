/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates. ví dụ để pull
 * and open the template in the editor.
 */
package bai19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Tran Dai
 */
public class bai19 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        System.out.print("Nhap Gio Phut Giay (1)(vd 02:24:44) : ");
        String str = sc.nextLine();
        Date date = formatter.parse(str);
        System.out.print("Nhap Gio Phut Giay (1)(vd 02:24:44) : ");
        str = sc.nextLine();
        d = formatter.parse(str);
        int s = (int) Math.abs(d.getTime()-date.getTime())/1000;
        System.out.print((s/3600)+" gio ");
        s%=3600;
        System.out.print((s/60)+ " phut "+ s%60 + " giay");
    }
}
