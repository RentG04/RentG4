/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.Empleado;
import bean.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.BD;

/**
 *
 * @author unigo
 */
public class LoginOficinista extends HttpServlet {
    private Connection con;
    
    @Override
    public void init(ServletConfig cfg) throws ServletException {
        con = BD.getConexion();
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        res.setContentType("text/html;charset=UTF-8");
        String usuario = (String)req.getParameter("Usuario");
        String contra = (String)req.getParameter("Contrasena");

        try{
            PreparedStatement ps = con.prepareStatement("select * from empleados where usuario=? and password=? ;") ;
            ps.setString(1, usuario);
            ps.setString(2, contra);
            
            ResultSet rs =ps.executeQuery();
            
            if(rs.next()){
                //Login correcto  
                HttpSession session = req.getSession();
                
                Empleado em = new Empleado();
                em.setUsuario(rs.getString("usuario"));
                em.setContraseña(rs.getString("password"));
                
                
                session.setAttribute("usr", em);
                
                req.getRequestDispatcher("empleado.jsp").include(req, res);
                
            }
            else{
                //Login incorrecto
                req.setAttribute("errorlogin", "usuario o contraseña incorrectos");
                req.getRequestDispatcher("index.jsp").include(req, res);
            }  
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            doPost(req, res);
        } catch (IOException | ServletException e) {
        }
    }
}
