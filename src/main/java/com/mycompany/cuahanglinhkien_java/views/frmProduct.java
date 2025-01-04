/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.views;

import com.mycompany.cuahanglinhkien_java.controllers.ProductController;
import com.mycompany.cuahanglinhkien_java.controllers.CategoryController;
import com.mycompany.cuahanglinhkien_java.controllers.ManufacturerController;
import com.mycompany.cuahanglinhkien_java.models.Category;
import com.mycompany.cuahanglinhkien_java.models.Manufacturer;
import com.mycompany.cuahanglinhkien_java.models.Product;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DLCT
 */
public class frmProduct extends javax.swing.JFrame {

    ProductController controller = new ProductController();
    CategoryController controllerCate = new CategoryController();
    ManufacturerController controllerManu = new ManufacturerController();
    String[] columnNames = {"Mã ", "Tên ", "Danh mục", "Hãng", "Số lượng", "Chi tiết", "Giá", "Hình"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    int selected = 0;
    DefaultComboBoxModel<Category> cbCategoryModel = new DefaultComboBoxModel<Category>();
    DefaultComboBoxModel<Manufacturer> cbManufacturerModel = new DefaultComboBoxModel<Manufacturer>();
    /**
     * Creates new form frmCategory
     */
    public frmProduct()  {
        initComponents();
        cbCategory.setModel(cbCategoryModel);
        cbManufacturer.setModel(cbManufacturerModel);
        loadData();
        loadManu();
        loadCate();
        clearInput();
        addEvent();
        tbProduct.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbManufacturer = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtDetail = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtImage = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnLoadImage = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 300));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {700, 260};
        jPanel2.setLayout(jPanel2Layout);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã ", "Tên ", "Danh Mục ", "Hãng SX", "Số lượng", "Chi tiết", "Giá", "Hình "
            }
        ));
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduct);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 48, 688, 560));

        jLabel11.setText("Nhập tên sản phẩm cần tìm");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 30));
        jPanel3.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 200, 30));

        jButton1.setText("Tìm kiếm");
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jPanel3, gridBagConstraints);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin");
        jPanel1.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridLayout(10, 0, 0, 10));

        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setText("Mã sản phẩm");
        jPanel5.add(jLabel3);

        txtID.setEnabled(false);
        jPanel5.add(txtID);

        jPanel4.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        jLabel4.setText("Tên sản phẩm");
        jPanel6.add(jLabel4);

        txtName.setText("jTextField1");
        jPanel6.add(txtName);

        jPanel4.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        jLabel5.setText("Danh mục");
        jPanel7.add(jLabel5);

        jPanel7.add(cbCategory);

        jPanel4.add(jPanel7);

        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.setLayout(new java.awt.GridLayout(2, 0));

        jLabel6.setText("Hãng SX");
        jPanel8.add(jLabel6);

        jPanel8.add(cbManufacturer);

        jPanel4.add(jPanel8);

        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jLabel7.setText("Số lượng");
        jPanel9.add(jLabel7);

        txtQuantity.setText("jTextField1");
        jPanel9.add(txtQuantity);

        jPanel4.add(jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        jLabel8.setText("Chi tiết");
        jPanel10.add(jLabel8);

        txtDetail.setText("jTextField1");
        jPanel10.add(txtDetail);

        jPanel4.add(jPanel10);

        jPanel12.setLayout(new java.awt.GridLayout(2, 0));

        jLabel9.setText("Giá");
        jPanel12.add(jLabel9);

        txtPrice.setText("jTextField1");
        jPanel12.add(txtPrice);

        jPanel4.add(jPanel12);

        jPanel13.setLayout(new java.awt.GridLayout(2, 0));

        jLabel10.setText("Hình");
        jPanel13.add(jLabel10);

        txtImage.setText("jTextField8");
        jPanel13.add(txtImage);

        jPanel4.add(jPanel13);

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        btnLoadImage.setText("Tải ảnh lên");
        btnLoadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(btnLoadImage)
                .addGap(122, 122, 122))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(0, 176, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 176, Short.MAX_VALUE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLoadImage)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel4.add(jPanel14);

        jPanel15.setLayout(new java.awt.GridLayout(0, 4));

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel15.add(btnAdd);

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel15.add(btnEdit);

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel15.add(btnDelete);

        btnImport.setText("Nhập hàng");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        jPanel15.add(btnImport);

        jPanel4.add(jPanel15);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jPanel1, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadImageActionPerformed
         // Hiển thị hộp thoại chọn tệp
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Hình ảnh", "jpg", "png", "jpeg"));

    int returnValue = fileChooser.showOpenDialog(this);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        // Lấy đường dẫn tệp được chọn
        String filePath = fileChooser.getSelectedFile().getAbsolutePath();
        
        // Hiển thị đường dẫn tệp trong JTextField
        txtImage.setText(filePath);
    }
    }//GEN-LAST:event_btnLoadImageActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            // Lấy dữ liệu từ các trường nhập liệu
            
            String name = txtName.getText().trim();
            Category selectedCate = (Category) cbCategory.getSelectedItem();
            Manufacturer selectedManu = (Manufacturer) cbManufacturer.getSelectedItem();
            int quantity = Integer.parseInt(txtQuantity.getText().trim());
            String details = txtDetail.getText().trim();
            String image = txtImage.getText().trim();
            double price = Double.parseDouble(txtPrice.getText().trim());

            // Kiểm tra các trường nhập liệu    
            if (name.isEmpty() || details.isEmpty() || image.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Không được để trống các trường bắt buộc!", "Thông báo", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            Product newPro = new Product();
            newPro.setName(name);
            newPro.setCategoryId(selectedCate.getId() );
            newPro.setManufacturerId(selectedManu.getId());
            newPro.setDetails(details);
            newPro.setQuantity(quantity);
            newPro.setPrice((float) price);
            

            // Gọi phương thức thêm sản phẩm từ controller
            boolean success = controller.addProduct(newPro);

            // Kiểm tra kết quả và thông báo
            if (success) {
                javax.swing.JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                loadData();
                clearInput();
                loadCate();
                loadManu();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại!", "Thông báo", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            // Lấy dòng được chọn trong bảng
            int selectedRow = tbProduct.getSelectedRow();
            if (selectedRow < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để sửa!", "Thông báo", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Lấy dữ liệu từ các trường nhập liệu
            int id = Integer.parseInt(tbProduct.getValueAt(selectedRow, 0).toString()); // ID từ bảng
            String name = txtName.getText().trim();
            Category selectedCategory = (Category) cbCategory.getSelectedItem();
            Manufacturer selectedManufacturer = (Manufacturer) cbManufacturer.getSelectedItem();
            int quantity = Integer.parseInt(txtQuantity.getText().trim());
            String details = txtDetail.getText().trim();
            String image = txtImage.getText().trim();
            double price = Double.parseDouble(txtPrice.getText().trim());

            // Kiểm tra trường nhập liệu
            if (name.isEmpty() || details.isEmpty() || image.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Không được để trống các trường bắt buộc!", "Thông báo", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Tạo đối tượng sản phẩm mới với dữ liệu đã chỉnh sửa
            Product updatedProduct = new Product(id, name, selectedCategory.getId(), selectedManufacturer.getId(), quantity, details, image, (float) price);
            updatedProduct.setPrice((float) price);

            //Gọi hàm updateProduct từ controller
            boolean success = controller.updateProduct(updatedProduct);

            if (success) {
                javax.swing.JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công!", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                loadData(); // Tải lại bảng
                clearInput(); // Reset các trường nhập liệu
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Sửa sản phẩm thất bại!", "Thông báo", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // Lấy dòng được chọn trong bảng
            int selectedRow = tbProduct.getSelectedRow();
            if (selectedRow < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa!", "Thông báo", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Xác nhận trước khi xóa
            int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này không?", "Xác nhận", javax.swing.JOptionPane.YES_NO_OPTION);
            if (confirm != javax.swing.JOptionPane.YES_OPTION) {
                return;
            }

            // Lấy ID của sản phẩm được chọn
            int id = Integer.parseInt(tbProduct.getValueAt(selectedRow, 0).toString());

            // Gọi hàm deleteProduct từ controller
            boolean success = controller.deleteProduct(id);

            if (success) {
                javax.swing.JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công!", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                loadData(); // Tải lại bảng
                clearInput(); // Reset các trường nhập liệu
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Xóa sản phẩm thất bại!", "Thông báo", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        try {
            int row = this.tbProduct.getSelectedRow();
            if (row >= 0) {
                String id = tbProduct.getValueAt(row, 0).toString();
                String name = tbProduct.getValueAt(row, 1).toString();
                String details = tbProduct.getValueAt(row, 5).toString();
                String quantity = tbProduct.getValueAt(row, 4).toString();
                String price = tbProduct.getValueAt(row, 6).toString();
                txtID.setText(id);
                txtName.setText(name);
                Category selectedCate = (Category) cbCategory.getSelectedItem();
                cbCategory.setSelectedItem(selectedCate);
                Manufacturer selectManu = (Manufacturer) cbManufacturer.getSelectedItem();
                cbManufacturer.setSelectedItem(selectManu);
                txtDetail.setText(details);
                txtQuantity.setText(quantity);
                txtPrice.setText(price);

            }
        } catch (Exception ex) {
            Logger.getLogger(frmCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbProductMouseClicked

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        if ( selected != -1 ){
            frmInventory frmInventory = new frmInventory(selected);
            frmInventory.setLocationRelativeTo(null);
            frmInventory.setVisible(true);
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void loadCate()  {

        List<Category> categories;  
        try {
            categories = controllerCate.getAllCategory();
            // Xóa tất cả mục hiện tại trong ComboBox trước khi thêm mới
        cbCategoryModel.removeAllElements();

        // Thêm danh mục vào ComboBox
        for (Category category : categories) {
            cbCategoryModel.addElement(category);
        }
        
        cbCategory.firePopupMenuCanceled();
        } catch (SQLException ex) {
            Logger.getLogger(frmProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    private void loadManu()  {
        List<Manufacturer> listManu;
        try {
            listManu = controllerManu.getAllManufacturer();
            // Xóa tất cả mục hiện tại trong ComboBox trước khi thêm mới
        cbManufacturerModel.removeAllElements();

        // Thêm danh mục vào ComboBox
        for (Manufacturer manufacturer : listManu) {
            cbManufacturerModel.addElement(manufacturer);
        }
        cbManufacturer.firePopupMenuCanceled();
        } catch (SQLException ex) {
            Logger.getLogger(frmProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    private void loadData()  {
        // Lấy danh sách danh mục từ cơ sở dữ liệu
        List<Product> listProduct = controller.getAllProduct();
        // Xóa dữ liệu cũ trong bảng
        model.setRowCount(0);
        // Sử dụng phương thức forEach để duyệt qua danh sách danh mục
        listProduct.forEach(Product -> {
            model.addRow(new Object[]{Product.getId(), Product.getName(),
                Product.getCategoryId(), Product.getManufacturerId(),
                Product.getQuantity(), Product.getDetails(),
                Product.getPrice(), Product.getImage(),});
        });
        
    }

    private void addEvent() {
        tbProduct.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tbProduct.getSelectedRow();
                if (selectedRow != -1) {
                    selected = Integer.parseInt( tbProduct.getValueAt(selectedRow, 0).toString());
                    txtID.setText(selected+"");
                    txtName.setText((String) tbProduct.getValueAt(selectedRow, 1));
                    Category selectedCate = (Category)cbCategory.getSelectedItem();
                    cbCategory.setSelectedItem(selectedCate);
                    Manufacturer selectManu = (Manufacturer)cbManufacturer.getSelectedItem();
                    cbManufacturer.setSelectedItem(selectManu);
                    //Category category = controllerCate.getCategoryById((Integer) tbCategory.getValueAt(selectedRow, 2));
                    //cbCategory.setSelectedItem((String) tbProduct.getValueAt((selectedRow), 2));
                    //cbManufacturer.setSelectedItem((String) tbProduct.getValueAt((selectedRow), 3));
                    txtDetail.setText( tbProduct.getValueAt(selectedRow, 5).toString());
                    txtQuantity.setText(tbProduct.getValueAt(selectedRow, 4).toString());
                    txtPrice.setText( tbProduct.getValueAt(selectedRow, 6).toString());
                    txtImage.setText((String) tbProduct.getValueAt(selectedRow, 7));
                }
            }
        });
    }

    private void clearInput() {
        txtID.setText("");
        txtName.setText("");
        cbCategory.setSelectedIndex(0);
        cbManufacturer.setSelectedIndex(0);
        txtPrice.setText("");
        txtQuantity.setText("");
        txtImage.setText("");
        txtDetail.setText("");
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
            java.util.logging.Logger.getLogger(frmProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnLoadImage;
    private javax.swing.JComboBox<Category> cbCategory;
    private javax.swing.JComboBox<Manufacturer> cbManufacturer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextField txtDetail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
