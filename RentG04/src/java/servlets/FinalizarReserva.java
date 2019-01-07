/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.BD;

/**
 *
 * @author Iker Lopez
 */
public class FinalizarReserva extends HttpServlet {

    private Connection con;
    public void init(ServletConfig cfg) throws ServletException {
        con = BD.getConexion();
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
    
        int idReserva = Integer.parseInt(req.getParameter("idReserva1"));
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reservas WHERE idreserva=?");
            ps.setInt(1, idReserva);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                bean.Reserva r = new bean.Reserva();
                r.setEmail(rs.getString("email"));
                r.setFechaFin(getDateInFormat(rs.getString("fechaFin")));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                r.setFechaInicio(getDateInFormat(rs.getString("fechaIni")));
                r.setMatricula(rs.getString("matricula"));
                r.calcularExtras(dateFormat.format(new Date()));
                
                
                PreparedStatement ps2 = con.prepareStatement("UPDATE reservas SET extras=?, estado=? WHERE idreserva=?");
                ps2.setFloat(1, Float.parseFloat(r.getExtras()));
                ps2.setString(2, "Finalizada");
                ps2.setInt(3, idReserva);
                
                ps2.executeUpdate();
                
                req.getRequestDispatcher("empleadoReservas.jsp").forward(req, res);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String getDateInFormat(String date){
        
        date = date.substring(0, 10) +"T"+date.substring(11,date.length());
        date =date.substring(0, date.length()-2);
        return date;
    }
}
