/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.views;

import com.mycompany.cuahanglinhkien_java.controllers.OrderController;
import com.mycompany.cuahanglinhkien_java.controllers.OrderDetailController;
import com.mycompany.cuahanglinhkien_java.controllers.ProductController;
import com.mycompany.cuahanglinhkien_java.models.OrderDetail;
import com.mycompany.cuahanglinhkien_java.models.Product;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class frmAddProduct extends javax.swing.JFrame {

    private int orderId, selectedProduct = -1;
    frmOrderDetails parentForm;
    private final ProductController _productController = new ProductController();
    private final OrderDetailController _orderDetailController = new OrderDetailController();
    private Object[] header = {"Id", "Ảnh", "Tên sản phẩm", "Danh mục", "Hãng SX", "Giá"};
    private DefaultTableModel productTbModel = new DefaultTableModel(header, 0) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 1) {
                return ImageIcon.class;
            }
            return super.getColumnClass(columnIndex);
        }
    };
    
    public frmAddProduct(int id, frmOrderDetails parentForm) {
        orderId = id;
        this.parentForm = parentForm;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        tbProduct.setModel(productTbModel);
        tbProduct.setRowHeight(100);
        loadTable();
        addEvent();
    }

    private void loadTable() {
        List<Product> products = _productController.getAllProduct();
        String path = System.getProperty("user.dir");
        String baseImagePath = path + "\\src\\main\\java\\share\\utils\\images\\order.png";
        for(Product p : products){
            ImageIcon imageIcon = null;
            if (p.getImage() != null && !p.getImage().isEmpty()) {
                String imagePath = baseImagePath + p.getImage();
                File imageFile = new File(imagePath);

                if (imageFile.exists()) {
                    ImageIcon originalIcon = new ImageIcon(imagePath);
                    Image scaledImage = originalIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(scaledImage);
                    imageIcon.setDescription(imagePath);
                }
            }
            productTbModel.addRow(new Object[] {p.getId(), imageIcon, p.getName(), 
                    p.getCategoryId(), p.getManufacturerId(), p.getPrice()});
        }
        productTbModel.fireTableDataChanged();
    }
    
    private void addEvent() {
        tbProduct.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tbProduct.getSelectedRow();
                if (selectedRow >= 0) {
                    selectedProduct = Integer.parseInt(tbProduct.getValueAt(selectedRow, 0).toString());
                    //spQuantity.setValue(Integer.parseInt(tbOrderDetails.getValueAt(selectedRow, 2).toString()));
                    txtId.setText(tbProduct.getValueAt(selectedRow, 0).toString());
                    txtName.setText(tbProduct.getValueAt(selectedRow, 2).toString());
                    txtPrice.setText(tbProduct.getValueAt(selectedRow, 5).toString());
                   checkSelectedRow();
                }
            }
        });
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                parentForm.loadData();
            }
        });
        
        spQuantity.addChangeListener((e) -> {
            int quantity = (int) spQuantity.getValue();
            if (quantity <= 0)
                spQuantity.setValue(1);
        });
    }
    
    private void checkSelectedRow() {
        boolean found = false;
        for (int i = 0; i < tbProduct.getRowCount(); i++) {
            int value = Integer.parseInt(tbProduct.getValueAt(i, 0).toString());
            if (value == selectedProduct) {
                tbProduct.setRowSelectionInterval(i, i);
                found = true;
                break;
            }
        }
        if (!found) {
            tbProduct.clearSelection();
            selectedProduct = -1;
        }

        spQuantity.setEnabled(selectedProduct > 0);
        btnAdd.setEnabled(selectedProduct > 0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        spQuantity = new javax.swing.JSpinner();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 126, 242));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM SẢN PHẨM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(6, 1, 0, 10));

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("THÔNG TIN");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.getAccessibleContext().setAccessibleName("lbInfo");

        jPanel4.add(jPanel7);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(2, 0, 0, 3));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã sản phẩm");
        jPanel6.add(jLabel2);

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtId.setEnabled(false);
        txtId.setFocusable(false);
        jPanel6.add(txtId);

        jPanel4.add(jPanel6);

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));
        jPanel8.setLayout(new java.awt.GridLayout(2, 0, 0, 3));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên sản phẩm");
        jPanel8.add(jLabel4);

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtName.setEnabled(false);
        jPanel8.add(txtName);

        jPanel4.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(2, 0, 0, 3));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số lượng bán");
        jPanel9.add(jLabel5);

        spQuantity.setEnabled(false);
        spQuantity.setValue(1);
        jPanel9.add(spQuantity);

        jPanel4.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(204, 255, 255));
        jPanel10.setLayout(new java.awt.GridLayout(2, 0, 0, 3));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giá bán");
        jPanel10.add(jLabel6);

        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel10.add(txtPrice);

        jPanel4.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(204, 255, 255));
        jPanel11.setLayout(new java.awt.GridLayout(1, 2, 10, 3));

        btnAdd.setText("Thêm");
        btnAdd.setBorderPainted(false);
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel11.add(btnAdd);

        btnCancel.setText("Hủy");
        jPanel11.add(btnCancel);

        jPanel4.add(jPanel11);

        jPanel3.add(jPanel4, java.awt.BorderLayout.LINE_END);

        tbProduct.setBackground(new java.awt.Color(204, 255, 255));
        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbProduct);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (selectedProduct < 0)
            return;
        
        _orderDetailController.upsertOrDeleteOrderDetail(
                new OrderDetail(selectedProduct, orderId, 
                        Integer.parseInt(spQuantity.getValue().toString()), 
                        Float.parseFloat(txtPrice.getText())));
        
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(frmAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new frmAddProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spQuantity;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
