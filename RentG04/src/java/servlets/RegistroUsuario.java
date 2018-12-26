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
//    private Statement set;
//    private ResultSet rs;
//    String cad;
    
    @Override
    public void init(ServletConfig cfg) throws ServletException {
        con = BD.getConexion();
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        PrintWriter out = res.getWriter();
        //get username & pass from jsp login
        String usuario = req.getParameter("regUsuario");
        String contra = req.getParameter("regContra");
        String correo = req.getParameter("regCorreo");
        String DNI = req.getParameter("regDNI");
//        String foto = req.getParameter("username");


        RequestDispatcher rd = null;
        
        try{
            String query = "select * from clientes where DNI= '" + DNI + "'" + ";" ;
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next()){
            //El dni ya está en la base de datos
            System.out.println("El dni ya está en la bd");
            }
            else
            {
                System.out.println("Se ha introducido el usuario en la bd");
                String query1 = "insert into clientes(DNI, usuario, email, password) values ('" + DNI + "','" + usuario + "'," + correo + "," + contra + ") ;" ;
                Statement st1 = (Statement) con.createStatement();
                ResultSet rs1 = st1.executeQuery(query1);

                req.getRequestDispatcher("index.jsp").forward(req, res);
//        res.sendRedirect("/index.jsp");
                
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
