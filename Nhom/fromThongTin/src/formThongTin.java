
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class formThongTin extends javax.swing.JFrame {

    Connection con = getConn("QLKHO");
    JOptionPane pane;
    
    public formThongTin() {
        initComponents();
        if (con == null) {
            System.out.println("Failed");
        }
    }

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

    //END SQL
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        lbName = new javax.swing.JTextField();
        lbDOB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbAddress = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        lbID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(300, 380));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        getContentPane().add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        getContentPane().add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel2.setText("Gender");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 20));

        lbName.setEnabled(false);
        getContentPane().add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 110, -1));

        lbDOB.setEnabled(false);
        getContentPane().add(lbDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 110, -1));

        jLabel3.setText("DoB");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 20));

        lbPhone.setEnabled(false);
        getContentPane().add(lbPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 110, -1));

        jLabel4.setText("Phone");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 20));

        lbEmail.setEnabled(false);
        getContentPane().add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 110, -1));

        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        jLabel6.setText("Address");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

        jLabel7.setText("Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 20));

        lbAddress.setEnabled(false);
        jScrollPane1.setViewportView(lbAddress);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 180, 60));

        jLabel8.setText("ID");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 20));
        getContentPane().add(lbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 110, -1));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Customize code
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         // TODO add your handling code here:
        String sql = "SELECT * FROM Nhanvien WHERE manv = '" + lbID.getText() + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            lbName.setText(rs.getString("TenNV"));
            lbDOB.setText(rs.getString("NgaySinh"));
            lbPhone.setText(rs.getString("SDT"));
            lbEmail.setText(rs.getString("Email"));
            lbAddress.setText(rs.getString("DiaChi"));
            if (rs.getString("GioiTinh").equals("Nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            lbID.setEnabled(false);
            lbName.setEnabled(true);
            lbDOB.setEnabled(true);
            lbPhone.setEnabled(true);
            lbEmail.setEnabled(true);
            lbAddress.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên có mã: "+ lbID.getText());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  String sql = "UPDATE Nhanvien SET TenNV = ?, NgaySinh = ?, SDT = ?, Email = ?, DiaChi = ?, GioiTinh = ? WHERE manv = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lbName.getText());
            ps.setString(2, lbDOB.getText());
            ps.setString(3, lbPhone.getText());
            ps.setString(4, lbEmail.getText());
            ps.setString(5, lbAddress.getText());
            String gender = rdoNam.isSelected() ? "Nam" : "Nữ";
            ps.setString(6, gender);
            ps.setString(7, lbID.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Success");
            clear();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }


        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    void clear() {
        lbID.setText("");
        lbID.setEnabled(true);
        lbName.setText("");
        lbDOB.setText("");
        lbPhone.setText("");
        lbEmail.setText("");
        lbAddress.setText("");
        rdoNam.setSelected(false);
        rdoNu.setSelected(false);
        lbName.setEnabled(false);
        lbDOB.setEnabled(false);
        lbPhone.setEnabled(false);
        lbEmail.setEnabled(false);
        lbAddress.setEnabled(false);
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
            java.util.logging.Logger.getLogger(formThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formThongTin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane lbAddress;
    private javax.swing.JTextField lbDOB;
    private javax.swing.JTextField lbEmail;
    private javax.swing.JTextField lbID;
    private javax.swing.JTextField lbName;
    private javax.swing.JTextField lbPhone;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    // End of variables declaration//GEN-END:variables
}
