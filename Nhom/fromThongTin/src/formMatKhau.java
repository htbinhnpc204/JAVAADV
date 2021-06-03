
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class formMatKhau extends javax.swing.JFrame {

    Connection con = getConn("QLKHO");
    JOptionPane pane;

    //SQL CONNETCT
    public static Connection getConn(String csdlName) {
        Connection conn = null;
        String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:sqlserver://localhost:1433; databaseName= " + csdlName;
            conn = DriverManager.getConnection(dbUrl,"sa","12345");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(formThongTin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(formThongTin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public formMatKhau() {
        initComponents();
        if (con == null) {
            System.out.println("Failed");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbEmail = new javax.swing.JTextField();
        lbMKcu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbMKmoi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbXacNhan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(300, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Email");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));
        getContentPane().add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, -1));
        getContentPane().add(lbMKcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 150, -1));

        jLabel2.setText("MK cũ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));
        getContentPane().add(lbMKmoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 150, -1));

        jLabel3.setText("MK mới");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));
        getContentPane().add(lbXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 150, -1));

        jLabel4.setText("Xác nhận");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         // TODO add your handling code here:
        String sql = "UPDATE Nhanvien SET Password = ? WHERE Email = ?";
        String sqlSelect = "SELECT * FROM nhanvien WHERE Email = '" + lbEmail.getText() + "'";
        if (!lbMKmoi.getText().equals(lbXacNhan.getText())) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới phải trùng với xác nhận mật khẩu.");
            return;
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);
            rs.next();
            if (rs.getString("Password").equals(lbMKcu.getText())) {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, lbMKmoi.getText());
                ps.setString(2, lbEmail.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Success");
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Sai mật khẩu" + rs.getString("Password"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy Email");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    void clear() {
        lbEmail.setText("");
        lbMKcu.setText("");
        lbMKmoi.setText("");
        lbXacNhan.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField lbEmail;
    private javax.swing.JTextField lbMKcu;
    private javax.swing.JTextField lbMKmoi;
    private javax.swing.JTextField lbXacNhan;
    // End of variables declaration//GEN-END:variables
}