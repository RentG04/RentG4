package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.BD;

@WebServlet(name = "LoginUsuario", urlPatterns = {"/LoginUsuario"})
public class LoginUsuario extends HttpServlet {
    
    private Connection con;
    
    @Override
    public void init(ServletConfig cfg) throws ServletException {
        con = BD.getConexion();
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        String correo = req.getParameter("Usuario");
        String contra = req.getParameter("Contraseña");
        
        try{
            PreparedStatement ps = con.prepareStatement("select * from clientes where email=? and password=? ;") ;
            ps.setString(1, correo);
            ps.setString(2, contra);
            
            ResultSet rs =ps.executeQuery();
            
            if(rs.next()){
                //Login correcto  
                RequestDispatcher rds = req.getRequestDispatcher("index.jsp");
                rds.include(req, res);
            }
            else{
                //Login incorrecto
                req.setAttribute("errorlogin", "no user or password");
                RequestDispatcher rds = req.getRequestDispatcher("login.jsp");
                rds.include(req, res);
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
