/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.controller;

import java.util.ArrayList;


/**
 *
 * @author KING
 */
public class TracNghiem extends CauHoi{
    private ArrayList <DapAn> dsDapAn;
    
    //-------------------------------
    public TracNghiem(){
        super();
        this.dsDapAn = new ArrayList();
    }
    
    //-------------------------------
    public ArrayList<DapAn> getDsDapAn() {
        return dsDapAn;
    }

    public void setDsDapAn(ArrayList<DapAn> dsDapAn) {
        this.dsDapAn = dsDapAn;
    }
    @Override
    public StringBuffer inCauHoi() {
        int count = 64;
        StringBuffer content = new StringBuffer("Câu hỏi: ");
        StringBuffer answer = new StringBuffer("");
        content.append(this.getDeBai()).append("\n");
        for (DapAn dapAn : dsDapAn) {
            count++;
            content.append((char) count).append(". ");
            content.append(dapAn.getNoiDung()).append("\n");
            if (dapAn.isDapAnDung()) answer.append((char) count).append(" ");
        }
        content.append("-------------------------------------------\n");
        content.append("Đáp án: ").append(answer).append("\n");
        content.append("Độ khó: ").append(this.getDoKho()).append("\n");
        content.append("Chương: ");
        this.getDsChuong().stream().forEach((i) -> {
            content.append(i.intValue()).append(" ");
        });
        content.append("\n");
        return content;
    }

    @Override
    public StringBuffer inDeThi() {
        int count = 64;
        StringBuffer content = new StringBuffer("");
        content.append(this.getDeBai()).append("\n");
        for (DapAn dapAn : dsDapAn) {
            count++;
            content.append((char) count).append(". ");
            content.append(dapAn.getNoiDung()).append("\n");
        }
        content.append("\n");
        return content;
    }    
}
