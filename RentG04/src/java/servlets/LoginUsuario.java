package servlets;

import bean.Usuario;
import com.mysql.jdbc.Blob;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.BD;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.codec.binary.Base64;
import utils.ImagenUsuario;

@WebServlet(name = "LoginUsuario", urlPatterns = {"/LoginUsuario"})
public class LoginUsuario extends HttpServlet {
    
    private Connection con;
    
    @Override
    public void init(ServletConfig cfg) throws ServletException {
        con = BD.getConexion();
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        res.setContentType("text/html;charset=UTF-8");
        String correo = (String)req.getParameter("Usuario");
        String contra = (String)req.getParameter("Contrasena");

        try{
            PreparedStatement ps = con.prepareStatement("select * from clientes where email=? and password=? ;") ;
            ps.setString(1, correo);
            ps.setString(2, contra);
            
            ResultSet rs =ps.executeQuery();
            
            if(rs.next()){
                //Login correcto  
                Usuario usuario = new Usuario();
                ImagenUsuario foto = new ImagenUsuario();
                
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContraseña(rs.getString("password"));
                usuario.setDni(rs.getString("dni"));
                usuario.setTelefono(rs.getString("telefono"));
                
                foto.setArchivoimg2((Blob) rs.getBlob("imagen"));
//              foto.setArchivoimg(rs.getBinaryStream("imagen"));
                foto.setNombreimg(usuario.getUsuario());
                foto.BlobFile();
                usuario.setFoto(foto);
                Thread.sleep(1500);
                HttpSession session = req.getSession();
                session.setAttribute("usr", usuario);
                req.getRequestDispatcher("index.jsp").include(req, res);              
            }
            else{
                //Login incorrecto
                req.setAttribute("errorlogin", "usuario o contraseña incorrectos");
                req.getRequestDispatcher("login.jsp").include(req, res);
            }  
            rs.close();
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
