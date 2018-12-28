/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.Busqueda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class BuscarCoche extends HttpServlet {
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
        
        Busqueda b = new Busqueda();
        b.setLugarRecogida(req.getParameter("LugarDeRecogida"));
        b.setLugarDevolucion(req.getParameter("LugarDeEntrega"));
        b.setFechaRecogida(req.getParameter("FechaRecogida"));
        b.setFechaDevolucion(req.getParameter("FechaDevolucion"));
        b.setGamaVehiculo(req.getParameter("GamaVehiculo"));
        
        System.out.println(b.getFechaDevolucion());
        System.out.println(b.getGamaVehiculo());
        System.out.println(b.getLugarDevolucion());
        s.setAttribute("Busqueda", b);
        req.getRequestDispatcher("buscarCoche.jsp").forward(req, res);
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
