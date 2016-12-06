/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.gui;

import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import oop.nhom5.de3.controller.CauHoi;
import oop.nhom5.de3.controller.DeThi;
import oop.nhom5.de3.controller.MonHoc;
import oop.nhom5.de3.controller.TracNghiem;
import oop.nhom5.de3.controller.TuLuan;
import oop.nhom5.de3.model.IOFileBinary;
import oop.nhom5.de3.model.IOFilePDF;
import oop.nhom5.de3.model.IOFileWord;

/**
 *
 * @author KING
 */
public class ChonCauHoi extends javax.swing.JFrame {
    private int chucNang; //=1 : Mo de thi, =2 : Chon cau hoi
    private MonHoc monHocDangChon;
    //-----------------------------
    private ArrayList<CauHoi> dsCauHoiMonHoc;
    private ArrayList<CauHoi> dsCauHoiDaLoc;
    private ArrayList<TracNghiem> dsTracNghiemMonHoc;
    private ArrayList<TuLuan> dsTuLuanMonHoc;
    //---Thong tin de thi
    private DeThi deThi;
    //---Thuoc tinh setModel cho cac JList va JComboBox
    private DefaultListModel listDanhSachCauHoiModel;
    private DefaultComboBoxModel cbChuongModel;
    private DefaultListModel listDsCauHoiDeThiModel;

    /**
     * Creates new form ChonCauHoi
     */
    public ChonCauHoi() {
        initComponents();
        //---Hien thi giua man hinh
        setLocationRelativeTo(null);
    }
    public ChonCauHoi(MonHoc monHocDangChon, int chucNang, DeThi deThi) {
        initComponents();
        //---Hien thi giua man hinh
        setLocationRelativeTo(null);
        this.monHocDangChon = monHocDangChon;
        this.chucNang = chucNang;
        
        this.dsCauHoiMonHoc = new ArrayList();
        this.dsTracNghiemMonHoc = new ArrayList();
        this.dsTuLuanMonHoc = new ArrayList();
        this.deThi = deThi;
        
        listDanhSachCauHoiModel = new DefaultListModel();
        cbChuongModel = new DefaultComboBoxModel();
        this.listDsCauHoiDeThiModel = new DefaultListModel();
        
        //---Doc tu file dsTracNghiem va dsTuLuan cua monHocDangChon
        readDsTracNghiem();
        readDsTuLuan();
        //---Khoi tao cho listDanhSachCauHoi cua mon hoc
        initListDanhSachCauHoi();
        //---Mac dinh selected cau hoi dau tien va hien thi tren taCauHoi
        if ( !dsCauHoiMonHoc.isEmpty()) {
            this.listDanhSachCauHoi.setSelectedIndex(0);
            CauHoi cauHoiDangChon = dsCauHoiMonHoc.get(0);
            taCauHoi.setText(cauHoiDangChon.inCauHoi().toString());
            this.tfDiem.setText(Float.toString(cauHoiDangChon.getDiem()));
        }
        
        this.dsCauHoiDaLoc = this.dsCauHoiMonHoc;
        
        //---Khoi tao cbChuong voi so chuong tuong ung cua monHocDangChon
        cbChuongModel.addElement("Chương");
        cbChuongModel.addElement("Tất cả");
        for (int i=0; i < monHocDangChon.getSoChuong(); i++) {
            cbChuongModel.addElement("Chương "+ (i+1));
        }
        cbChuong.setModel(cbChuongModel);

        this.rbTrungGian.setVisible(false);
        this.lbTronDapAn.setVisible(false);
        tfTenDeThi.setText(this.inTenDethi().toString());
        taDeThi.setText(this.deThi.inDeThi().toString());
        //Neu mo de thi co san thi hien thi thong tin da tao cua de thi
        if ( chucNang ==1) {
            for ( CauHoi i : deThi.getDsCauHoi()) {
                this.listDsCauHoiDeThiModel.addElement(i.getDeBai());
            }
            this.listDsCauHoiDeThi.setModel(this.listDsCauHoiDeThiModel);
            tfTenDeThi.setText(deThi.getTenDeThi());
            tfThoiGian.setText(deThi.getThoiGian());
            tfNamHoc.setText(deThi.getNamHoc());
            switch (deThi.getKiHoc()) {
                case "Kì 1":
                    rbKi1.setSelected(true);
                    break;
                case "Kì 2":
                    rbKi2.setSelected(true);
                    break;
                case "Kì hè":
                    rbKiHe.setSelected(true);
                    break;
                default:
                    rbTrungGian.setSelected(true);
            }
        }
    }
    //---Khoi tao cho listDanhSachCauHoi
    private void initListDanhSachCauHoi() {
        dsTracNghiemMonHoc.stream().forEach((i) -> {
            listDanhSachCauHoiModel.addElement(i.getDeBai());
        });
        dsTuLuanMonHoc.stream().forEach((i) -> {
            listDanhSachCauHoiModel.addElement(i.getDeBai());
        });
        listDanhSachCauHoi.setModel(listDanhSachCauHoiModel);
    }

    //Doc du lieu tu file luu vao DsTracNghiem
    private void readDsTracNghiem() {
        this.dsTracNghiemMonHoc = IOFileBinary.readFile("data//TracNghiem" + monHocDangChon.getMaHocPhan() + ".dat");
        this.dsCauHoiMonHoc.addAll(this.dsTracNghiemMonHoc);
    }

    //Doc du lieu tu file luu vao DsTuLuan  
    private void readDsTuLuan() {
        this.dsTuLuanMonHoc = IOFileBinary.readFile("data//TuLuan" + monHocDangChon.getMaHocPhan() + ".dat");
        this.dsCauHoiMonHoc.addAll(this.dsTuLuanMonHoc);
    }

    private StringBuffer inTenDethi() {
        StringBuffer tenDeThi =  new StringBuffer("Đề thi ");
        tenDeThi.append(monHocDangChon.getMaHocPhan().toUpperCase()).append("-");
        tenDeThi.append(deThi.getKiHoc()).append("-").append(deThi.getNamHoc());
        return tenDeThi;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDanhSachCauHoi = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taCauHoi = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfDiem = new javax.swing.JTextField();
        bThemVaoDeThi = new javax.swing.JButton();
        cbDangCauHoi = new javax.swing.JComboBox<>();
        cbDoKho = new javax.swing.JComboBox<>();
        cbChuong = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listDsCauHoiDeThi = new javax.swing.JList<>();
        bUp = new javax.swing.JButton();
        bDown = new javax.swing.JButton();
        lbXoaCauHoi = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfTenDeThi = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        taDeThi = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfThoiGian = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfNamHoc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rbKi1 = new javax.swing.JRadioButton();
        rbKi2 = new javax.swing.JRadioButton();
        rbKiHe = new javax.swing.JRadioButton();
        lbXaoTronCauHoi = new javax.swing.JLabel();
        lbIn = new javax.swing.JLabel();
        lbWord = new javax.swing.JLabel();
        bLuuDeThi = new javax.swing.JButton();
        bXoaDeThi = new javax.swing.JButton();
        bChonNgauNhien = new javax.swing.JButton();
        lbTronDapAn = new javax.swing.JLabel();
        rbTrungGian = new javax.swing.JRadioButton();
        lbPDF = new javax.swing.JLabel();

        jScrollPane5.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chọn câu hỏi");

        listDanhSachCauHoi.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        listDanhSachCauHoi.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDanhSachCauHoiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listDanhSachCauHoi);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Search");

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        taCauHoi.setEditable(false);
        taCauHoi.setColumns(20);
        taCauHoi.setLineWrap(true);
        taCauHoi.setRows(5);
        taCauHoi.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taCauHoi);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setText("Danh sách câu hỏi");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Điểm");

        tfDiem.setText("0");

        bThemVaoDeThi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bThemVaoDeThi.setText("Thêm vào đề thi");
        bThemVaoDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemVaoDeThiActionPerformed(evt);
            }
        });

        cbDangCauHoi.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbDangCauHoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dạng câu hỏi", "Tất cả", "Trắc nghiệm", "Tự luận" }));
        cbDangCauHoi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDangCauHoiItemStateChanged(evt);
            }
        });

        cbDoKho.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbDoKho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Độ khó", "Tất cả", "Dễ", "Trung bình", "Khó" }));
        cbDoKho.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDoKhoItemStateChanged(evt);
            }
        });

        cbChuong.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbChuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chương", "Tất cả" }));
        cbChuong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbChuongItemStateChanged(evt);
            }
        });

        jLabel4.setText("Danh sách các câu trong đề");

        listDsCauHoiDeThi.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        listDsCauHoiDeThi.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDsCauHoiDeThiValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listDsCauHoiDeThi);

        bUp.setText("^");
        bUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpActionPerformed(evt);
            }
        });

        bDown.setText("v");
        bDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDownActionPerformed(evt);
            }
        });

        lbXoaCauHoi.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbXoaCauHoi.setForeground(new java.awt.Color(255, 0, 0));
        lbXoaCauHoi.setText("Xóa câu hỏi");
        lbXoaCauHoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbXoaCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbXoaCauHoiMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Tên đề thi");

        tfTenDeThi.setAutoscrolls(false);

        taDeThi.setColumns(20);
        taDeThi.setRows(5);
        taDeThi.setWrapStyleWord(true);
        jScrollPane4.setViewportView(taDeThi);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Thông tin về đề thi");

        jLabel8.setText("Thời gian");

        tfThoiGian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfThoiGianKeyReleased(evt);
            }
        });

        jLabel9.setText("phút");

        jLabel10.setText("Năm học");

        tfNamHoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNamHocKeyReleased(evt);
            }
        });

        jLabel11.setText("Kì học");

        buttonGroup1.add(rbKi1);
        rbKi1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        rbKi1.setText("1");
        rbKi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKi1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbKi2);
        rbKi2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        rbKi2.setText("2");
        rbKi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKi2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbKiHe);
        rbKiHe.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        rbKiHe.setText("Kì hè");
        rbKiHe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKiHeActionPerformed(evt);
            }
        });

        lbXaoTronCauHoi.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbXaoTronCauHoi.setText("Xáo trộn các câu hỏi");
        lbXaoTronCauHoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbXaoTronCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbXaoTronCauHoiMouseClicked(evt);
            }
        });

        lbIn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbIn.setText("In");
        lbIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbInMouseClicked(evt);
            }
        });

        lbWord.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbWord.setForeground(new java.awt.Color(0, 0, 255));
        lbWord.setText("Xuất ra file Word");
        lbWord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbWord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbWordMouseClicked(evt);
            }
        });

        bLuuDeThi.setBackground(new java.awt.Color(0, 0, 255));
        bLuuDeThi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bLuuDeThi.setForeground(new java.awt.Color(255, 255, 255));
        bLuuDeThi.setText("Lưu đề thi");
        bLuuDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLuuDeThiActionPerformed(evt);
            }
        });

        bXoaDeThi.setBackground(new java.awt.Color(255, 0, 0));
        bXoaDeThi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bXoaDeThi.setForeground(new java.awt.Color(255, 255, 255));
        bXoaDeThi.setText("Xóa đề thi");
        bXoaDeThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoaDeThiActionPerformed(evt);
            }
        });

        bChonNgauNhien.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        bChonNgauNhien.setText("Chọn ngẫu nhiên");
        bChonNgauNhien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChonNgauNhienActionPerformed(evt);
            }
        });

        lbTronDapAn.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbTronDapAn.setForeground(new java.awt.Color(0, 0, 255));
        lbTronDapAn.setText("Trộn đáp án");
        lbTronDapAn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTronDapAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTronDapAnMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbTrungGian);
        rbTrungGian.setEnabled(false);

        lbPDF.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbPDF.setForeground(new java.awt.Color(0, 0, 255));
        lbPDF.setText("Xuất ra file PDF");
        lbPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPDFMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rbKi1)
                                    .addGap(35, 35, 35)
                                    .addComponent(rbKi2))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 116, Short.MAX_VALUE)
                                            .addComponent(jLabel9))
                                        .addComponent(tfNamHoc))
                                    .addGap(91, 91, 91))))
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bChonNgauNhien)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbDangCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbDoKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbChuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbXoaCauHoi, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bUp)
                                .addComponent(bDown)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTronDapAn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rbKiHe)
                            .addGap(18, 18, 18)
                            .addComponent(rbTrungGian))
                        .addComponent(bLuuDeThi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tfTenDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane4)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bThemVaoDeThi))
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbXaoTronCauHoi)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbIn)
                                    .addGap(27, 27, 27))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(bXoaDeThi)
                                    .addGap(147, 147, 147)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbPDF)
                                .addComponent(lbWord)))))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDangCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDoKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbChuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(bChonNgauNhien))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bThemVaoDeThi))))
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfTenDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(bUp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bDown))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbXoaCauHoi)
                                    .addComponent(lbTronDapAn))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(tfThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(tfNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbXaoTronCauHoi)
                            .addComponent(lbIn)
                            .addComponent(lbWord)
                            .addComponent(jLabel11)
                            .addComponent(rbKi1)
                            .addComponent(rbKi2)
                            .addComponent(rbKiHe))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPDF)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bLuuDeThi)
                            .addComponent(bXoaDeThi)))
                    .addComponent(rbTrungGian))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        this.filterQuestion();
    }//GEN-LAST:event_tfSearchKeyReleased
    
    private void filterQuestion() {
        //---Loc theo dang cau hoi
        ArrayList <CauHoi> filtered1 = null;
        String dangCauHoi = (String) cbDangCauHoi.getSelectedItem();
        switch (dangCauHoi) {
            case "Trắc nghiệm":
                filtered1 = new ArrayList();
                for ( CauHoi i : this.dsTracNghiemMonHoc) {                
                    filtered1.add(i);
                }   break;
            case "Tự luận":
                filtered1 = new ArrayList();
                for ( CauHoi i : this.dsTuLuanMonHoc) {
                    filtered1.add(i);
                }   break;
            default:
                filtered1 = this.dsCauHoiMonHoc;
                break;
        }
        //---Loc tiep theo do kho
        ArrayList <CauHoi> filtered2 = null;
        String doKho = (String) cbDoKho.getSelectedItem();
        if (!doKho.equals("Độ khó") && !doKho.equals("Tất cả")) {
            filtered2 = new ArrayList();
            for (CauHoi i : filtered1) {
                if (i.getDoKho().equals(doKho)) {
                    filtered2.add(i);
                }
            }
        } else {
            filtered2 = filtered1;
        }
                
        //---Loc tiep theo chuong
        ArrayList <CauHoi> filtered3 = null;
        String chuong = (String) cbChuong.getSelectedItem();
        if ( !chuong.equals("Chương") && !chuong.equals("Tất cả")) {
            filtered3 = new ArrayList();
            for ( CauHoi i : filtered2) {
                for ( Integer j : i.getDsChuong()) {
                    if ( chuong.equals("Chương " + j.toString())) {
                        filtered3.add(i);
                    }
                }
            }
        } else {
            filtered3 = filtered2;
        }
        //---Loc tiep theo tu khoa Search
        if ( !tfSearch.getText().equals("")) {
            String searchingWord = tfSearch.getText().toLowerCase();
            this.dsCauHoiDaLoc = new ArrayList();
            for (CauHoi i : filtered3) {
                if (i.getDeBai().toLowerCase().contains(searchingWord)) {
                    this.dsCauHoiDaLoc.add(i);
                }
            }
        } else {
            this.dsCauHoiDaLoc = filtered3;
        }
        //---Hien thi danh sach da loc tren listDanhSachCauHoi
        this.listDanhSachCauHoiModel = new DefaultListModel();
        for ( CauHoi i : this.dsCauHoiDaLoc) {
            this.listDanhSachCauHoiModel.addElement(i.getDeBai());                    
        }
        this.listDanhSachCauHoi.setModel(this.listDanhSachCauHoiModel);
        //---Mac dinh chon cau hoi dau tien trong DanhSachCauHoiDaLoc
        if ( !this.dsCauHoiDaLoc.isEmpty()) {
            this.listDanhSachCauHoi.setSelectedIndex(0);
            CauHoi cauHoiDangChon = dsCauHoiDaLoc.get(listDanhSachCauHoi.getSelectedIndex());
            taCauHoi.setText(cauHoiDangChon.inCauHoi().toString());
            this.tfDiem.setText(Float.toString(cauHoiDangChon.getDiem()));
        }
    }
    private void cbChuongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbChuongItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.filterQuestion();
        }
    }//GEN-LAST:event_cbChuongItemStateChanged

    private void cbDangCauHoiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDangCauHoiItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.filterQuestion();
        }
    }//GEN-LAST:event_cbDangCauHoiItemStateChanged

    private void cbDoKhoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDoKhoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.filterQuestion();
        }
    }//GEN-LAST:event_cbDoKhoItemStateChanged

    private void listDanhSachCauHoiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDanhSachCauHoiValueChanged
        // Bat su kien select, bo qua su kien deselect
        if (evt.getValueIsAdjusting()) {
            //---Hien thi thong tin cau hoi tren taCauHoi
            CauHoi cauHoiDangChon = dsCauHoiDaLoc.get(listDanhSachCauHoi.getSelectedIndex());
            taCauHoi.setText(cauHoiDangChon.inCauHoi().toString());
            this.tfDiem.setText(Float.toString(cauHoiDangChon.getDiem()));
        }
    }//GEN-LAST:event_listDanhSachCauHoiValueChanged

    private void bChonNgauNhienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChonNgauNhienActionPerformed
        Random rd = new Random();
        int size = this.dsCauHoiDaLoc.size();
        if ( size > 0) {
            int index = rd.nextInt(size);
            CauHoi cauHoiNgauNhien = this.dsCauHoiDaLoc.get(index);
            //---Chon cau hoi ngau nhien tren listDanhSachCauHoi va thong tin cau hoi do
            this.listDanhSachCauHoi.setSelectedIndex(index);
            taCauHoi.setText(cauHoiNgauNhien.inCauHoi().toString());
            tfDiem.setText(Float.toString(cauHoiNgauNhien.getDiem()));
        }
    }//GEN-LAST:event_bChonNgauNhienActionPerformed

    private void bThemVaoDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemVaoDeThiActionPerformed
        if (!this.dsCauHoiDaLoc.isEmpty()) {
            CauHoi cauHoiDangChon = this.dsCauHoiDaLoc.get(this.listDanhSachCauHoi.getSelectedIndex());
            //---Kiem tra cau hoi da co trong de thi chua
            if (chucNang == 1) {
                for (CauHoi i : this.deThi.getDsCauHoi()) {
                    if (i.getDeBai().equals(cauHoiDangChon.getDeBai())) {
                        JOptionPane.showMessageDialog(null, "Câu hỏi đã có trong đề thi");
                        return;
                    }
                }
            } else if ( chucNang ==2) {
                for (CauHoi i : this.deThi.getDsCauHoi()) {
                    if (i == cauHoiDangChon) {
                        JOptionPane.showMessageDialog(null, "Câu hỏi đã có trong đề thi");
                        return;
                    }
                }
            }
            //---Kiem tra diem cua cau hoi cao thoa man khong, neu co thi set diem cua cau hoi
            try {
                cauHoiDangChon.setDiem(Float.parseFloat(tfDiem.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Điểm của câu hỏi phải là số không âm");
                return;
            }
            
            //---Them vao cac thuoc tinh cua de thi
            
            if (cauHoiDangChon instanceof TracNghiem) {
                this.deThi.themTracNghiem((TracNghiem) cauHoiDangChon);
            } else {
                this.deThi.themTuLuan((TuLuan) cauHoiDangChon);
            }
                        

            this.listDsCauHoiDeThiModel.addElement(cauHoiDangChon.getDeBai());
            this.listDsCauHoiDeThi.setModel(this.listDsCauHoiDeThiModel);
            this.taDeThi.setText(this.deThi.inDeThi().toString());
        } else {
            JOptionPane.showMessageDialog(null, "Chưa có câu hỏi nào được chọn");
        }
    }//GEN-LAST:event_bThemVaoDeThiActionPerformed

    private void tfThoiGianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfThoiGianKeyReleased
        this.deThi.setThoiGian(tfThoiGian.getText());
        tfTenDeThi.setText(this.inTenDethi().toString());
        taDeThi.setText(this.deThi.inDeThi().toString());
    }//GEN-LAST:event_tfThoiGianKeyReleased

    private void tfNamHocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNamHocKeyReleased
        this.deThi.setNamHoc(tfNamHoc.getText());
        tfTenDeThi.setText(this.inTenDethi().toString());
        taDeThi.setText(this.deThi.inDeThi().toString());
    }//GEN-LAST:event_tfNamHocKeyReleased

    private void rbKi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKi1ActionPerformed
        this.deThi.setKiHoc("Kì 1");
        tfTenDeThi.setText(this.inTenDethi().toString());
        taDeThi.setText(this.deThi.inDeThi().toString());
    }//GEN-LAST:event_rbKi1ActionPerformed

    private void rbKi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKi2ActionPerformed
        this.deThi.setKiHoc("Kì 2");
        tfTenDeThi.setText(this.inTenDethi().toString());
        taDeThi.setText(this.deThi.inDeThi().toString());
    }//GEN-LAST:event_rbKi2ActionPerformed

    private void rbKiHeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKiHeActionPerformed
        this.deThi.setKiHoc("Kì hè");
        tfTenDeThi.setText(this.inTenDethi().toString());
        taDeThi.setText(this.deThi.inDeThi().toString());
    }//GEN-LAST:event_rbKiHeActionPerformed

    private void bXoaDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaDeThiActionPerformed
        
        if ( chucNang ==1) { //Neu mo de thi thi xoa file de thi do
            int choose = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa: " + tfTenDeThi.getText(), "Hãy lựa chọn", JOptionPane.YES_NO_OPTION);
            if ( choose == JOptionPane.YES_OPTION) {
                try {
                    Path path = Paths.get("data/dethi/" +tfTenDeThi.getText() + ".dat");
                    Files.delete(path);
                } catch (IOException ex) {
                    System.out.println("File không tồn tại!");
                }
            }
            this.setVisible(false);
            this.dispose();
        } else if (chucNang ==2) { //Neu tao de thi moi thi reset toan bo de nhap de thi moi
            this.deThi = new DeThi(this.monHocDangChon);

            this.listDsCauHoiDeThiModel = new DefaultListModel();
            this.listDsCauHoiDeThi.setModel(this.listDsCauHoiDeThiModel);

            //---Set lai thong tin co ban cua de thi
            tfThoiGian.setText("");
            tfNamHoc.setText("");
            rbTrungGian.setSelected(true);

            tfTenDeThi.setText(this.inTenDethi().toString());
            taDeThi.setText(this.deThi.inDeThi().toString());
        }
    }//GEN-LAST:event_bXoaDeThiActionPerformed

    private void lbXoaCauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbXoaCauHoiMouseClicked
        try {
            int index = this.listDsCauHoiDeThi.getSelectedIndex();
            CauHoi cauHoiDangChon = this.deThi.getDsCauHoi().get(index);
            //----------------------
            this.deThi.getDsCauHoi().remove(cauHoiDangChon);
            if ( cauHoiDangChon instanceof TracNghiem ) {
                this.deThi.xoaTracNghiem((TracNghiem) cauHoiDangChon);
            } else {
                this.deThi.xoaTuLuan((TuLuan) cauHoiDangChon);
            }
            taDeThi.setText(this.deThi.inDeThi().toString());
            this.listDsCauHoiDeThiModel.remove(index);
            this.listDsCauHoiDeThi.setModel(this.listDsCauHoiDeThiModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hãy chọn câu hỏi cần xóa khỏi đề thi");
        }
    }//GEN-LAST:event_lbXoaCauHoiMouseClicked

    private void lbTronDapAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTronDapAnMouseClicked
        int index = this.listDsCauHoiDeThi.getSelectedIndex();
        CauHoi cauHoiDangChon = this.deThi.getDsCauHoi().get(index);
        Collections.shuffle(((TracNghiem) cauHoiDangChon).getDsDapAn());
        //---In lai de thi
        taDeThi.setText(this.deThi.inDeThi().toString());
        
    }//GEN-LAST:event_lbTronDapAnMouseClicked

    private void bUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpActionPerformed
        try {
            int index = this.listDsCauHoiDeThi.getSelectedIndex();
            CauHoi cauHoiDangChon = this.deThi.getDsCauHoi().get(index);
            if ( index - 1 >= 0) {
                CauHoi tempCauHoi = this.deThi.getDsCauHoi().get(index-1);
                this.deThi.getDsCauHoi().set(index-1, cauHoiDangChon);
                this.listDsCauHoiDeThiModel.set(index-1, cauHoiDangChon.getDeBai());

                this.deThi.getDsCauHoi().set(index, tempCauHoi);
                this.listDsCauHoiDeThiModel.set(index, tempCauHoi.getDeBai());

                this.listDsCauHoiDeThi.setModel(this.listDsCauHoiDeThiModel);
                this.listDsCauHoiDeThi.setSelectedIndex(index - 1);
                //---In lai de thi
                taDeThi.setText(this.deThi.inDeThi().toString());
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_bUpActionPerformed

    private void bDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDownActionPerformed
        try {
            int index = this.listDsCauHoiDeThi.getSelectedIndex();
            CauHoi cauHoiDangChon = this.deThi.getDsCauHoi().get(index);
            int size =  this.deThi.getDsCauHoi().size();
            if ( index + 1 < size) {
                CauHoi tempCauHoi = this.deThi.getDsCauHoi().get(index+1);
                this.deThi.getDsCauHoi().set(index+1, cauHoiDangChon);
                this.listDsCauHoiDeThiModel.set(index+1, cauHoiDangChon.getDeBai());

                this.deThi.getDsCauHoi().set(index, tempCauHoi);
                this.listDsCauHoiDeThiModel.set(index, tempCauHoi.getDeBai());

                this.listDsCauHoiDeThi.setModel(this.listDsCauHoiDeThiModel);
                this.listDsCauHoiDeThi.setSelectedIndex(index + 1);
                //---In lai de thi
                taDeThi.setText(this.deThi.inDeThi().toString());
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_bDownActionPerformed

    private void listDsCauHoiDeThiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDsCauHoiDeThiValueChanged
        try {
            CauHoi cauHoiDangChon = this.deThi.getDsCauHoi().get(this.listDsCauHoiDeThi.getSelectedIndex());
            if ( cauHoiDangChon instanceof TracNghiem) {
                this.lbTronDapAn.setVisible(true);
            } else {
                this.lbTronDapAn.setVisible(false);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_listDsCauHoiDeThiValueChanged

    private void lbXaoTronCauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbXaoTronCauHoiMouseClicked
        Collections.shuffle(deThi.getDsCauHoi());
        //---In lai DanhSachCauHoiDeThi va taDeThi
        this.listDsCauHoiDeThiModel = new DefaultListModel();
        for ( CauHoi i : this.deThi.getDsCauHoi()) {
            this.listDsCauHoiDeThiModel.addElement(i.getDeBai());
        }
        this.listDsCauHoiDeThi.setModel(this.listDsCauHoiDeThiModel);
        
        taDeThi.setText(this.deThi.inDeThi().toString());
    }//GEN-LAST:event_lbXaoTronCauHoiMouseClicked
    //Ghi De thi moi tao ra file
    private boolean writeDeThi() {
        return IOFileBinary.writeFile(this.deThi, "data/dethi/" + tfTenDeThi.getText() + ".dat");
    }
    private void bLuuDeThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLuuDeThiActionPerformed
        if ( tfTenDeThi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Hãy đặt tên đề thi");
        } else {
            deThi.setTenDeThi(tfTenDeThi.getText());
            if (writeDeThi()) {
                JOptionPane.showMessageDialog(null, "Lưu đề thi thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Tên đề thi đã tồn tại. Hãy đặt lại tên đề thi");
            }
        }
                
        
    }//GEN-LAST:event_bLuuDeThiActionPerformed

    private void lbInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbInMouseClicked
        JOptionPane.showMessageDialog(null, "Không tìm thấy kết nối với máy in");
    }//GEN-LAST:event_lbInMouseClicked

    private void lbWordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbWordMouseClicked
        JFileChooser fChooser = new JFileChooser();
        
        File dir = new File("data/dethi");
        fChooser.setCurrentDirectory(dir);
        FileFilter filter = new FileNameExtensionFilter("Save", "docx");
        fChooser.setFileFilter(filter);
        
        int choose = fChooser.showSaveDialog(this);
        if (choose == JFileChooser.APPROVE_OPTION) {//Danh dau ban da chap nhan SAVE
            if ( IOFileWord.writeWord(taDeThi.getText(), fChooser.getSelectedFile() +".docx") ) {
                JOptionPane.showMessageDialog(null, "Xuất ra file Word thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Không thể ghi ra file vì file đang mở. Hãy đóng file và tiếp tục", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_lbWordMouseClicked

    private void lbPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPDFMouseClicked
        JFileChooser fChooser = new JFileChooser();
        
        File dir = new File("data/dethi");
        fChooser.setCurrentDirectory(dir);
        FileFilter filter = new FileNameExtensionFilter("Save", "pdf");
        fChooser.setFileFilter(filter);
        
        int choose = fChooser.showSaveDialog(this);
        if (choose == JFileChooser.APPROVE_OPTION) {

            //Danh dau ban da chap nhan SAVE
            if (IOFilePDF.writePDF(taDeThi.getText(), fChooser.getSelectedFile() + ".pdf")) {
                JOptionPane.showMessageDialog(null, "Xuất ra file PDF thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Không thể ghi ra file vì file đang mở. Hãy đóng file và tiếp tục", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_lbPDFMouseClicked

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
            java.util.logging.Logger.getLogger(ChonCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChonCauHoi().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bChonNgauNhien;
    private javax.swing.JButton bDown;
    private javax.swing.JButton bLuuDeThi;
    private javax.swing.JButton bThemVaoDeThi;
    private javax.swing.JButton bUp;
    private javax.swing.JButton bXoaDeThi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbChuong;
    private javax.swing.JComboBox<String> cbDangCauHoi;
    private javax.swing.JComboBox<String> cbDoKho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbIn;
    private javax.swing.JLabel lbPDF;
    private javax.swing.JLabel lbTronDapAn;
    private javax.swing.JLabel lbWord;
    private javax.swing.JLabel lbXaoTronCauHoi;
    private javax.swing.JLabel lbXoaCauHoi;
    private javax.swing.JList<String> listDanhSachCauHoi;
    private javax.swing.JList<String> listDsCauHoiDeThi;
    private javax.swing.JRadioButton rbKi1;
    private javax.swing.JRadioButton rbKi2;
    private javax.swing.JRadioButton rbKiHe;
    private javax.swing.JRadioButton rbTrungGian;
    private javax.swing.JTextArea taCauHoi;
    private javax.swing.JTextArea taDeThi;
    private javax.swing.JTextField tfDiem;
    private javax.swing.JTextField tfNamHoc;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfTenDeThi;
    private javax.swing.JTextField tfThoiGian;
    // End of variables declaration//GEN-END:variables
}
