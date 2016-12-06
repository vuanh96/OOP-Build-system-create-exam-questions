/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.gui;

/**
 *
 * @author KING
 */
public class GiaoDienChinh extends javax.swing.JFrame {

    /**
     * Creates new form GiaoDienChinh
     */
    public GiaoDienChinh() {
        initComponents();
        //---Hien thi giua man hinh
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bSoanCauHoi = new javax.swing.JButton();
        bXayDungDeThi = new javax.swing.JButton();
        bLamBaiThi = new javax.swing.JButton();
        bThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OOP nhóm 5");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        bSoanCauHoi.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        bSoanCauHoi.setText("Soạn câu hỏi");
        bSoanCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSoanCauHoiActionPerformed(evt);
            }
        });

        bXayDungDeThi.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        bXayDungDeThi.setText("Xây dựng đề thi");
        bXayDungDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXayDungDeThiActionPerformed(evt);
            }
        });

        bLamBaiThi.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        bLamBaiThi.setText("Làm bài thi");
        bLamBaiThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLamBaiThiActionPerformed(evt);
            }
        });

        bThoat.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bThoat.setText("Thoát");
        bThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bSoanCauHoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bXayDungDeThi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addComponent(bLamBaiThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(bSoanCauHoi)
                .addGap(33, 33, 33)
                .addComponent(bXayDungDeThi)
                .addGap(40, 40, 40)
                .addComponent(bLamBaiThi)
                .addGap(30, 30, 30)
                .addComponent(bThoat)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bXayDungDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXayDungDeThiActionPerformed
        ChonMonHoc chonMonHoc = new ChonMonHoc();
        chonMonHoc.setVisible(true);
        chonMonHoc.setChooseXayDungDeThi(true);
    }//GEN-LAST:event_bXayDungDeThiActionPerformed

    private void bThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bThoatActionPerformed

    private void bSoanCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSoanCauHoiActionPerformed
        ChonMonHoc chonMonHoc = new ChonMonHoc();
        chonMonHoc.setVisible(true);
        chonMonHoc.setChooseSoanCauHoi(true);
    }//GEN-LAST:event_bSoanCauHoiActionPerformed

    private void bLamBaiThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLamBaiThiActionPerformed
        ChonMonHoc chonMonHoc = new ChonMonHoc();
        chonMonHoc.setVisible(true);
        chonMonHoc.setChooseLamBaiThi(true);
    }//GEN-LAST:event_bLamBaiThiActionPerformed

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
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GiaoDienChinh().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLamBaiThi;
    private javax.swing.JButton bSoanCauHoi;
    private javax.swing.JButton bThoat;
    private javax.swing.JButton bXayDungDeThi;
    // End of variables declaration//GEN-END:variables
}
