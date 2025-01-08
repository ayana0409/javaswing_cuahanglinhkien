/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.views;

import com.mycompany.cuahanglinhkien_java.controllers.OrderController;
import com.mycompany.cuahanglinhkien_java.controllers.OrderDetailController;
import com.mycompany.cuahanglinhkien_java.controllers.PaymentController;
import com.mycompany.cuahanglinhkien_java.controllers.ProductController;
import com.mycompany.cuahanglinhkien_java.models.Order;
import com.mycompany.cuahanglinhkien_java.models.OrderDetail;
import com.mycompany.cuahanglinhkien_java.models.Product;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import share.OutOfStockException;

/**
 *
 * @author Asus
 */
public class frmOrderDetails extends javax.swing.JFrame {

    private final OrderDetailController _orderDetailController;
    private final ProductController _productController;
    private final OrderController _orderController;
    private final PaymentController _paymentController;
    private final Object[] header = {"ID", "Tên sản phẩm", "Số lượng", "Giá bán"};
    private final DefaultTableModel detailModel;
    private int selectedDetail;
    private Order order = null;
    int orderId;
    frmOrder parent;

    public frmOrderDetails(int orderId, frmOrder parent) {
        this.orderId = orderId;
        this.parent = parent;
        _paymentController = new PaymentController();
        _orderDetailController = new OrderDetailController();
        _productController = new ProductController();
        _orderController = new OrderController();
        initComponents();
        tbOrderDetails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        detailModel = new DefaultTableModel(header, 0);
        tbOrderDetails.setModel(detailModel);
        addEvent();
        loadData();
    }

    private void addEvent() {
        spQuantity.addChangeListener((e) -> {
            if (selectedDetail != 0) {
                int quantity = (int) spQuantity.getValue();
                int productId = selectedDetail;
                int existValue = Integer.parseInt(tbOrderDetails.getValueAt(tbOrderDetails.getSelectedRow(), 2).toString());
                float existPrice = Float.parseFloat(tbOrderDetails.getValueAt(tbOrderDetails.getSelectedRow(), 3).toString());
                if (existValue != quantity) {
                    var newDetail = new OrderDetail(productId, order.getId(), quantity, existPrice);
                    _orderDetailController.upsertOrDeleteOrderDetail(newDetail);
                    loadData();
                    loadTable();
                    checkSelectedRow();
                }
            }
        });

        tbOrderDetails.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tbOrderDetails.getSelectedRow();
                if (selectedRow >= 0) {
                    selectedDetail = Integer.parseInt(tbOrderDetails.getValueAt(selectedRow, 0).toString());
                    spQuantity.setValue(Integer.parseInt(tbOrderDetails.getValueAt(selectedRow, 2).toString()));
                    checkSelectedRow();
                }
            }
        });
    }

    public void loadData() {
        order = _orderController.getOrder(orderId);
        txtOrderId.setText(order.getId() + "");
        txtPhone.setText(order.getPhoneNumber());
        txtStatus.setText(order.getStatus());
        txtTotalPrice.setText(order.getTotalAmount() + "");

        loadTable();
    }

    private void loadTable() {
        List<OrderDetail> orderDetails = _orderDetailController.getByOrderId(order.getId());
        List<Product> products = _productController.getAllProduct();
        detailModel.setRowCount(0);
        for (OrderDetail detail : orderDetails) {
            Product product = products.stream()
                    .filter(p -> p.getId() == detail.getProductId())
                    .findFirst()
                    .orElse(null);
            detailModel.addRow(new Object[]{
                detail.getProductId(),
                product != null ? product.getName() : "Unknown",
                detail.getQuantitySold(),
                detail.getSalePrice()
            });
        }
        detailModel.fireTableDataChanged();
    }

    private void checkSelectedRow() {
        boolean found = false;
        for (int i = 0; i < tbOrderDetails.getRowCount(); i++) {
            int value = Integer.parseInt(tbOrderDetails.getValueAt(i, 0).toString());
            if (value == selectedDetail) {
                tbOrderDetails.setRowSelectionInterval(i, i);
                found = true;
                break;
            }
        }
        if (!found) {
            tbOrderDetails.clearSelection();
            selectedDetail = -1;
        }

        spQuantity.setEnabled(selectedDetail > 0);
        btnDelete.setEnabled(selectedDetail > 0);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOrderDetails = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtOrderId = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        lbQuantity = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        btnAddProduct = new javax.swing.JButton();
        spQuantity = new javax.swing.JSpinner();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        btnPayment = new javax.swing.JButton();
        btnCancelOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 126, 242));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHI TIẾT ĐƠN HÀNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        tbOrderDetails.setBackground(new java.awt.Color(204, 255, 255));
        tbOrderDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbOrderDetails);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(8, 0, 0, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã đơn hàng");
        jPanel6.add(jLabel3);

        txtOrderId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtOrderId.setAutoscrolls(false);
        txtOrderId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtOrderId.setEnabled(false);
        jPanel6.add(txtOrderId);

        jPanel4.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số điện thoại");
        jPanel7.add(jLabel4);

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhone.setAutoscrolls(false);
        txtPhone.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPhone.setEnabled(false);
        jPanel7.add(txtPhone);

        jPanel4.add(jPanel7);

        jPanel8.setLayout(new java.awt.GridLayout(2, 0));

        lbQuantity.setText("Số lượng");
        jPanel8.add(lbQuantity);

        jPanel13.setLayout(new java.awt.BorderLayout(5, 0));

        btnDelete.setBackground(new java.awt.Color(209, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel13.add(btnDelete, java.awt.BorderLayout.LINE_END);

        jPanel14.setLayout(new java.awt.BorderLayout(5, 0));

        btnAddProduct.setText("Thêm");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        jPanel14.add(btnAddProduct, java.awt.BorderLayout.LINE_END);

        spQuantity.setEnabled(false);
        jPanel14.add(spQuantity, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel13);

        jPanel4.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(204, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Trạng thái");
        jPanel10.add(jLabel5);

        txtStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStatus.setAutoscrolls(false);
        txtStatus.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        txtStatus.setEnabled(false);
        jPanel10.add(txtStatus);

        jPanel4.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(204, 255, 255));
        jPanel11.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tổng tiền");
        jPanel11.add(jLabel6);

        txtTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalPrice.setText("0");
        txtTotalPrice.setAutoscrolls(false);
        txtTotalPrice.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        txtTotalPrice.setEnabled(false);
        jPanel11.add(txtTotalPrice);

        jPanel4.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(204, 255, 255));
        jPanel12.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        btnPayment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPayment.setText("Thanh toán");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });
        jPanel12.add(btnPayment);

        btnCancelOrder.setBackground(new java.awt.Color(209, 0, 0));
        btnCancelOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelOrder.setText("Hủy");
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });
        jPanel12.add(btnCancelOrder);

        jPanel4.add(jPanel12);

        jPanel1.add(jPanel4, java.awt.BorderLayout.EAST);

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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedDetail != 0) {
            int productId = selectedDetail;
            var newDetail = new OrderDetail(productId, order.getId(), 0, 0);
            _orderDetailController.upsertOrDeleteOrderDetail(newDetail);
            loadData();
            loadTable();
            checkSelectedRow();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        frmAddProduct frmAddProduct = new frmAddProduct(orderId, this);
        frmAddProduct.setLocationRelativeTo(null);
        frmAddProduct.setVisible(true);
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderActionPerformed
        int confirm = javax.swing.JOptionPane
                .showConfirmDialog(this, "Đơn hàng sẽ bị hủy?", "Xác nhận hủy", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            _orderController.cancelOrder(orderId);
            parent.loadData();
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelOrderActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        int confirm = javax.swing.JOptionPane
                .showConfirmDialog(this, "Hoàn thành đơn hàng?", "Xác nhận", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                _paymentController.payOrder(orderId);
                parent.loadData();
                this.dispose();
            } catch (OutOfStockException ex) {
                javax.swing.JOptionPane.showMessageDialog(
                        this, 
                        "Không đủ hàng trong kho!", 
                        "Cảnh báo", 
                        javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.loadData();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(frmOrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmOrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmOrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmOrderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new frmOrderDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbQuantity;
    private javax.swing.JSpinner spQuantity;
    private javax.swing.JTable tbOrderDetails;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables
}
