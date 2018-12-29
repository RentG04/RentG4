<%-- 
    Document   : miReserva
    Created on : 18-dic-2018, 16:29:40
    Author     : Iker Lopez
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="utils.ObtenerCabecera"%>
<%@page import="bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
            <meta charset="utf-8">
            <title>Mis Reservas</title>
            <link rel="stylesheet" href="styles/styles.css">
            <link rel="shortcut icon" href="images/icon.ico">      
    </head>

    <body>
        <%= ObtenerCabecera.get(request, "miReserva") %>
        <br>
            <br>
            <br>
            <h1>Mis reservas</h1>
        <table id="tablaCoches">

                <tr><td><b>Matrícula</b></td><td><b>Fecha inicio</b></td><td><b>Fecha fin</b></td><td><b>Precio</b></td></tr>

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
                        String matrícula, fechaini, fechafin;
                        float precio;
                        set = con.createStatement();
                        String e = ((bean.Usuario)request.getSession().getAttribute("usr")).getEmail();
                        rs = set.executeQuery("SELECT * FROM reservas where email='"+e+"';");
                        while (rs.next()) {
                            matrícula = rs.getString("matricula");
                            fechaini = rs.getString("fechaIni");
                            fechafin = rs.getString("fechaFin");
                            precio = rs.getFloat("precio");

                %>                         
                <tr><td><%=matrícula%></td>
                    <td><%=fechaini%></td>
                    <td><%=fechafin%></td>
                    <td><%=precio%> €</td>
                    </tr>
                    <%
                            }
                            rs.close();
                            set.close();
                            //con.close();
                        } catch (Exception ex) {
                            System.out.println("Error en acceso a BD Reservas " + ex);
                        }
                    %>
                </table>
    </body>
</html>

