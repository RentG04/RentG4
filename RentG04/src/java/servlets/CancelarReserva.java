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
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.BD;
import java.util.Date;

/**
 *
 * @author Iker Lopez
 */
public class CancelarReserva extends HttpServlet {
    private Connection con;
    @Override
    public void init(ServletConfig cfg) throws ServletException {
        con = BD.getConexion();
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
    
        int idReserva = Integer.parseInt(req.getParameter("idReserva"));
    
        try
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Reservas WHERE idreserva=?");
            ps.setInt(1, idReserva);
            
            ResultSet rs = ps.executeQuery();
            String fechaI;
            String fechaF;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            if(rs.next()){
                fechaI = rs.getString("fechaIni");
                fechaF = rs.getString("fechaFin");
                
                fechaI=getDateInFormat(fechaI);
                fechaF=getDateInFormat(fechaF);
                
                Date inicio = dateFormat.parse(fechaI);
                Date fin = dateFormat.parse(fechaF);
                Date now = new Date();
                System.out.println("Now ---->>"+now.getTime());
                System.out.println("Now ---->>"+inicio.getTime());
               
                if((inicio.getTime()-now.getTime())>=7200000){
                    PreparedStatement ps2 = con.prepareStatement("UPDATE Reservas SET estado=? WHERE idreserva=?;");
                    ps2.setString(1, "Cancelada");
                    ps2.setInt(2, idReserva); 
                    ps2.executeUpdate();
                    
                }
                else{
                    req.setAttribute("error-cancelar", "error al cancelar la reserva");
                }
                
                
                
            }
            
            req.getRequestDispatcher("miReserva.jsp").forward(req, res);
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