package servlets;

import bean.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.BD;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginUsuario", urlPatterns = {"/LoginUsuario"})
public class LoginUsuario extends HttpServlet {
    
    private Connection con;
    
    @Override
    public void init(ServletConfig cfg) throws ServletException {
        con = BD.getConexion();
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        String correo = (String)req.getParameter("Usuario");
        String contra = (String)req.getParameter("Contrasena");

        try{
            PreparedStatement ps = con.prepareStatement("select * from clientes where email=? and password=? ;") ;
            ps.setString(1, correo);
            ps.setString(2, contra);
            
            ResultSet rs =ps.executeQuery();
            
            if(rs.next()){
                //Login correcto  
                HttpSession session = req.getSession();
                
                Usuario usuario = new Usuario();
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContraseña(rs.getString("password"));
                usuario.setFoto(rs.getString("imagen"));
                
                session.setAttribute("usr", usuario);
                
                req.getRequestDispatcher("index.jsp").include(req, res);
                
            }
            else{
                //Login incorrecto
                req.setAttribute("errorlogin", "usuario o contraseña incorrectos");
                req.getRequestDispatcher("login.jsp").include(req, res);
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
