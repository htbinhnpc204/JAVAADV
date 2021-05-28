package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DOTNETGROUP
 */
public class KetNoiSQL {

    private Connection con = null;

    public void KetNoi() {
        String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:sqlserver://localhost:1433; databaseName= QLKho";
            con = DriverManager.getConnection(dbUrl,"sa","12345");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	public ResultSet GetResultSet(String tableName, String a) throws SQLException {
	    ResultSet rs = null;
	    Statement stmt = con.createStatement();
	    String sql = "select * from " + tableName + " order by ngay " + a;
	    rs = stmt.executeQuery(sql);
	    return rs;
	}
	
	public ResultSet getDataById(String tableName, String mahd) throws SQLException {
	    ResultSet rs = null;
	    Statement stmt = con.createStatement();
	    String sql = "select * from " + tableName + " where MaHD = '" + mahd +"'";
	    rs = stmt.executeQuery(sql);
	    return rs;
	}
	
    public void Close() throws Exception {
        con.close();
    }
    public static void main(String[] args) {
//        KetNoiSQL
//        System.out.println("");
    }

}
