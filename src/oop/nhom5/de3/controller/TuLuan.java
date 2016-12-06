/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.controller;

/**
 *
 * @author KING
 */
public class TuLuan extends CauHoi{
    private String baremChamDiem;

    public String getBaremChamDiem() {
        return baremChamDiem;
    }

    public void setBaremChamDiem(String baremChamDiem) {
        this.baremChamDiem = baremChamDiem;
    }

    @Override
    public StringBuffer inCauHoi() {
        StringBuffer content = new StringBuffer("");
        content.append(this.getDeBai()).append("\n");
        content.append("-------------------------------------------\n");
        content.append("Barem chấm điểm: \n").append(this.getBaremChamDiem()).append("\n");
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
        StringBuffer content = new StringBuffer("");
        content.append(this.getDeBai()).append("\n");
        content.append("\n");
        return content;
    }   
}
