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
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
    int selected = 0;

    String path = System.getProperty("user.dir");
    String baseImagePath = path + "\\src\\main\\java\\com\\mycompany\\cuahanglinhkien_java\\images\\product_images\\";
    DefaultComboBoxModel<Category> cbCategoryModel = new DefaultComboBoxModel<Category>();
    DefaultComboBoxModel<Manufacturer> cbManufacturerModel = new DefaultComboBoxModel<Manufacturer>();
    private DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
        public Class<?> getColumnClass(int columIndex) {
            if (columIndex == 7) {
                return ImageIcon.class;
            }
            return super.getColumnClass(columIndex);
        }
    };

    public frmProduct() {
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

    public class ImageHasher {

        public static String hashFile(String imageName) throws NoSuchAlgorithmException, IOException {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(imageName.getBytes());
            // Chuyển đổi mảng byte thành chuỗi hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }
    }

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
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbManufacturer = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtDetail = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbImage = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnLoadImage = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 640));
        setSize(new java.awt.Dimension(500, 300));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.GridBagLayout());

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 672;
        gridBagConstraints.ipady = 540;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 6);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jLabel11.setText("Nhập tên sản phẩm cần tìm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel3.add(jLabel11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel3.add(txtSearch, gridBagConstraints);

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel3.add(btnSearch, gridBagConstraints);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin");
        jPanel1.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridLayout(5, 0));

        jPanel16.setLayout(new java.awt.GridLayout(2, 0));

        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setText("Mã sản phẩm");
        jPanel5.add(jLabel3);

        txtID.setEnabled(false);
        jPanel5.add(txtID);

        jPanel16.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tên sản phẩm");
        jPanel6.add(jLabel4);

        txtName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel6.add(txtName);

        jPanel16.add(jPanel6);

        jPanel4.add(jPanel16);

        jPanel17.setLayout(new java.awt.GridLayout(2, 0));

        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.setLayout(new java.awt.GridLayout(2, 0));

        jLabel6.setText("Hãng SX");
        jPanel8.add(jLabel6);

        jPanel8.add(cbManufacturer);

        jPanel17.add(jPanel8);

        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        jLabel5.setText("Danh mục");
        jPanel7.add(jLabel5);

        jPanel7.add(cbCategory);

        jPanel17.add(jPanel7);

        jPanel4.add(jPanel17);

        jPanel18.setLayout(new java.awt.GridLayout(2, 0));

        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        jLabel8.setText("Chi tiết");
        jPanel10.add(jLabel8);

        jPanel11.setLayout(new java.awt.GridLayout(1, 2));
        jPanel11.add(txtDetail);

        jPanel10.add(jPanel11);

        jPanel18.add(jPanel10);

        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jPanel14.setLayout(new java.awt.GridLayout(0, 2));

        jLabel12.setText("Số lượng");
        jPanel14.add(jLabel12);

        txtQuantity.setText("jTextField1");
        jPanel14.add(txtQuantity);

        jPanel9.add(jPanel14);

        jLabel7.setText("Giá");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPrice))
                .addContainerGap())
        );

        jPanel9.add(jPanel15);

        jPanel18.add(jPanel9);

        jPanel4.add(jPanel18);

        jPanel13.setPreferredSize(new java.awt.Dimension(100, 16));
        jPanel13.setLayout(new java.awt.GridLayout(1, 2));

        jLabel10.setText("Hình");
        jPanel13.add(jLabel10);

        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel13.add(lbImage);

        jPanel4.add(jPanel13);

        jPanel19.setLayout(new java.awt.GridLayout(2, 0));

        jPanel12.setLayout(new java.awt.GridLayout(2, 0));

        btnLoadImage.setText("Tải ảnh lên");
        btnLoadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadImageActionPerformed(evt);
            }
        });
        jPanel12.add(btnLoadImage);

        jPanel19.add(jPanel12);

        jPanel20.setLayout(new java.awt.GridLayout(1, 4));

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel20.add(btnAdd);

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel20.add(btnEdit);

        btnImport.setText("Nhập hàng");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        jPanel20.add(btnImport);

        jPanel19.add(jPanel20);

        jPanel4.add(jPanel19);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            // Lấy thông tin sản phẩm từ các trường nhập liệu
            String name = txtName.getText().trim();
            Category selectedCate = (Category) cbCategory.getSelectedItem();
            Manufacturer selectedManu = (Manufacturer) cbManufacturer.getSelectedItem();
            int quantity = Integer.parseInt(txtQuantity.getText().trim());
            String details = txtDetail.getText().trim();
            double price = Double.parseDouble(txtPrice.getText().trim());

            ImageIcon imgIcon = (ImageIcon) lbImage.getIcon();
            if (imgIcon == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn hình ảnh!", "Thông báo", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }
            Image img = imgIcon.getImage();
            BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            bufferedImage.getGraphics().drawImage(img, 0, 0, null);
            //String fileName = ImageHasher.hashFile(lbImage.getText()) + ".png";  // Băm tệp ảnh để tạo tên file duy nhất
            String uniqueInput = String.valueOf(System.currentTimeMillis()); // Kết hợp đường dẫn và thời gian
            String fileName = ImageHasher.hashFile(uniqueInput) + ".png";
            // Lưu ảnh vào thư mục
            File outputFile = new File(baseImagePath + fileName);
            ImageIO.write(bufferedImage, "PNG", outputFile);

            Product newPro = new Product();
            newPro.setName(name);
            newPro.setCategoryId(selectedCate.getId());
            newPro.setManufacturerId(selectedManu.getId());
            newPro.setDetails(details);
            newPro.setQuantity(quantity);
            newPro.setPrice((float) price);
            newPro.setImage(fileName);

            boolean success = controller.addProduct(newPro);
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
            int selectedRow = tbProduct.getSelectedRow();
            if (selectedRow < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để sửa!", "Thông báo", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Lấy thông tin từ giao diện
            int id = Integer.parseInt(tbProduct.getValueAt(selectedRow, 0).toString());
            String name = txtName.getText().trim();
            Category selectedCategory = (Category) cbCategory.getSelectedItem();
            Manufacturer selectedManufacturer = (Manufacturer) cbManufacturer.getSelectedItem();
            int quantity = Integer.parseInt(txtQuantity.getText().trim());
            String details = txtDetail.getText().trim();
            double price = Double.parseDouble(txtPrice.getText().trim());
            Product product = controller.getProductById(id);
            // Lấy thông tin hình ảnh cũ từ bảng
            String oldImagePath = product.getImage(); // Chỉ số 7 là cột chứa đường dẫn ảnh
            if (!oldImagePath.isEmpty()) {
                File oldImageFile = new File(baseImagePath + oldImagePath);
                if (oldImageFile.exists() && !oldImageFile.delete()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Không thể xóa hình ảnh cũ!", "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String newFileName = null;
            ImageIcon imgIcon = (ImageIcon) lbImage.getIcon();
            if (imgIcon != null) {
                Image img = imgIcon.getImage();
                BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                bufferedImage.getGraphics().drawImage(img, 0, 0, null);

                // Tạo tên tệp mới bằng ImageHasher
                String uniqueInput = String.valueOf(System.currentTimeMillis());
                String hashedFileName = ImageHasher.hashFile(uniqueInput);
                newFileName = hashedFileName + ".png";

                // Lưu hình ảnh mới
                File outputFile = new File(baseImagePath + newFileName);
                ImageIO.write(bufferedImage, "PNG", outputFile);
                System.out.println("Hình ảnh mới đã được lưu: " + newFileName);
            }

            // Cập nhật thông tin sản phẩm
            Product updatedProduct = new Product(
                    id, name, selectedCategory.getId(), selectedManufacturer.getId(),
                    quantity, details, newFileName, (float) price
            );

            boolean success = controller.updateProduct(updatedProduct);

            if (success) {
                javax.swing.JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công!", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                loadData();
                clearInput();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Sửa sản phẩm thất bại!", "Thông báo", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        try {
            int row = this.tbProduct.getSelectedRow();
            if (row >= 0) {

                List<Category> listCate = controllerCate.getAllCategory();
                List<Manufacturer> listManu = controllerManu.getAllManufacturer();
                String id = tbProduct.getValueAt(row, 0).toString();
                String name = tbProduct.getValueAt(row, 1).toString();
                String details = tbProduct.getValueAt(row, 5).toString();
                String quantity = tbProduct.getValueAt(row, 4).toString();
                String price = tbProduct.getValueAt(row, 6).toString();
                ImageIcon icon = (ImageIcon) tbProduct.getValueAt(row, 7);
                Category selectedCate = (Category) cbCategory.getSelectedItem();
                Manufacturer selectManu = (Manufacturer) cbManufacturer.getSelectedItem();
                txtID.setText(id);
                txtName.setText(name);
                txtDetail.setText(details);
                txtQuantity.setText(quantity);
                txtPrice.setText(price);
                lbImage.setIcon(icon);

                for (Manufacturer manufacturer : listManu) {
                    if (manufacturer.getName().equals(tbProduct.getValueAt(row, 3).toString())) {
                        cbManufacturerModel.setSelectedItem(manufacturer);
                        break;
                    }
                }
                for (Category category : listCate) {
                    if (category.getName().equals(tbProduct.getValueAt(row, 2).toString())) {
                        cbCategoryModel.setSelectedItem(category);
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(frmCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbProductMouseClicked

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        if (selected != -1) {
            int selectedRow = tbProduct.getSelectedRow();
            String productId = tbProduct.getValueAt(selectedRow, 0).toString();
            String productName = tbProduct.getValueAt(selectedRow, 1).toString();
            frmInventory frmInventory = new frmInventory(selected);
            frmInventory.setLocationRelativeTo(null);
            frmInventory.setVisible(true);
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String searchQuery = txtSearch.getText().trim();
            if (searchQuery.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm để tìm kiếm!", "Thông báo", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }
            List<Product> searchResults = controller.searchProductByName(searchQuery);
            model.setRowCount(0);
            if (searchResults != null && !searchResults.isEmpty()) {
                for (Product product : searchResults) {
                    model.addRow(new Object[]{product.getId(), product.getName(),
                        product.getCategoryId(), product.getManufacturerId(),
                        product.getQuantity(), product.getDetails(),
                        product.getPrice(), product.getImage()});
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào!", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLoadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadImageActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Hình ảnh", "jpg", "png", "jpeg"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(filePath);
            lbImage.setIcon(imageIcon);
        }
    }//GEN-LAST:event_btnLoadImageActionPerformed

    private void loadCate() {
        List<Category> categories;
        categories = controllerCate.getAllCategory();
        cbCategoryModel.removeAllElements();
        for (Category category : categories) {
            cbCategoryModel.addElement(category);
        }
        cbCategory.firePopupMenuCanceled();
    }
    private void loadManu() {
        List<Manufacturer> listManu;
        listManu = controllerManu.getAllManufacturer();
        cbManufacturerModel.removeAllElements();
        // Thêm danh mục vào ComboBox
        for (Manufacturer manufacturer : listManu) {
            cbManufacturerModel.addElement(manufacturer);
        }
        cbManufacturer.firePopupMenuCanceled();
    }

    private void loadData() {
        List<Product> listProduct = controller.getAllProduct();
        List<Category> listCate = controllerCate.getAllCategory();
        List<Manufacturer> listManu = controllerManu.getAllManufacturer();
        model.setRowCount(0);

        listProduct.forEach(Product -> {
            ImageIcon imageIcon = null;
            if (Product.getImage() != null && !Product.getImage().isEmpty()) {
                String imagePath = baseImagePath + Product.getImage();
                File imageFile = new File(imagePath);

                if (imageFile.exists()) {
                    ImageIcon originalIcon = new ImageIcon(imagePath);
                    Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Điều chỉnh kích thước ảnh
                    imageIcon = new ImageIcon(scaledImage);
                }
            }
            Manufacturer manufacturer = listManu.stream().filter(p -> p.getId() == Product.getManufacturerId()).findFirst().orElse(null);
            Category category = listCate.stream().filter(p -> p.getId() == Product.getCategoryId()).findFirst().orElse(null);
            model.addRow(new Object[]{Product.getId(), Product.getName(),
                category.getName(), manufacturer.getName(),
                Product.getQuantity(), Product.getDetails(),
                Product.getPrice(), imageIcon});
        });
    }

    private void addEvent() {
        tbProduct.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tbProduct.getSelectedRow();
                if (selectedRow != -1) {
                    selected = Integer.parseInt(tbProduct.getValueAt(selectedRow, 0).toString());
                    txtID.setText(selected + "");
                    txtName.setText((String) tbProduct.getValueAt(selectedRow, 1));
                    Category selectedCate = (Category) cbCategory.getSelectedItem();
                    cbCategory.setSelectedItem(selectedCate);
                    Manufacturer selectManu = (Manufacturer) cbManufacturer.getSelectedItem();
                    cbManufacturer.setSelectedItem(selectManu);
                    txtDetail.setText(tbProduct.getValueAt(selectedRow, 5).toString());
                    txtQuantity.setText(tbProduct.getValueAt(selectedRow, 4).toString());
                    txtPrice.setText(tbProduct.getValueAt(selectedRow, 6).toString());
                    lbImage.setIcon((ImageIcon) tbProduct.getValueAt(selectedRow, 7));
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
        lbImage.setText("");
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
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnLoadImage;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<Category> cbCategory;
    private javax.swing.JComboBox<Manufacturer> cbManufacturer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImage;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextField txtDetail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
