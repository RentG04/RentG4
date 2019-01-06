<%@page import="bean.BusquedaReserva"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="utils.ObtenerCabecera"%>
<%@page import="bean.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
            <meta charset="utf-8">
            <title>Reservas</title>
            <link rel="stylesheet" href="styles/styles.css">
            <link rel="shortcut icon" href="images/icon.ico">      
    </head>

    <body>
        <%= ObtenerCabecera.get(request, "empleado") %>
        <br>
            <br>
            <br>
            <h1>Reservas</h1>
        <table id="tablaCoches">

                <tr><td><b>Matrícula</b></td><td><b>Fecha inicio</b></td><td><b>Fecha fin</b></td><td><b>Precio</b></td><td><b>Usuario</b></td></tr>

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
                        int num = ((bean.BusquedaReserva)request.getSession().getAttribute("BusquedaReserva")).getCampo();
                        String email, matricula, fecha1, fecha2;
                        email = ((bean.BusquedaReserva)request.getSession().getAttribute("BusquedaReserva")).getEmail();
                        matricula = ((bean.BusquedaReserva)request.getSession().getAttribute("BusquedaReserva")).getMatricula();
                        fecha1 = ((bean.BusquedaReserva)request.getSession().getAttribute("BusquedaReserva")).getFechaRecogida();
                        fecha2 = ((bean.BusquedaReserva)request.getSession().getAttribute("BusquedaReserva")).getFechaDevolucion();
                        String sql;
                        if(num == 1){
                            sql="SELECT * FROM reservas WHERE email='"+email+"'";
                        }else if(num == 2){
                            sql="SELECT * FROM reservas WHERE matricula='"+matricula+"'";
                        }else if(num == 3){
                            sql="SELECT * FROM reservas WHERE fechaIni='"+fecha1+"'";
                        }else{
                            sql="SELECT * FROM reservas WHERE fechaFin='"+fecha2+"'";
                        }
                        
                        rs = set.executeQuery(sql);
                        while (rs.next()) {
                            matrícula = rs.getString("matricula");
                            fechaini = rs.getString("fechaIni");
                            fechafin = rs.getString("fechaFin");
                            precio = rs.getFloat("precio");
                            email = rs.getString("email");

                %>                         
                <tr><td><%=matrícula%></td>
                    <td><%=fechaini%></td>
                    <td><%=fechafin%></td>
                    <td><%=precio%> €</td>
                    <td><%=email%> €</td>
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

