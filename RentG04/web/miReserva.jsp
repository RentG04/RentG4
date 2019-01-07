<%-- 
    Document   : miReserva
    Created on : 18-dic-2018, 16:29:40
    Author     : Iker Lopez
--%>

<%@page import="java.sql.Date"%>
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
            <script src="JavaScript/functions.js"></script> 
    </head>

    <body>
        <%= ObtenerCabecera.get(request, "miReserva") %>
        <br>
            <br>
            <br>
            <h1>Mis reservas</h1>
        <table id="tablaCoches">
            <center>
                <%if(request.getAttribute("error-cancelar")==null){
                    request.setAttribute("error-cancelar", "");
                }%>
            <div id="error-cancelada"><%= request.getAttribute("error-cancelar")%></div>
            </center>
            <form id="formCancelarReserva" action ="CancelarReserva" method="post">
                <input type="hidden" name="idReserva" id="idReserva" value=""> 
                <tr><td><b>Matrícula</b></td><td><b>Fecha inicio</b></td><td><b>Fecha fin</b></td><td><b>Precio</b></td><td><b>Estado</b></td><td><b>Cancelar</b></td></tr>

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
                        String matrícula, estado;
                        Date fechaini, fechafin;
                        float precio, extras, precioTotal;
                        int idreserva;
                        set = con.createStatement();
                        String e = ((bean.Usuario)request.getSession().getAttribute("usr")).getEmail();
                        rs = set.executeQuery("SELECT * FROM reservas where email='"+e+"';");
                        while (rs.next()) {
                            idreserva = rs.getInt("idreserva");
                            matrícula = rs.getString("matricula");
                            fechaini = rs.getDate("fechaIni");
                            fechafin = rs.getDate("fechaFin");
                            precio = rs.getFloat("precio");
                            estado = rs.getString("estado");
                            extras = rs.getFloat("extras");
                            precioTotal = precio+extras;
                            

               %>   
         
                <tr><td><%=matrícula%></td>
                    <td><%=fechaini%></td>
                    <td><%=fechafin%></td>
                    <td><%=precioTotal%> €</td>
                    <td><%=estado%></td>
                    <td id="res"><input type="submit" value="Cancelar" class="button" onclick="cancelarReserva(this.id)"  id="<%=idreserva%>"</input></td>
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
        </form>
    </body>
</html>

