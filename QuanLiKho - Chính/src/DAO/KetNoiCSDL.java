/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.KetNoiSQL;

/**
 *
 * @author Dai
 */
public class KetNoiCSDL {
      public static Connection getConnection(){
      Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=demo;username:sa;password=12345");
            String url = "jdbc:sqlserver://localhost:1433; databaseName= QLkho;integratedSecurity= true;";
            String user = "sa";
            String pass = "12345";
            conn = DriverManager.getConnection(url);
            System.out.println("ket noi thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
      
      
      private Connection con = null;

    static public Connection KetNoiSQL() throws SQLException {
        String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLKho";
            return DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

      public static void main(String[] args) throws SQLException {
          System.out.println(getConnection());
    }


}
