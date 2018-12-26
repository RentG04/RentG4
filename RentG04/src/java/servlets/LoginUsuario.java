package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
        String correo = req.getParameter("logCorreo");
        String contra = req.getParameter("logContra");
        
        try{
            String query = "select * from clientes where email= '" + correo + "' and password= '" + contra + ";" ;
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next()){
            //El usuario y la contraseña son correctos
            }else{
            //El usuario o la contraseña no son correctos
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
