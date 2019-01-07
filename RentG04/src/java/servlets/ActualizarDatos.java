/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.Usuario;
import com.mysql.jdbc.Blob;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import utils.ImagenUsuario;

/**
 *
 * @author Iker Lopez
 */
@MultipartConfig(maxFileSize = 16177215)
public class ActualizarDatos extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con = utils.BD.getConexion();
        
        
        String us = (String) request.getParameter("Usuario");
        String contra = (String) request.getParameter("Contrasena");
        String correo = (String) request.getParameter("Email");
        String DNI = (String) request.getParameter("Dni");
        String telefono = (String) request.getParameter("Telefono");
        
        ImagenUsuario foto2 = new ImagenUsuario();
        foto2.setNombreimg(us);
                
        try{
            Part filePart = request.getPart("Archivo");
            if (filePart.getSize() > 0) {
                InputStream is = filePart.getInputStream();
                if(is!=null)
                foto2.setArchivoimg(is);
        }
            PreparedStatement ps = con.prepareStatement("UPDATE clientes set usuario=?, password=?, dni=?, telefono=?, imagen=? WHERE email=?");
            ps.setString(1, us);
            ps.setString(2, contra);
            ps.setString(3, DNI);
            ps.setString(4, telefono);
            ps.setString(5, correo);
            ps.setBlob(6,foto2.getArchivoimg());
            
            ps.executeUpdate();
            
            PreparedStatement ps2 = con.prepareStatement("select imagen from clientes where email=? and password=? ;") ;
            ps2.setString(1, correo);
            ps2.setString(2, contra);
            
            ResultSet rs = ps2.executeQuery();
            
            if(rs.next()){    
            
                foto2.setArchivoimg2((Blob) rs.getBlob("imagen"));
            }
            Usuario usuario = new Usuario();
            usuario.setUsuario(us);
            usuario.setEmail(correo);
            usuario.setContraseña(contra);
            usuario.setDni(DNI);
            usuario.setTelefono(telefono);
            foto2.BlobFile();
            usuario.setFoto(foto2);
            System.out.println(usuario.getFoto().getNombreimg() + "asdkoijnfgiuhasbiofmaewsiofd");
            Thread.sleep(1500);
            
            HttpSession session = request.getSession();
            session.setAttribute("usr", usuario);

            request.getRequestDispatcher("index.jsp").include(request, response); 
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
