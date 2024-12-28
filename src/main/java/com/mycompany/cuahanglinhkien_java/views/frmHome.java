/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.views;

import java.awt.MediaTracker;
import java.io.Console;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class frmHome extends javax.swing.JFrame {

    /**
     * Creates new form frmHome
     */
    public frmHome() {
        initComponents();
        //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        String path = System.getProperty("user.dir");
        String baseImagePath = path + "\\src\\main\\java\\share\\utils\\images\\";

        setLabelIcon(lbOrder, baseImagePath + "order.png");
        setLabelIcon(lbCustomer, baseImagePath + "customer.png");
        setLabelIcon(lbCategory, baseImagePath + "category.png");
        setLabelIcon(lbManufacturer, baseImagePath + "manufacturer.png");
        setLabelIcon(lbProduct, baseImagePath + "product.jpg");
        setLabelIcon(lbEmployee, baseImagePath + "employee.png");
        setLabelIcon(lbStatistic, baseImagePath + "statistic.png");
        
    }
    
    public static void setLabelIcon(JLabel label, String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            label.setIcon(icon);
        } else {
            label.setText("Image Not Found");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnManageOrder = new javax.swing.JButton();
        lbOrder = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnManageCustomer = new javax.swing.JButton();
        lbCustomer = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnManageCategory = new javax.swing.JButton();
        lbCategory = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbManufacturer = new javax.swing.JLabel();
        btnManageManufacturer = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lbProduct = new javax.swing.JLabel();
        btnProduct = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        lbEmployee = new javax.swing.JLabel();
        btnManageEmployee = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        lbStatistic = new javax.swing.JLabel();
        btnStatistic = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnChangeAccount = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 126, 242));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CỬA HÀNG BÁN LINH KIỆN MÁY TÍNH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel13.setBackground(new java.awt.Color(204, 255, 255));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(2, 4, 50, 50));

        jPanel4.setLayout(new java.awt.BorderLayout());

        btnManageOrder.setBackground(new java.awt.Color(52, 45, 126));
        btnManageOrder.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnManageOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnManageOrder.setText("Đơn hàng");
        btnManageOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrderActionPerformed(evt);
            }
        });
        jPanel4.add(btnManageOrder, java.awt.BorderLayout.PAGE_END);

        lbOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(lbOrder, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        btnManageCustomer.setBackground(new java.awt.Color(52, 45, 126));
        btnManageCustomer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnManageCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnManageCustomer.setText("Khách hàng");
        btnManageCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomerActionPerformed(evt);
            }
        });
        jPanel5.add(btnManageCustomer, java.awt.BorderLayout.PAGE_END);

        lbCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCustomer.setIconTextGap(0);
        jPanel5.add(lbCustomer, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        btnManageCategory.setBackground(new java.awt.Color(52, 45, 126));
        btnManageCategory.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnManageCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnManageCategory.setText("Danh mục");
        btnManageCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCategoryActionPerformed(evt);
            }
        });
        jPanel6.add(btnManageCategory, java.awt.BorderLayout.PAGE_END);

        lbCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCategory.setIconTextGap(0);
        jPanel6.add(lbCategory, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout());

        lbManufacturer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbManufacturer.setIconTextGap(0);
        jPanel7.add(lbManufacturer, java.awt.BorderLayout.CENTER);

        btnManageManufacturer.setBackground(new java.awt.Color(52, 45, 126));
        btnManageManufacturer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnManageManufacturer.setForeground(new java.awt.Color(255, 255, 255));
        btnManageManufacturer.setText("Thương hiệu");
        btnManageManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageManufacturerActionPerformed(evt);
            }
        });
        jPanel7.add(btnManageManufacturer, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        lbProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel8.add(lbProduct, java.awt.BorderLayout.CENTER);

        btnProduct.setBackground(new java.awt.Color(52, 45, 126));
        btnProduct.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnProduct.setText("Sản phẩm");
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });
        jPanel8.add(btnProduct, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel8);

        jPanel9.setLayout(new java.awt.BorderLayout());

        lbEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel9.add(lbEmployee, java.awt.BorderLayout.CENTER);

        btnManageEmployee.setBackground(new java.awt.Color(52, 45, 126));
        btnManageEmployee.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnManageEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnManageEmployee.setText("Nhân viên");
        btnManageEmployee.setToolTipText("");
        jPanel9.add(btnManageEmployee, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel9);

        jPanel10.setLayout(new java.awt.BorderLayout());

        lbStatistic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(lbStatistic, java.awt.BorderLayout.CENTER);

        btnStatistic.setBackground(new java.awt.Color(52, 45, 126));
        btnStatistic.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnStatistic.setForeground(new java.awt.Color(255, 255, 255));
        btnStatistic.setText("Thống kê");
        jPanel10.add(btnStatistic, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel10);

        jPanel11.setLayout(new java.awt.GridLayout(3, 0, 20, 20));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel12);

        btnChangeAccount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnChangeAccount.setText("Đổi tài khoản");
        btnChangeAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeAccountActionPerformed(evt);
            }
        });
        jPanel11.add(btnChangeAccount);

        btnExit.setBackground(new java.awt.Color(209, 0, 0));
        btnExit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Đóng chương trình");
        jPanel11.add(btnExit);

        jPanel3.add(jPanel11);

        jPanel13.add(jPanel3, java.awt.BorderLayout.CENTER);

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("     ");
        jLabel1.setToolTipText("     ");
        jPanel13.add(jLabel1, java.awt.BorderLayout.SOUTH);

        jLabel4.setText("     ");
        jPanel13.add(jLabel4, java.awt.BorderLayout.LINE_END);

        jLabel5.setBackground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("     ");
        jPanel13.add(jLabel5, java.awt.BorderLayout.WEST);

        jPanel1.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrderActionPerformed
        frmOrderDetails frmOrderDetails = new frmOrderDetails();
        frmOrderDetails.setLocationRelativeTo(null);
        frmOrderDetails.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnManageOrderActionPerformed

    private void btnManageCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManageCustomerActionPerformed

    private void btnChangeAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeAccountActionPerformed
        frmLogin frmLogin = new frmLogin();
        frmLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnChangeAccountActionPerformed

    private void btnManageManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageManufacturerActionPerformed
        frmManufacturer frmManufacturer = new frmManufacturer();
        frmManufacturer.setLocationRelativeTo(null);
        frmManufacturer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnManageManufacturerActionPerformed

    private void btnManageCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCategoryActionPerformed
        frmCategory frmCategory = new frmCategory();
        frmCategory.setLocationRelativeTo(null);
        frmCategory.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnManageCategoryActionPerformed

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        frmProduct frmProduct = new frmProduct();
        frmProduct.setLocationRelativeTo(null);
        frmProduct.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductActionPerformed

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
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeAccount;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnManageCategory;
    private javax.swing.JButton btnManageCustomer;
    private javax.swing.JButton btnManageEmployee;
    private javax.swing.JButton btnManageManufacturer;
    private javax.swing.JButton btnManageOrder;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btnStatistic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbCategory;
    private javax.swing.JLabel lbCustomer;
    private javax.swing.JLabel lbEmployee;
    private javax.swing.JLabel lbManufacturer;
    private javax.swing.JLabel lbOrder;
    private javax.swing.JLabel lbProduct;
    private javax.swing.JLabel lbStatistic;
    // End of variables declaration//GEN-END:variables
}
