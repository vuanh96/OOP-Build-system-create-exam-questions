/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.controller;

import java.io.Serializable;

/**
 *
 * @author KING
 */
public class MonHoc implements Serializable{
    private String tenMonHoc;
    private String maHocPhan;
    private int soChuong;
    private String gioiThieu;
    
    //-------------------------------
     public MonHoc(){
        this.tenMonHoc = "";
        this.maHocPhan = "";
        this.soChuong = 1;
        this.gioiThieu = "";
    }
    public MonHoc(String tenMonHoc, String maHocPhan, int soChuong,String gioiThieu){
        this.tenMonHoc = tenMonHoc;
        this.maHocPhan = maHocPhan;
        this.soChuong = soChuong;
        this.gioiThieu = gioiThieu;
    }
    
    //-------------------------------

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public int getSoChuong() {
        return soChuong;
    }

    public void setSoChuong(int soChuong) {
        this.soChuong = soChuong;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }
    
    
}
