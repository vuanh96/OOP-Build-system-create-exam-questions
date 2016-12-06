/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.gui;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import oop.nhom5.de3.controller.CauHoi;
import oop.nhom5.de3.controller.DapAn;
import oop.nhom5.de3.controller.MonHoc;
import oop.nhom5.de3.controller.TracNghiem;
import oop.nhom5.de3.controller.TuLuan;
import oop.nhom5.de3.model.IOFileBinary;

/**
 *
 * @author KING
 */
public class SoanCauHoi extends javax.swing.JFrame {

    private MonHoc monHocDangChon;

    private ArrayList<TracNghiem> dsTracNghiem;
    private ArrayList<TuLuan> dsTuLuan;
    private ArrayList<CauHoi> dsCauHoi;
    private ArrayList<DapAn> dsDapAn;
    private int chucNang; // = 1 neu click ThemCauHoi, = 2 neu click ChinhSuaCauHoi
    private ArrayList<Integer> dsChuong;

    //---Thuoc tinh de setModel cho JList va JComboBox
    private DefaultListModel listDanhSachCauHoiModel;
    private DefaultComboBoxModel cbChuongModel;
    private DefaultListModel listDanhSachDapAnModel;

    /**
     * Creates new form SoanCauHoi1
     */
    public SoanCauHoi() {
        initComponents();
        //---Hien thi giua man hinh
        setLocationRelativeTo(null);

        dsTracNghiem = new ArrayList();
        dsTuLuan = new ArrayList();
        dsCauHoi = new ArrayList();
        dsDapAn = new ArrayList();
        listDanhSachCauHoiModel = new DefaultListModel();
        listDanhSachDapAnModel = new DefaultListModel();
        rbTrungGian.setVisible(false);
    }

    public SoanCauHoi(MonHoc monHocDangChon) {
        initComponents();
        //---Hien thi giua man hinh
        setLocationRelativeTo(null);

        this.monHocDangChon = monHocDangChon;
        dsTracNghiem = new ArrayList();
        dsTuLuan = new ArrayList();
        dsCauHoi = new ArrayList();
        dsDapAn = new ArrayList();
        dsChuong = new ArrayList();
        listDanhSachCauHoiModel = new DefaultListModel();
        cbChuongModel = new DefaultComboBoxModel();
        listDanhSachDapAnModel = new DefaultListModel();
        rbTrungGian.setVisible(false);

        lbMonHoc.setText("Môn học: " + monHocDangChon.getTenMonHoc());
        //---Doc du lieu cac cau hoi tu file
        readDsTracNghiem();
        readDsTuLuan();
        //---Mac dinh hien thi cau hoi dau tien trong danh sach
        if (!dsCauHoi.isEmpty()) {
            initListDanhSachCauHoi();
            listDanhSachCauHoi.setSelectedIndex(0);
            CauHoi cauHoiDangChon = dsCauHoi.get(0);
            infCauHoiDangChon();
            if (cauHoiDangChon instanceof TracNghiem) {
                dsDapAn = ((TracNghiem) cauHoiDangChon).getDsDapAn();
                if (!dsDapAn.isEmpty()) {
                    listDanhSachDapAn.setSelectedIndex(0);
                }
            }
        }
    }

    //---Khoi tao cho listDanhSachCauHoi
    private void initListDanhSachCauHoi() {
        dsTracNghiem.stream().forEach((i) -> {
            listDanhSachCauHoiModel.addElement("Trắc nghiệm: " + i.getDeBai());
        });
        dsTuLuan.stream().forEach((i) -> {
            listDanhSachCauHoiModel.addElement("Tự luận: " + i.getDeBai());
        });
        listDanhSachCauHoi.setModel(listDanhSachCauHoiModel);
    }

    //Doc du lieu tu file luu vao DsTracNghiem
    private void readDsTracNghiem() {
        this.dsTracNghiem = IOFileBinary.readFile("data//TracNghiem" + monHocDangChon.getMaHocPhan() + ".dat");
        this.dsCauHoi.addAll(this.dsTracNghiem);
    }

    //Doc du lieu tu file luu vao DsTuLuan  
    private void readDsTuLuan() {
        this.dsTuLuan = IOFileBinary.readFile("data//TuLuan" + monHocDangChon.getMaHocPhan() + ".dat");
        this.dsCauHoi.addAll(this.dsTuLuan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDanhSachDapAn = new javax.swing.JList<>();
        rbTracNghiem = new javax.swing.JRadioButton();
        rbTuLuan = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDeBai = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbDoKho = new javax.swing.JComboBox<>();
        lbDanhSachDapAn = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listDanhSachCauHoi = new javax.swing.JList<>();
        lbBarem = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taBarem = new javax.swing.JTextArea();
        bLuu = new javax.swing.JButton();
        bXoaCauHoi = new javax.swing.JButton();
        bOK = new javax.swing.JButton();
        lbThem = new javax.swing.JLabel();
        lbChinhSua = new javax.swing.JLabel();
        lbXoa = new javax.swing.JLabel();
        lbThemCauHoi = new javax.swing.JLabel();
        lbMonHoc = new javax.swing.JLabel();
        lbChinhSuaCauHoi = new javax.swing.JLabel();
        rbTrungGian = new javax.swing.JRadioButton();
        bDanhSachChuong = new javax.swing.JButton();
        cbChuong = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Soạn câu hỏi");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Danh sách câu hỏi");

        jScrollPane1.setViewportView(listDanhSachDapAn);

        buttonGroup2.add(rbTracNghiem);
        rbTracNghiem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbTracNghiem.setText("Trắc nghiệm");
        rbTracNghiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTracNghiemActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbTuLuan);
        rbTuLuan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbTuLuan.setText("Tự luận");
        rbTuLuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTuLuanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Đề bài : ");

        taDeBai.setColumns(20);
        taDeBai.setLineWrap(true);
        taDeBai.setRows(5);
        taDeBai.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taDeBai);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Chương :");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Độ khó :");

        cbDoKho.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbDoKho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dễ", "Trung bình", "Khó" }));

        lbDanhSachDapAn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbDanhSachDapAn.setText("Danh sách đáp án");

        listDanhSachCauHoi.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDanhSachCauHoiValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listDanhSachCauHoi);

        lbBarem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbBarem.setText("Barem chấm điểm");

        taBarem.setColumns(20);
        taBarem.setLineWrap(true);
        taBarem.setRows(5);
        taBarem.setWrapStyleWord(true);
        jScrollPane4.setViewportView(taBarem);

        bLuu.setBackground(new java.awt.Color(0, 0, 255));
        bLuu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bLuu.setForeground(new java.awt.Color(255, 255, 255));
        bLuu.setText("Lưu");
        bLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLuuActionPerformed(evt);
            }
        });

        bXoaCauHoi.setBackground(new java.awt.Color(255, 0, 0));
        bXoaCauHoi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bXoaCauHoi.setForeground(new java.awt.Color(255, 255, 255));
        bXoaCauHoi.setText("Xóa câu hỏi");
        bXoaCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoaCauHoiActionPerformed(evt);
            }
        });

        bOK.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bOK.setText("OK");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        lbThem.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbThem.setForeground(new java.awt.Color(0, 0, 255));
        lbThem.setText("Thêm");
        lbThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbThemMouseClicked(evt);
            }
        });

        lbChinhSua.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbChinhSua.setForeground(new java.awt.Color(0, 0, 255));
        lbChinhSua.setText("Chỉnh sửa");
        lbChinhSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbChinhSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbChinhSuaMouseClicked(evt);
            }
        });

        lbXoa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbXoa.setForeground(new java.awt.Color(255, 0, 0));
        lbXoa.setText("Xóa");
        lbXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbXoaMouseClicked(evt);
            }
        });

        lbThemCauHoi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbThemCauHoi.setForeground(new java.awt.Color(0, 0, 255));
        lbThemCauHoi.setText("Thêm câu hỏi");
        lbThemCauHoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbThemCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbThemCauHoiMouseClicked(evt);
            }
        });

        lbMonHoc.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbMonHoc.setText("Môn học :");

        lbChinhSuaCauHoi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbChinhSuaCauHoi.setForeground(new java.awt.Color(0, 0, 255));
        lbChinhSuaCauHoi.setText("Chỉnh sửa");
        lbChinhSuaCauHoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbChinhSuaCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbChinhSuaCauHoiMouseClicked(evt);
            }
        });

        buttonGroup2.add(rbTrungGian);
        rbTrungGian.setEnabled(false);

        bDanhSachChuong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bDanhSachChuong.setText("+");
        bDanhSachChuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDanhSachChuongActionPerformed(evt);
            }
        });

        cbChuong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMonHoc)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbThemCauHoi)
                                    .addGap(28, 28, 28)
                                    .addComponent(lbChinhSuaCauHoi))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel3)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbDoKho, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bDanhSachChuong)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(rbTracNghiem)
                                    .addGap(30, 30, 30)
                                    .addComponent(rbTuLuan)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rbTrungGian, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbThem)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbChinhSua)
                                    .addGap(50, 50, 50)
                                    .addComponent(lbXoa))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbDanhSachDapAn))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbBarem)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(bOK, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(bLuu)
                                            .addGap(45, 45, 45)
                                            .addComponent(bXoaCauHoi))))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbMonHoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rbTracNghiem)
                    .addComponent(rbTuLuan)
                    .addComponent(rbTrungGian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bDanhSachChuong)
                            .addComponent(jLabel3)
                            .addComponent(cbChuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbDoKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThemCauHoi)
                    .addComponent(lbChinhSuaCauHoi))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDanhSachDapAn)
                    .addComponent(lbBarem))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLuu)
                    .addComponent(bXoaCauHoi)
                    .addComponent(lbThem)
                    .addComponent(lbChinhSua)
                    .addComponent(lbXoa))
                .addGap(18, 18, 18)
                .addComponent(bOK)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLuuActionPerformed
        if (chucNang == 2) { //Neu click ChinhSuaCauHoi thi luu thay doi cho cauHoiDangChon
            if ( !dsCauHoi.isEmpty()) {
                CauHoi cauHoiDangChon = dsCauHoi.get(listDanhSachCauHoi.getSelectedIndex());
                cauHoiDangChon.setDeBai(taDeBai.getText());
                cauHoiDangChon.setDsChuong(dsChuong);
                cauHoiDangChon.setDoKho((String) cbDoKho.getSelectedItem());
                if (cauHoiDangChon instanceof TracNghiem) {
                    ((TracNghiem) cauHoiDangChon).setDsDapAn(dsDapAn);
                    //---Ghi dsTracNghiem ra file
                    writeDsTracNghiem();
                } else {
                    ((TuLuan) cauHoiDangChon).setBaremChamDiem(taBarem.getText());
                    //---Ghi dsTuLuan ra file
                    writeDsTuLuan();
                }
                //---Khoa cac o nhap du lieu
                unlock(false);
                JOptionPane.showMessageDialog(null, "Lưu thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Danh sách câu hỏi rỗng");
            }

        } else if (chucNang == 1) { //Neu da click ThemCauHoi thi tao ra cau hoi moi roi them vao danh sach
            if (rbTracNghiem.isSelected()) {
                TracNghiem newTracNghiem = new TracNghiem();
                newTracNghiem.setMonHoc(monHocDangChon);
                newTracNghiem.setDeBai(taDeBai.getText());
                newTracNghiem.setDsChuong(dsChuong);
                newTracNghiem.setDoKho((String) cbDoKho.getSelectedItem());
                newTracNghiem.setDsDapAn(dsDapAn);               
                
                listDanhSachCauHoiModel.addElement("Trắc nghiệm: " + newTracNghiem.getDeBai());
                listDanhSachCauHoi.setModel(listDanhSachCauHoiModel);
                
                dsTracNghiem.add(newTracNghiem);
                dsCauHoi.add(newTracNghiem);
                //---Ghi dsTracNghiem ra file
                writeDsTracNghiem();
                
                listDanhSachCauHoi.setSelectedIndex(listDanhSachCauHoi.getLastVisibleIndex());
                JOptionPane.showMessageDialog(null, "Lưu thành công");
                unlock(false);
                rbTuLuan.setEnabled(false);
            } else if (rbTuLuan.isSelected()) {
                TuLuan newTuLuan = new TuLuan();
                newTuLuan.setMonHoc(monHocDangChon);
                newTuLuan.setDeBai(taDeBai.getText());
                newTuLuan.setDsChuong(dsChuong);
                newTuLuan.setDoKho((String) cbDoKho.getSelectedItem());
                newTuLuan.setBaremChamDiem(taBarem.getText());
                
                dsTuLuan.add(newTuLuan);
                dsCauHoi.add(newTuLuan);
                //---Ghi dsTuLuan ra file
                writeDsTuLuan();
                
                listDanhSachCauHoiModel.addElement("Tự luận: " + newTuLuan.getDeBai());
                listDanhSachCauHoi.setModel(listDanhSachCauHoiModel);
                listDanhSachCauHoi.setSelectedIndex(listDanhSachCauHoi.getLastVisibleIndex());
                JOptionPane.showMessageDialog(null, "Lưu thành công");
                unlock(false);
                rbTracNghiem.setEnabled(false);
            }
            
        }
        chucNang = 0;
    }//GEN-LAST:event_bLuuActionPerformed
    public void writeDsTracNghiem() {
        IOFileBinary.writeFile(this.dsTracNghiem, "data//Tracnghiem" + monHocDangChon.getMaHocPhan() + ".dat");
    }

    public void writeDsTuLuan() {
        IOFileBinary.writeFile(this.dsTuLuan, "data//Tuluan" + monHocDangChon.getMaHocPhan() + ".dat");
    }
    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_bOKActionPerformed

    private void lbThemCauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbThemCauHoiMouseClicked
        chucNang = 1;
        cbChuongModel = new DefaultComboBoxModel();
        dsDapAn = new ArrayList();
        dsChuong = new ArrayList();

        //---Mo khoa cac o nhap du lieu
        unlock(true);

        //---Reset toan bo cac o
        rbTrungGian.setSelected(true);
        taDeBai.setText("");
        cbChuongModel = new DefaultComboBoxModel();
        cbChuong.setModel(cbChuongModel);
        cbDoKho.setSelectedItem("Dễ");
        listDanhSachDapAnModel = new DefaultListModel();
        listDanhSachDapAn.setModel(listDanhSachDapAnModel);
        taBarem.setText("");

        changeState();
    }//GEN-LAST:event_lbThemCauHoiMouseClicked
    private void unlock(boolean x) {
        //---Mo khoa cac o nhap du lieu
        taDeBai.setEditable(x);
        bDanhSachChuong.setEnabled(x);
        cbChuong.setEnabled(x);
        cbDoKho.setEnabled(x);
        listDanhSachDapAn.setEnabled(x);
        taBarem.setEditable(x);
        lbThem.setEnabled(x);
        lbChinhSua.setEnabled(x);
        lbXoa.setEnabled(x);
    }

    private void changeState() {
        //Neu rbTracNghiem duoc chon thi hien thi phan DanhSachDapAn, an phan barem
        if (rbTracNghiem.isSelected()) {
            rbTracNghiem.setEnabled(true);
            lbDanhSachDapAn.setVisible(true);
            listDanhSachDapAn.setVisible(true);
            lbThem.setVisible(true);
            lbChinhSua.setVisible(true);
            lbXoa.setVisible(true);
            rbTuLuan.setEnabled(false);
            lbBarem.setVisible(false);
            taBarem.setVisible(false);
        } else if (rbTuLuan.isSelected()) {  //Neu rbTuLuan duoc chon thi an phan DanhSachDapAn, hien thi phan barem
            rbTracNghiem.setEnabled(false);
            lbDanhSachDapAn.setVisible(false);
            listDanhSachDapAn.setVisible(false);
            lbThem.setVisible(false);
            lbChinhSua.setVisible(false);
            lbXoa.setVisible(false);
            rbTuLuan.setEnabled(true);
            lbBarem.setVisible(true);
            taBarem.setVisible(true);
        } else { //Neu rbTrung gian dc chon (clickThemMonHoc) thi hien thi tat ca
            //---Hien thi ca 2 phan nhap trac nghiem va tu luan
            rbTracNghiem.setEnabled(true);
            rbTuLuan.setEnabled(true);
            lbDanhSachDapAn.setVisible(true);
            listDanhSachDapAn.setVisible(true);
            lbThem.setVisible(true);
            lbChinhSua.setVisible(true);
            lbXoa.setVisible(true);
            lbBarem.setVisible(true);
            taBarem.setVisible(true);
        }
    }

    private void infCauHoiDangChon() {
        //---Hien thi thong tin cua cauHoiDangChon tren cac o
        CauHoi cauHoiDangChon = dsCauHoi.get(listDanhSachCauHoi.getSelectedIndex());
        taDeBai.setText(cauHoiDangChon.getDeBai());
        cbChuongModel = new DefaultComboBoxModel();
        for (int i = 0; i < cauHoiDangChon.getDsChuong().size(); i++) {
            cbChuongModel.addElement("Chương " + cauHoiDangChon.getDsChuong().get(i));
        }
        cbChuong.setModel(cbChuongModel);
        cbDoKho.setSelectedItem(cauHoiDangChon.getDoKho());

        //---Neu cauHoiDangChon la TracNghiem thi thay doi cac o
        if (cauHoiDangChon instanceof TracNghiem) {
            rbTracNghiem.setSelected(true);
            dsDapAn = ((TracNghiem) cauHoiDangChon).getDsDapAn();
            listDanhSachDapAnModel = new DefaultListModel();
            dsDapAn.stream().forEach((i) -> {
                if (i.isDapAnDung()) {
                    listDanhSachDapAnModel.addElement("(Đ) " + i.getNoiDung());
                } else {
                    listDanhSachDapAnModel.addElement(i.getNoiDung());
                }
            });
            listDanhSachDapAn.setModel(listDanhSachDapAnModel);
            changeState();
        } else { //---Neu la cau hoi tu luan thi thay doi cac o
            rbTuLuan.setSelected(true);
            taBarem.setText(((TuLuan) cauHoiDangChon).getBaremChamDiem());
            changeState();
        }
        //---Khoa cac o nhap du lieu
        unlock(false);
    }
    private void lbThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbThemMouseClicked

        if (chucNang ==2 || chucNang == 1) {

            ThemDapAn tda = new ThemDapAn(this.dsDapAn, this.listDanhSachDapAnModel, this.listDanhSachDapAn,1);
            tda.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn câu hỏi cần thêm đáp án");
        }
    }//GEN-LAST:event_lbThemMouseClicked

    private void lbChinhSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChinhSuaMouseClicked
        if (!dsDapAn.isEmpty()) {
            DapAn dapAnDangChon = dsDapAn.get(listDanhSachDapAn.getSelectedIndex());
            ThemDapAn tda = new ThemDapAn(this.dsDapAn, this.listDanhSachDapAnModel, this.listDanhSachDapAn, dapAnDangChon,2);
            tda.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Danh sách đáp án rỗng");
        }
    }//GEN-LAST:event_lbChinhSuaMouseClicked

    private void lbXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbXoaMouseClicked
        if ( !dsDapAn.isEmpty()){
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa đáp án này không ?", "Hãy lựa chọn", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                DapAn dapAnDangChon = dsDapAn.get(listDanhSachDapAn.getSelectedIndex());
                listDanhSachDapAnModel.removeElementAt(dsDapAn.indexOf(dapAnDangChon));
                listDanhSachDapAn.setModel(listDanhSachDapAnModel);
                dsDapAn.remove(dapAnDangChon);
                if ( !dsDapAn.isEmpty()) {
                    listDanhSachDapAn.setSelectedIndex(0);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Danh sách đáp án rỗng");
        }
    }//GEN-LAST:event_lbXoaMouseClicked

    private void bXoaCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaCauHoiActionPerformed
        
        if (!dsCauHoi.isEmpty()) {
            CauHoi cauHoiDangChon = dsCauHoi.get(listDanhSachCauHoi.getSelectedIndex());
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa câu hỏi này không ?", "Hãy lựa chọn", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                listDanhSachCauHoiModel.removeElementAt(dsCauHoi.indexOf(cauHoiDangChon));
                listDanhSachCauHoi.setModel(listDanhSachCauHoiModel);
                if (cauHoiDangChon instanceof TracNghiem) {
                    dsTracNghiem.remove((TracNghiem) cauHoiDangChon);
                } else {
                    dsTuLuan.remove((TuLuan) cauHoiDangChon);
                }
                dsCauHoi.remove(cauHoiDangChon);
                //---Sau khi xoa lai chon cau hoi dau tien trong dsCauHoi
                if (!dsCauHoi.isEmpty()) {
                    listDanhSachCauHoi.setSelectedIndex(0);
                    infCauHoiDangChon();
                }
                changeState();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Danh sách câu hỏi rỗng");
        }
    }//GEN-LAST:event_bXoaCauHoiActionPerformed

    private void lbChinhSuaCauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChinhSuaCauHoiMouseClicked

        if (!dsCauHoi.isEmpty()) {
            chucNang = 2;
            //---Mo khoa cac o nhap du lieu
            unlock(true);
        } else {
            JOptionPane.showMessageDialog(null, "Danh sách câu hỏi rỗng");
        }

    }//GEN-LAST:event_lbChinhSuaCauHoiMouseClicked

    private void bDanhSachChuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDanhSachChuongActionPerformed
        if ( chucNang == 2 ) {
            CauHoi cauHoiDangChon = dsCauHoi.get(listDanhSachCauHoi.getSelectedIndex());
            DanhSachChuong dsc = new DanhSachChuong(this.monHocDangChon, cauHoiDangChon, this.cbChuong, this.cbChuongModel, this.chucNang);
            this.dsChuong = dsc.getDsChuong();
            dsc.setVisible(true);
        } else if ( chucNang == 1) {
            DanhSachChuong dsc = new DanhSachChuong(this.monHocDangChon, null, this.cbChuong, this.cbChuongModel, this.chucNang);
            this.dsChuong = dsc.getDsChuong();
            dsc.setVisible(true);
        }

    }//GEN-LAST:event_bDanhSachChuongActionPerformed

    private void rbTracNghiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTracNghiemActionPerformed

        lbDanhSachDapAn.setVisible(true);
        listDanhSachDapAn.setVisible(true);
        lbThem.setVisible(true);
        lbChinhSua.setVisible(true);
        lbXoa.setVisible(true);
        lbBarem.setVisible(false);
        taBarem.setVisible(false);
    }//GEN-LAST:event_rbTracNghiemActionPerformed

    private void rbTuLuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTuLuanActionPerformed
        lbDanhSachDapAn.setVisible(false);
        listDanhSachDapAn.setVisible(false);
        lbThem.setVisible(false);
        lbChinhSua.setVisible(false);
        lbXoa.setVisible(false);
        lbBarem.setVisible(true);
        taBarem.setVisible(true);
    }//GEN-LAST:event_rbTuLuanActionPerformed

    private void listDanhSachCauHoiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDanhSachCauHoiValueChanged
        // Bat su kien select, bo qua su kien deselect
        if (evt.getValueIsAdjusting()) {
            CauHoi cauHoiDangChon = dsCauHoi.get(listDanhSachCauHoi.getSelectedIndex());
            dsChuong = cauHoiDangChon.getDsChuong();
            infCauHoiDangChon();
            if (cauHoiDangChon instanceof TracNghiem) {
                dsDapAn = ((TracNghiem) cauHoiDangChon).getDsDapAn();
                if (!dsDapAn.isEmpty()) {
                    listDanhSachDapAn.setSelectedIndex(0);
                }
            }           
            chucNang = 0;
        }
    }//GEN-LAST:event_listDanhSachCauHoiValueChanged

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
            java.util.logging.Logger.getLogger(SoanCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDanhSachChuong;
    private javax.swing.JButton bLuu;
    private javax.swing.JButton bOK;
    private javax.swing.JButton bXoaCauHoi;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbChuong;
    private javax.swing.JComboBox<String> cbDoKho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbBarem;
    private javax.swing.JLabel lbChinhSua;
    private javax.swing.JLabel lbChinhSuaCauHoi;
    private javax.swing.JLabel lbDanhSachDapAn;
    private javax.swing.JLabel lbMonHoc;
    private javax.swing.JLabel lbThem;
    private javax.swing.JLabel lbThemCauHoi;
    private javax.swing.JLabel lbXoa;
    private javax.swing.JList<String> listDanhSachCauHoi;
    private javax.swing.JList<String> listDanhSachDapAn;
    private javax.swing.JRadioButton rbTracNghiem;
    private javax.swing.JRadioButton rbTrungGian;
    private javax.swing.JRadioButton rbTuLuan;
    private javax.swing.JTextArea taBarem;
    private javax.swing.JTextArea taDeBai;
    // End of variables declaration//GEN-END:variables

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        @Override
        public void run() {
            new SoanCauHoi().setVisible(true);
        }
    }
}