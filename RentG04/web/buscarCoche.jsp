<%-- 
    Document   : buscarCoche
    Created on : 27-dic-2018, 23:44:25
    Author     : Iker Lopez
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="utils.ObtenerCabecera"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
            <meta charset="utf-8">
            <title>VitoRent</title>
            <link rel="stylesheet" href="styles/styles.css">
            <link rel="shortcut icon" href="images/icon.ico">
            <script src="JavaScript/functions.js"></script> 
    </head>
    <body>
        <%= ObtenerCabecera.get(request, "index") %>
        
        <div id="mainContainer">
            <br>
            <br>
            <br>
            <h1>Búsqueda de coches</h1>
           
            <form id="formReservaCoche" action ="ReservaCoche" method="post">
                <input type="hidden" name="coche" id="coche" value=""> 
                <table id="tablaCoches">

                <tr><td><b>Matrícula</b></td><td><b>Marca</b></td><td><b>Gama</b></td><td><b>Precio por día</b></td><td><b>Imagen</b></td><td><b>Reservar</b></td></tr>

                <%!
                    private Connection con;
                    private Statement set;
                    private ResultSet rs;

                    public void jspInit() {
                        con = utils.BD.getConexion();
                    };

                %>
                <%

                    try {
                        String matrícula, marca, gama, imagen;
                        int preciodia;
                        set = con.createStatement();
                        String g = ((bean.Busqueda)request.getSession().getAttribute("Busqueda")).getGamaVehiculo();
                        if(!g.equals("Todas"))
                        {
                            rs = set.executeQuery("SELECT * FROM coches where gama='"+g+"';");
                        }
                        else{
                            rs = set.executeQuery("SELECT * FROM coches;");
                        }
                        while (rs.next()) {
                            matrícula = rs.getString("matricula");
                            marca = rs.getString("modelo");
                            gama = rs.getString("gama");
                            imagen = rs.getString("imagen");
                            preciodia = rs.getInt("preciodia");

                %>                         
                <tr><td><%=matrícula%></td>
                    <td><%=marca%></td>
                    <td><%=gama%></td>
                    <td><%=preciodia%> €</td>
                    <td id="image"><img src="<%=imagen%>" alt="" height=400 width=300></td>
                    <td id="res"><input type="submit" value="reservar" class="button"  id="<%=matrícula%>" onclick="setCar(this.id)"></input></td></tr>
                    <%
                            }
                            rs.close();
                            set.close();
                            //con.close();
                        } catch (Exception ex) {
                            System.out.println("Error en acceso a BD coches" + ex);
                        }
                    %>
                </table>
             </form>
    </body>
</html>

