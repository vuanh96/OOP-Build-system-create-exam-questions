/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.model;

//import com.itextpdf.io.font.PdfEncodings;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.geom.PageSize;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.property.TextAlignment;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KING
 */
public class IOFilePDF {

    public static boolean writePDF(String text, String fileName) {
        try {
            // create a new document
            Document document = new Document();
            Font font = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            PdfWriter.getInstance(document, new FileOutputStream(fileName)  );

            document.open();
            // create lines of text
            String[] lines = text.split("\n");
            //create Paragraph
            for(String line : lines) {
                document.add(new Paragraph(line , font));
            }

            document.close();
            return true;
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(IOFilePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
//    public static boolean writePDF(String text, String fileName){
//        try {
//            // create a new document
//            PdfWriter writer = new PdfWriter(fileName);//Đường dẫn lưu
//            PdfDocument pdf = new PdfDocument(writer);
//            Document document = new Document(pdf, PageSize.A4.rotate());
//            PdfFont hfont = PdfFontFactory.createFont("C:\\Windows\\Fonts\\tahoma.ttf", PdfEncodings.IDENTITY_H,true);
//            // create lines of text
//            String[] lines = text.split("\n");
//            //create Paragraph
//            for(String line : lines) {
//                document.add(new Paragraph(line).setFont(hfont).setTextAlignment(TextAlignment.LEFT).setFontSize(14));
//            }
//            document.close();
//            return true;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException ex) {
//            Logger.getLogger(IOFilePDF.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
}
