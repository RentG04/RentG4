package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import utils.BD;
/**
 *
 * @author unigo
 */
public class RegistroUsuario extends HttpServlet{
    private Connection con;
    private Statement st;
    private ResultSet rs;
//    String cad;
    
    @Override
    public void init(ServletConfig cfg) throws ServletException {
       
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        res.setContentType("text/html;charset=UTF-8");
        System.out.println("hola");
        PrintWriter out = res.getWriter();
        //get username & pass from jsp login
        String usuario = (String) req.getParameter("Usuario");
        String contra = (String) req.getParameter("Contrasena");
        String correo = (String) req.getParameter("Email");
        String DNI = (String) req.getParameter("Dni");
//        String foto = req.getParameter("username");
        System.out.println("usuario: "+usuario);
        System.out.println("contraseña: "+contra);
        System.out.println("correo: "+correo);
        System.out.println("Dni: "+DNI);


        
        
        try{
            con = BD.getConexion();
            String query = "select * from clientes where DNI= '" + DNI + "'" + ";" ;
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if(rs.next()){
            //El dni ya está en la base de datos
            System.out.println("El dni ya está en la bd");
            st.close();
            rs.close();
            }
            else
            {
                /*
                String query1 = "insert into clientes(DNI, usuario, email, password) values ('" + DNI + "','" + usuario + "'," + correo + "," + contra + ") ;" ;
                st = con.createStatement();
                st.executeUpdate(query1);
                st.close();
                */
                
                PreparedStatement ps = con.prepareStatement("insert into clientes(DNI, usuario, email, password, imagen) values (?,?,?,?,?) ;" );
                ps.setString(1, DNI);
                ps.setString(2, usuario);
                ps.setString(3, correo);
                ps.setString(4, contra);
                ps.setString(5, "");
                ps.executeUpdate();
                System.out.println("Usuario introducido");
                
                RequestDispatcher rqs = req.getRequestDispatcher("index.jsp");
                rqs.include(req, res);
               
                
            }
            
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
