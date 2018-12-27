/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Iker Lopez
 */
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
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE clientes set usuario=?, password=?, dni=?, telefono=? WHERE email=?");
            ps.setString(1, us);
            ps.setString(2, contra);
            ps.setString(3, DNI);
            ps.setString(4, telefono);
            ps.setString(5, correo);
            
            ps.executeUpdate();
            HttpSession session = request.getSession();
                
            Usuario usuario = new Usuario();
            usuario.setUsuario(us);
            usuario.setEmail(correo);
            usuario.setContraseña(contra);
            //usuario.setFoto(foto);
            usuario.setDni(DNI);
            usuario.setTelefono(telefono);

            session.setAttribute("usr", usuario);

            request.getRequestDispatcher("index.jsp").include(request, response); 
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
