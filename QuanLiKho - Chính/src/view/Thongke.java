/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.KetNoiCSDL;
import DAO.SanPhamDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DanhMuc;
import model.ItemChart;
import model.SanPham;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author NGUYỄN THỊ THOA
 */
public class Thongke extends javax.swing.JFrame {

    /**
     * Creates new form Thongke casi nafy chiuj aw code cuar mi toiws tdoan mo
     * ro chuaw lamf sao them. tu tu da de lam bai nhomtr c da
     */
    public Thongke() throws SQLException {

        initComponents();
        CapNhatBangSP();

        try {
            List<DanhMuc> danhMucs = DAO.DanhMucDAO.getSanPhamAll();
            for (DanhMuc dm : danhMucs) {
                ComboBoxDanhMuc.addItem(dm.getMaDanhMucString() + " " + dm.getTendanhMucString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        createTable();           // tao bieu do cot

    }
    DefaultTableModel defaultTableModel;    //Anh 
    DefaultTableModel tbn = new DefaultTableModel();

    void createTable() throws SQLException {//bi thieeus 1 daasu ngoawjc choox nafo ddos aw

        defaultTableModel = new DefaultTableModel();
        jTable5.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã sản phẩm");
         defaultTableModel.addColumn("Tên sản phẩm");
        defaultTableModel.addColumn("Số lượng bán");
        String sql_query = "select top 3 temp.MaSach,SanPham.TenSach, tong from\n" +
"(select MaSach, sum(SoLuong) as tong from  ChiTietHoaDon\n" +
"group by maSach)as temp,SanPham\n" +
"where temp.MaSach = SanPham.MaSach\n" +
"order by tong desc ";

        Connection con = KetNoiCSDL.getConnection();    // baif nhom day maf chayj k dc
        PreparedStatement ps = con.prepareStatement(sql_query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            defaultTableModel.addRow(new Object[]{
                rs.getString(1), rs.getString(2),rs.getString(3)
            });
        }
    } //Anh
// cái nào bài mi đánh dấu đi đánh dấu abwngf cmt nha đanh dâu ten mình hả hay saoukm ukm đánh dấu tên mình ă

// là sao hê ý là hồi nãy mình có them dấu ngoặc chỗ ni rồi à  dmuưf  1c doaấu ngoặc dưới kia

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        labelBieuDoThongBao = new javax.swing.JLabel();
        chartPanel = new javax.swing.JPanel();
        comboBoxChonThang = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        TextFieldTenSach = new javax.swing.JTextField();
        DateChooserNamSX = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        ComboBoxDanhMuc = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        TextFieldTacGia = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        TextFieldNhaXuatBan = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        ButtonXoa = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Show Chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Biểu đồ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addContainerGap(742, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 883, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Thống Kê Lãi", jPanel10);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(new java.awt.BorderLayout());

        labelBieuDoThongBao.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelBieuDoThongBao.setForeground(new java.awt.Color(204, 0, 0));
        labelBieuDoThongBao.setText("BIỂU ĐỒ TĂNG GIẢM NHẬP TRONG 5 THÁNG GẦN NHẤT");

        chartPanel.setLayout(new java.awt.BorderLayout());

        comboBoxChonThang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxChonThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5 Tháng", "10 Tháng" }));
        comboBoxChonThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxChonThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBieuDoThongBao)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(comboBoxChonThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(comboBoxChonThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelBieuDoThongBao)
                        .addGap(18, 18, 18)))
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Biểu Đồ Tăng Trưởng", jPanel11);

        jTable5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã SP", "Số lượng bán đc"
            }
        ));
        jScrollPane6.setViewportView(jTable5);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Top 3 sản phẩm bán chạy");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Sản Phẩm Bán Chạy", jPanel12);

        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        tableSanPham.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Năm Sản Xuất", "Nhà Sản Xuất", "Tác Giả"
            }
        ));
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableSanPham);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setText("Tên Sách");

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Add.png"))); // NOI18N
        jButton8.setText("Thêm");
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        TextFieldTenSach.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        DateChooserNamSX.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Năm sản xuất");

        ComboBoxDanhMuc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("Danh mục");

        TextFieldTacGia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setText("Tác Giả");

        TextFieldNhaXuatBan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel26.setText("Nhà XB");

        ButtonXoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ButtonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Exit mini.png"))); // NOI18N
        ButtonXoa.setText("Xóa");
        ButtonXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonXoaActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Change.png"))); // NOI18N
        jButton9.setText("Sửa");
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(ComboBoxDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(DateChooserNamSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(TextFieldNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(TextFieldTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(ComboBoxDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(DateChooserNamSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(TextFieldTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(TextFieldNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(ButtonXoa)
                    .addComponent(jButton9))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản Phẩn Hiện Có", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMouseClicked
        // TODO add your handling code here:
        TextFieldTenSach.setText(tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 1).toString());
        for (int i = 0; i < ComboBoxDanhMuc.getItemCount(); i++) {
            if (tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 2).toString().equals(ComboBoxDanhMuc.getItemAt(i).toString().substring(0, ComboBoxDanhMuc.getItemAt(i).toString().indexOf(' ')))) {
                ComboBoxDanhMuc.setSelectedIndex(i);
            }
        }

        TextFieldTacGia.setText(tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 3).toString());
        TextFieldNhaXuatBan.setText(tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 4).toString());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            DateChooserNamSX.setDate(formatter.parse(tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 5).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(Home





.class  


.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tableSanPhamMouseClicked

    
        void CapNhatBangSP() throws SQLException {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        tableSanPham.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã Sách");
        defaultTableModel.addColumn("Tên Sách");
        defaultTableModel.addColumn("Mã Danh Mục");
        defaultTableModel.addColumn("Tác Giả");
        defaultTableModel.addColumn("Nhà Sản Xuất");
        defaultTableModel.addColumn("Ngày Sản Xuất");

        List<SanPham> sanPhams = SanPhamDAO.getSanPhamAll();
        for (SanPham sp : sanPhams) {

            defaultTableModel.addRow(new Object[]{
                sp.getMaSachString(), sp.getTenSachString(), sp.getMaDanhMucString(), sp.getTacGiaString(), sp.getNhaXuatBanString(), sp.getNgaySanXuatString()

            });

        }
        
        // tao bieu do cot ban dau
             createChart(DAO.Service.Chart("5"));

//
//        while (rs.next()) {
    }
    
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         // TODO add your handling code here:
        if (DateChooserNamSX.getDate() != null && !TextFieldTacGia.getText().equals("") && !TextFieldTenSach.getText().equals("")) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = formatter.format(DateChooserNamSX.getDate());
            if (!DAO.SanPhamDAO.insertData(new SanPham(null, TextFieldTenSach.getText(), ComboBoxDanhMuc.getSelectedItem().toString().substring(0, ComboBoxDanhMuc.getSelectedItem().toString().indexOf(' ')), TextFieldTacGia.getText(), TextFieldNhaXuatBan.getText(), strDate))) {
                JOptionPane.showMessageDialog(null, "Thêm Thành Công");
                try {
                    CapNhatBangSP();
                } catch (SQLException ex) {
                    Logger.getLogger(Thongke





.class  


.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi Đầu Vào");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lỗi Đầu Vào");
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void ButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonXoaActionPerformed
        try {
            // TODO add your handling code here:
            if (!DAO.SanPhamDAO.deleteData(new SanPham(tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 0).toString(), null, null, null, null, null))) {
                JOptionPane.showMessageDialog(null, "Xóa Thành Công");
                CapNhatBangSP();
                CapNhatBangSP();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home





.class  


.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonXoaActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(DateChooserNamSX.getDate());
        try {
            if (!DAO.SanPhamDAO.upData(new SanPham(tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 0).toString(), TextFieldTenSach.getText(), ComboBoxDanhMuc.getSelectedItem().toString().substring(0, ComboBoxDanhMuc.getSelectedItem().toString().indexOf(' ')), TextFieldTacGia.getText(), TextFieldNhaXuatBan.getText(), strDate))) {
                JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");
                CapNhatBangSP();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home





.class  


.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseClicked

    private void comboBoxChonThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxChonThangActionPerformed
        // TODO add your handling code here:
        if (comboBoxChonThang.getSelectedIndex() == 0) {

            labelBieuDoThongBao.setText("BIỂU ĐỒ TĂNG GIẢM NHẬP TRONG 5 THÁNG GẦN NHẤT");
            try {
                createChart(DAO.Service.Chart("5"));

            } catch (SQLException ex) {
                Logger.getLogger(Home





.class  


.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            labelBieuDoThongBao.setText("BIỂU ĐỒ TĂNG GIẢM NHẬP TRONG 10 THÁNG GẦN NHẤT");
            try {
                createChart(DAO.Service.Chart("10"));

            } catch (SQLException ex) {
                Logger.getLogger(Home





.class  


.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_comboBoxChonThangActionPerformed
//Anh
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        barChartData.setValue(15000, "Mark", "Tháng 1");
        barChartData.setValue(20000, "Mark", "Tháng 2");
        barChartData.setValue(17000, "Mark", "Tháng 3");
        barChartData.setValue(18000, "Mark", "Tháng 4");
        barChartData.setValue(14000, "Mark", "Tháng 5");
        barChartData.setValue(10000, "Mark", "Tháng 6");
        barChartData.setValue(25000, "Mark", "Tháng 7");
        barChartData.setValue(28000, "Mark", "Tháng 8");
        barChartData.setValue(16000, "Mark", "Tháng 9");
        barChartData.setValue(11000, "Mark", "Tháng 10");
        barChartData.setValue(13000, "Mark", "Tháng 11");
        barChartData.setValue(19000, "Mark", "Tháng 12");

        JFreeChart jchar = ChartFactory.createBarChart("Biểu đồ", "Tháng", "Lãi", barChartData, PlotOrientation.VERTICAL, true, false,true);
        CategoryPlot plot = jchar.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);

        ChartPanel barPanel = new ChartPanel(jchar);
        jPanel2.removeAll();
        jPanel2.add(barPanel, BorderLayout.CENTER);
        jPanel2.validate();                           //Anh
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Thongke





.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Thongke





.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Thongke





.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Thongke





.class  


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Thongke().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Thongke


// tải lên githup hỉ / chết rồi cái ni mi thay đổi nhiều quá// mà trước khi sửa bài ni mi có pull chưa thì tui để chạy thử lại từ từ

.class  


.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
   @SuppressWarnings("unchecked")
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonXoa;
    private javax.swing.JComboBox<String> ComboBoxDanhMuc;
    private com.toedter.calendar.JDateChooser DateChooserNamSX;
    private javax.swing.JTextField TextFieldNhaXuatBan;
    private javax.swing.JTextField TextFieldTacGia;
    private javax.swing.JTextField TextFieldTenSach;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JComboBox<String> comboBoxChonThang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable5;
    private javax.swing.JLabel labelBieuDoThongBao;
    private javax.swing.JTable tableSanPham;
    // End of variables declaration//GEN-END:variables

     void createChart(List<ItemChart> itemCharts) throws SQLException {

        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        for (ItemChart ic : itemCharts) {
            barChartData.setValue(ic.getValue(), "cai chi chi 1", ic.getName());
        }

//       
        JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ", "month", "Tổng số lượng nhập", barChartData, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel barPanel = new ChartPanel(barChart);
        chartPanel.removeAll();
        chartPanel.add(barPanel, BorderLayout.CENTER);
        chartPanel.validate();
    }
}
