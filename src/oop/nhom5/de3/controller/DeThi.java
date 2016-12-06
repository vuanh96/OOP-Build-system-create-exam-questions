
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.controller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author KING
 */
public class DeThi implements Serializable{
    private String tenDeThi;
    private MonHoc monHoc;
    private String namHoc;
    private String kiHoc;
    private String thoiGian;
    private float tongDiem;
    
    private ArrayList <CauHoi> dsCauHoi;
    private ArrayList <TracNghiem> dsTracNghiem;
    private ArrayList <TuLuan> dsTuLuan;
    
    //-------------------------------
    public DeThi(MonHoc monHoc) {
        this.tenDeThi = "UNKNOW";
        this.monHoc = monHoc;
        this.namHoc = "UNKNOW";
        this.kiHoc = "Kì 0";
        this.thoiGian = "00";
        this.tongDiem = 0;
        dsCauHoi = new ArrayList();
        dsTracNghiem = new ArrayList();
        dsTuLuan = new ArrayList();
    }
    
    public String getTenDeThi() {
        return tenDeThi;
    }

    //-------------------------------
    public void setTenDeThi(String tenDeThi) {
        this.tenDeThi = tenDeThi;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(String kiHoc) {
        this.kiHoc = kiHoc;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public float getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(float tongDiem) {
        this.tongDiem = tongDiem;
    }

    public ArrayList<CauHoi> getDsCauHoi() {
        return dsCauHoi;
    }

    public void setDsCauHoi(ArrayList<CauHoi> dsCauHoi) {
        this.dsCauHoi = dsCauHoi;
    }

    public ArrayList<TracNghiem> getDsTracNghiem() {
        return dsTracNghiem;
    }

    public void setDsTracNghiem(ArrayList<TracNghiem> dsTracNghiem) {
        this.dsTracNghiem = dsTracNghiem;
    }

    public ArrayList<TuLuan> getDsTuLuan() {
        return dsTuLuan;
    }

    public void setDsTuLuan(ArrayList<TuLuan> dsTuLuan) {
        this.dsTuLuan = dsTuLuan;
    }
    
    //-------------------------------
    public void themTracNghiem(TracNghiem tracNghiem) {
        dsTracNghiem.add(tracNghiem);
        dsCauHoi.add(tracNghiem);
        tongDiem += tracNghiem.getDiem();
    }
    public void xoaTracNghiem(TracNghiem tracNghiem) {
        dsTracNghiem.remove(tracNghiem);
        dsCauHoi.remove(tracNghiem);
        tongDiem -= tracNghiem.getDiem();
    }
    public void themTuLuan(TuLuan tuLuan) {
        dsTuLuan.add(tuLuan);
        dsCauHoi.add(tuLuan);
        tongDiem += tuLuan.getDiem();
    }
    public void xoaTuLuan(TuLuan tuLuan) {
        dsTuLuan.remove(tuLuan);
        dsCauHoi.remove(tuLuan);
        tongDiem -= tuLuan.getDiem();
    }
    public StringBuffer inDeThi() {
        //in tieu de bai thi
        StringBuffer deThi = new StringBuffer("");
        deThi.append("BÀI THI MÔN: " ).append(monHoc.getTenMonHoc().toUpperCase()).append(" - ").append(monHoc.getMaHocPhan().toUpperCase()).append("\n");
        deThi.append(kiHoc).append(" - ").append("Năm học: ").append(namHoc).append("\n");
        deThi.append("Thời gian: ").append(thoiGian).append(" phút").append("\n\n");
        
        //in noi dung cac cau hoi
        for (int i=0; i < dsCauHoi.size(); i++) {
            deThi.append("Câu ").append(i+1).append( "(").append(dsCauHoi.get(i).getDiem()).append(" điểm) :");
            deThi.append(dsCauHoi.get(i).inDeThi());            
        }
        deThi.append("Tổng điểm: ").append(tongDiem);
        return deThi;
    }
}
