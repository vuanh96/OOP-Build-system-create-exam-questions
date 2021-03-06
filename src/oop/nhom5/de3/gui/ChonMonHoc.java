/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.gui;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import oop.nhom5.de3.controller.MonHoc;
import oop.nhom5.de3.model.IOFileBinary;

/**
 *
 * @author KING
 */
public class ChonMonHoc extends javax.swing.JFrame {
    private ArrayList <MonHoc> dsMonHoc;
    private MonHoc monHocDaChon;
    private final DefaultComboBoxModel cbDanhSachMonHocModel;
    
    //---Thuoc tinh danh dau su kien da chon o Giao dien chinh
    private  boolean chooseSoanCauHoi;
    private boolean chooseXayDungDeThi;
    private boolean chooseLamBaiThi;
        
    //-------------------------------------
    public ArrayList<MonHoc> getDsMonHoc() {
        return dsMonHoc;
    } 

    public void setChooseSoanCauHoi(boolean chooseSoanCauHoi) {
        this.chooseSoanCauHoi = chooseSoanCauHoi;
    }

    public void setChooseXayDungDeThi(boolean chooseXayDungDeThi) {
        this.chooseXayDungDeThi = chooseXayDungDeThi;
    }

    public void setChooseLamBaiThi(boolean chooseLamBaiThi) {
        this.chooseLamBaiThi = chooseLamBaiThi;
    }

    public MonHoc getMonHocDaChon() {
        return monHocDaChon;
    }
    
    
    /**
     * Creates new form ChonMonHoc1
     */
    public ChonMonHoc() {
        initComponents();
        //---Hien thi giua man hinh
        setLocationRelativeTo(null);
        cbDanhSachMonHocModel = new DefaultComboBoxModel();
        //-----------------------
        dsMonHoc = new ArrayList();
        readDsMonHoc();
        if(!dsMonHoc.isEmpty()) {
            monHocDaChon = dsMonHoc.get(0);
        }
        initComboBoxDanhSachMonHoc();
    }
    
    //Hien thi danh sach mon hoc tren ComboBox
    private void initComboBoxDanhSachMonHoc() {
        dsMonHoc.stream().forEach((i) -> {
            cbDanhSachMonHocModel.addElement(i.getTenMonHoc());
        });
        cbDanhSachMonHoc.setModel(cbDanhSachMonHocModel);
    }   
    
    //Doc du lieu tu file luu vao dsMonHoc
    private void readDsMonHoc() {
        this.dsMonHoc = IOFileBinary.readFile("data/DanhSachMonHoc.dat");
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
        cbDanhSachMonHoc = new javax.swing.JComboBox<>();
        lbQuanLiMonHoc = new javax.swing.JLabel();
        bOK = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chọn môn học");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Danh sách môn học");

        cbDanhSachMonHoc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbDanhSachMonHoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDanhSachMonHocItemStateChanged(evt);
            }
        });

        lbQuanLiMonHoc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbQuanLiMonHoc.setForeground(new java.awt.Color(0, 0, 255));
        lbQuanLiMonHoc.setText("Quản lí môn học");
        lbQuanLiMonHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbQuanLiMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQuanLiMonHocMouseClicked(evt);
            }
        });

        bOK.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bOK.setText("OK");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        bCancel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDanhSachMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(bOK)
                            .addGap(1, 1, 1)
                            .addComponent(bCancel))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(186, 186, 186)
                            .addComponent(lbQuanLiMonHoc))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDanhSachMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbQuanLiMonHoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOK)
                    .addComponent(bCancel))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbQuanLiMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQuanLiMonHocMouseClicked
        QuanLiMonHoc qlmh = new QuanLiMonHoc(this.dsMonHoc);
        qlmh.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_lbQuanLiMonHocMouseClicked

    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        if ( !dsMonHoc.isEmpty()) {
            if (chooseSoanCauHoi) {
                SoanCauHoi sch = new SoanCauHoi(this.monHocDaChon);
                sch.setVisible(true);

                this.dispose();
            } else if (chooseXayDungDeThi) {
                QuanLiDeThi qldt = new QuanLiDeThi(this.monHocDaChon);
                qldt.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Chức năng chưa được cập nhật");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Danh sách môn học trống! Hãy tạo môn học và tiếp tục");
        }
    }//GEN-LAST:event_bOKActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void cbDanhSachMonHocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDanhSachMonHocItemStateChanged
        //Bat su kien select, bo qua su kien deselect
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            monHocDaChon = dsMonHoc.get(cbDanhSachMonHoc.getSelectedIndex());
        }
    }//GEN-LAST:event_cbDanhSachMonHocItemStateChanged

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChonMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bOK;
    private javax.swing.JComboBox<String> cbDanhSachMonHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbQuanLiMonHoc;
    // End of variables declaration//GEN-END:variables

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        @Override
        public void run() {
            new ChonMonHoc().setVisible(true);
        }
    }
}
