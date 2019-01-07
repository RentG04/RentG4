/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.BD;

/**
 *
 * @author unigo
 */
public class ReservaCoche extends HttpServlet {

    private Connection con;
    private Statement set;
    private ResultSet rs;
    String cad;

    @Override
    public void init(ServletConfig cfg) throws ServletException {
        con = BD.getConexion();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        HttpSession s = req.getSession(true);
        if(s.getAttribute("usr") == null){
            req.getRequestDispatcher("login.jsp").forward(req, res);
        }else{
            bean.Reserva r = new bean.Reserva();
            String matricula = (String) req.getParameter("coche");
            System.out.println("matricula: " + matricula);
            bean.Usuario usr = (bean.Usuario)(s.getAttribute("usr"));
            
            String email = usr.getEmail();
            bean.Busqueda b = (bean.Busqueda)s.getAttribute("Busqueda");
            
            r.setEmail(email);
            r.setMatricula(matricula);
            int precioDia=20;
            try{
                PreparedStatement ps1 = con.prepareStatement("SELECT preciodia FROM coches WHERE matricula=?");
                ps1.setString(1, matricula);
                ResultSet rs1 = ps1.executeQuery();
                if(rs1.next()){
                    precioDia = rs1.getInt("preciodia");
                }
            }catch(Exception e){}
            r.setFechaInicio(b.getFechaRecogida());
            r.setFechaFin(b.getFechaDevolucion());
            //r.setExtras("");//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            r.calcularPrecio(precioDia);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            System.out.println("PRECIO  ------------>"+r.getPrecio());
            try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO reservas(email, matricula, fechaIni, fechaFin, precio, extras, estado) values (?,?,?,?,?,?,?);");
            ps.setString(1, r.getEmail());
            ps.setString(2, r.getMatricula());
            ps.setString(3, r.getFechaInicio());
            ps.setString(4, r.getFechaFin());
            ps.setFloat(5, Float.parseFloat(r.getPrecio()));//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            ps.setFloat(6, 0.0f);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            ps.setString(7, "Reservado");
            
            ps.executeUpdate();
            
            }catch(Exception e){
                e.printStackTrace();
            }
            req.getRequestDispatcher("miReserva.jsp").forward(req, res);
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
