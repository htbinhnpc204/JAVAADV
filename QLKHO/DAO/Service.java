/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ItemChart;

/**
 *
 * @author Dai
 */
public class Service {

    static Connection con = KetNoiCSDL.getConnection();

    // 
    // lấy tổng số luong nhập trong 5 tháng
    static public List<ItemChart> Chart(String thang) throws SQLException {
        List<ItemChart> itemCharts = new ArrayList<>();
        String query = "use QLKHO\n"
                + "select * from (select top " + thang + " ((CAST(MONTH(ngay) as varchar(10))+'/'+CAST(year(ngay) as varchar(10)))) as thang,SUM(soluong) as tong, ngay from HoaDon,ChiTietHoaDon\n"
                + "where HoaDon.MaHD = ChiTietHoaDon.MaHD\n"
                + "group by Ngay\n"
                + "order by ngay desc) as temp\n"
                + "order by ngay asc";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            itemCharts.add(new ItemChart(rs.getString(1), Double.parseDouble(rs.getString(2))));
        }

        return itemCharts;

    }

    static public String insertHoaDon(String maNV, String tenKH, String loai) throws SQLException, UnsupportedEncodingException {
        String query = " use QLKHO\n exec dbo.insertHoaDon_pr ?,?,?";
        PreparedStatement ps = con.prepareCall(query);
        ps.setString(1, maNV);
        ps.setString(2, tenKH);
        ps.setString(3, new String(loai.getBytes("iso-8859-1"),"utf-8"));
   
           ResultSet rs = ps.executeQuery();
       rs.next();
       return rs.getString(1);
    }
    
      static public void insertChiTietHoaDon(String maHD, String masach, String soluongString, String dongia) throws SQLException {
        String query = " use QLKHO\n insert into chitietHoadon values(?,?,?,?)";
        PreparedStatement ps = con.prepareCall(query);
        ps.setString(1, maHD);
        ps.setString(2, masach);
        ps.setString(3, soluongString);
        ps.setString(4, dongia);
        ps.execute();
    }

}
