/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.mysql.jdbc.Blob;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.swing.ImageIcon;
import org.w3c.dom.events.Event;
//import org.apache.tomcat.jni.File;

public class ImagenUsuario {

    /*Todo los atributos*/
    String nombreimg;
    InputStream archivoimg;     //guardar
    Blob archivoimg2;           //leer
    String path = "images/users/";
    File img;

    public ImagenUsuario(){
        
    }

    /*Todo los codigos get*/

    public String getPath(){
        return path;
    }
    public String getNombreimg() {
        return nombreimg;
    }

    public InputStream getArchivoimg() {
        return archivoimg;
    }
    public Blob getArchivoimg2() {
        return archivoimg2;
    }
    public File getImg(){
       
        return img;
    }
     
    /*Todo los codigos set*/

    public void setNombreimg(String nombreimg) {
        
        this.nombreimg = nombreimg;
    }

    public void setArchivoimg(InputStream archivoimg) {
        
        this.archivoimg = archivoimg;
    }
    public void setPath(){
        System.out.print("wwwwwwww "+ img.getName());
        path += img.getName();
        
    }

    public void setArchivoimg2(Blob archivoimg2) {
        
        this.archivoimg2 = archivoimg2;
    }

//    public void setImg(File img){
//        
//        this.img = img;   
//    }
    public void BlobFile(String pth){
        try {
            byte [] b = archivoimg2.getBytes(1,(int) archivoimg2.length());
            //String url = getClass().getClassLoader().getResource("images/users");
            //System.out.println(getClass().getClassLoader().getResource(""));  //file:/C:/Users/WhiteWolf/Documents/NetBeansProjects/2VitoRent/RentG4/RentG04/build/web/WEB-INF/classes/
            //System.out.println(new File("").getAbsolutePath()); //C:\Program Files\Apache Software Foundation\Apache Tomcat 8.0.27\bin
            //System.out.println(getClass().getResource("/images/Coche.jpg")); //file:/C:/Users/WhiteWolf/Documents/NetBeansProjects/2VitoRent/RentG4/RentG04/build/web/WEB-INF/classes/utils/
            //System.out.println(pth); //C:\Users\WhiteWolf\Documents\NetBeansProjects\2VitoRent\RentG4\RentG04\build\web\images/users
            try {
                img = File.createTempFile(nombreimg+"-",".png",new File(pth));
                setPath();
                FileOutputStream fos = new FileOutputStream(img);
                fos.write(b);
                fos.close();
                System.out.println(" imagen en: " + img.getAbsolutePath());
            } catch (IOException ex) {
                Logger.getLogger(ImagenUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImagenUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public String deleteImg(){
        System.out.println("imagen borrada");
        img.deleteOnExit();
        return "";
    }
   
}