package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;
import utils.BD;
import utils.ImagenUsuario;
import com.oreilly.servlet.MultipartRequest;

/**
 *
 * @author unigo
 */
@MultipartConfig(maxFileSize = 16177215)
public class RegistroUsuario extends HttpServlet{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
//    String cad;
    
    @Override
    public void init(ServletConfig cfg) throws ServletException {
       con = BD.getConexion();
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        res.setContentType("text/html;charset=UTF-8");
        System.out.print("eeeeeeee");
        
        //MultipartRequest mreq = new MultipartRequest(req, "C:\\Users\\WhiteWolf\\Documents");
        ImagenUsuario foto = new ImagenUsuario();
        
        PrintWriter out = res.getWriter();
        //get username & pass from jsp login
        
        
        String usuario = (String) req.getParameter("Usuario");
        System.out.print(usuario);
        String contra = (String) req.getParameter("Contrasena");
        String correo = (String) req.getParameter("Email");
        String DNI = (String) req.getParameter("Dni");
        String telefono = (String) req.getParameter("telefono");
        foto.setNombreimg(usuario);
        

        try{
            
            Part filePart = req.getPart("Archivo");
            if (filePart.getSize() > 0) {
                InputStream is = filePart.getInputStream();
                if(is!=null)
                foto.setArchivoimg(is);
            } 
            PreparedStatement p = con.prepareStatement("select * from clientes where email=? ;");
            p.setString(1, correo);
            ResultSet rs = p.executeQuery();     
            
            if(rs.next()){
                //El dni ya está en la base de datos
                req.setAttribute("errorregistro", "El email con el que intenta registrarse ya esta en uso");
                req.getRequestDispatcher("registro.jsp").include(req, res);     
            }
            else
            {
                PreparedStatement ps = con.prepareStatement("insert into clientes(DNI, usuario, email, password, telefono, imagen) values (?,?,?,?,?,?) ;" );
                ps.setString(1, DNI);
                ps.setString(2, usuario);
                ps.setString(3, correo);
                ps.setString(4, contra);
                ps.setString(5, telefono);
                ps.setBlob(6,foto.getArchivoimg());
                ps.executeUpdate();
                
                req.getRequestDispatcher("index.jsp").include(req, res);  
            }
            rs.close();
        
        }catch (Exception e){
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
