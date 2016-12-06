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
public abstract class CauHoi implements Serializable {
    private MonHoc monHoc;
    private String deBai;
    private String doKho;
    private ArrayList<Integer> dsChuong;
    private float diem;
    
    //-------------------------------
    public CauHoi() {
        this.deBai = "";
        this.doKho = "Dễ";
        dsChuong = new ArrayList();
    }

    public CauHoi(MonHoc monHoc, String deBai, String doKho, ArrayList<Integer> dsChuong, float diem) {
        this.monHoc = monHoc;
        this.deBai = deBai;
        this.doKho = doKho;
        this.dsChuong = dsChuong;
        this.diem = diem;
    }
    
    

    //-------------------------------
    public MonHoc getMonHoc() {
        return monHoc;
    }
    
    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public String getDeBai() {
        return deBai;
    }

    public void setDeBai(String deBai) {
        this.deBai = deBai;
    }

    public String getDoKho() {
        return doKho;
    }

    public void setDoKho(String doKho) {
        this.doKho = doKho;
    }

    public ArrayList<Integer> getDsChuong() {
        return dsChuong;
    }

    public void setDsChuong(ArrayList<Integer> dsChuong) {
        this.dsChuong = dsChuong;
    }   

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
   
    public abstract StringBuffer inCauHoi();
    public abstract StringBuffer inDeThi();
}
