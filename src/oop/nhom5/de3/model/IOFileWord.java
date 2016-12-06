/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.model;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author KING
 */
public class IOFileWord {
    public static boolean writeWord(String text,String fileName) {
        //Blank Document
        XWPFDocument document = new XWPFDocument();
        //Write the Document in file system
        try {
            FileOutputStream out = new FileOutputStream(new File(fileName));
            String[] lines = text.split("\n");
            //create Paragraph
            for(String line : lines) {
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();
                run.setText(line);
            }
            
            document.write(out);
            out.close();
            return true;
        } catch (IOException | HeadlessException e) {
            e.printStackTrace();
        }
        return false;
    }    
}
