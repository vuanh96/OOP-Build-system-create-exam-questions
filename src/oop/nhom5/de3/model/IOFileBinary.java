/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.nhom5.de3.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author KING
 */
public class IOFileBinary {

    //Doc du lieu tu file tra ve mang chua du lieu
    public static ArrayList readFile(String fileName) {
        ArrayList data_array = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream inStream = new ObjectInputStream(fis);
            Object obj = null;
            while ((obj = inStream.readObject()) != null) {
                data_array.add(obj);
            }
            inStream.close();
            fis.close();
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Không tìm thấy class!");
        }
        return data_array;
    }
    
    //Ghi mang cac doi tuong ra file
    public static boolean writeFile(ArrayList data_array, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream outStream = new ObjectOutputStream(fos);
            for (Object i : data_array) {
                outStream.writeObject(i);
            }
            outStream.close();
            fos.close();
            return true;
        } catch (IOException o) {
            System.out.println("Error: Không ghi được vào file!");
        }
        return false;
    }
    //Ghi 1 doi tuong ra file, chi ghi neu file chua ton tai
    public static boolean writeFile(Object obj, String fileName) {
        try {
            File f = new File(fileName);
            if (!f.exists()) {
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream outStream = new ObjectOutputStream(fos);
                outStream.writeObject(obj);
                outStream.close();
                fos.close();
                return true;
            }
        } catch (IOException o) {
            System.out.println("Error: Không ghi được vào file!");
        }
        return false;
    }
}
