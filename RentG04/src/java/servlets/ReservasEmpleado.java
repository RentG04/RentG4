
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import bean.Busqueda;
import bean.BusquedaReserva;
import java.io.IOException;
import java.sql.Connection;
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
public class ReservasEmpleado extends HttpServlet{
    
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        HttpSession s = req.getSession(true);
        
        BusquedaReserva b = new BusquedaReserva();
        b.setEmail(req.getParameter("EmailRes"));
        b.setFechaDevolucion(req.getParameter("FechaDevolucion"));
        b.setFechaRecogida(req.getParameter("FechaRecogida"));
        b.setMatricula(req.getParameter("matrRes"));
        s.setAttribute("BusquedaReserva", b);

        req.getRequestDispatcher("empleadoReservas.jsp").forward(req, res);
    }

   
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            doPost(req, res);
        } catch (IOException | ServletException e) {
        }
    }

}
