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
public class DapAn implements Serializable{
    private String noiDung;
    private boolean dapAnDung;
    
    //-------------------------------    
    public DapAn() {
        this.noiDung = "";
        this.dapAnDung = false;
    }

    public DapAn(String noiDung, boolean dapAnDung) {
        this.noiDung = noiDung;
        this.dapAnDung = dapAnDung;
    }
    
    //-------------------------------
    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public boolean isDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(boolean dapAnDung) {
        this.dapAnDung = dapAnDung;
    }   
        
}
