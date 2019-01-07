<%-- 
    Document   : buscarCoche
    Created on : 27-dic-2018, 23:44:25
    Author     : Iker Lopez
--%>


<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="sun.security.pkcs11.wrapper.Functions"%>
<%@page import="bean.Busqueda"%>
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
                    private Statement set, set2;
                    private ResultSet rs, rs2;

                    public void jspInit() {
                        con = utils.BD.getConexion();
                    };

                %>
                <%

                    try {
                        String matrícula, marca, gama, imagen;
                        int preciodia;
                        String f1, f2;
//                        set2 = con.createStatement();
//                        f1 = ((bean.Busqueda)request.getSession().getAttribute("Busqueda")).getFechaRecogida();
//                        f2 = ((bean.Busqueda)request.getSession().getAttribute("Busqueda")).getFechaDevolucion();
//                        ArrayList<String> coches = new ArrayList<>();
//                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//                        
//                        System.out.println("Se va a ejecutar la sentencia, f1 = " + f1);
//                        f1=getDateInFormat(f1);
//                        f2=getDateInFormat(f2);
////                        Date fe1 = dateFormat.parse(f1);
////                        Date fe2 = dateFormat.parse(f2);
//                        
//                        
//                        PreparedStatement ps = con.prepareStatement("Select * from reservas where ? < ? and ? > ?");
//                        ps.setString(1,f1);
//                        ps.setString(2,"fechaIni");
//                        ps.setString(3,f2);
//                        ps.setString(4,"fechaFin");
//                        
//                        rs2 = ps.executeQuery();
//                        System.out.println("Se ha ejecutado");
//                        while(rs2.next()){
//                            System.out.println("Sentencia, matricula: " + rs2.getString("matricula"));
//                            coches.add(rs2.getString("matricula"));
//                        }
//                        System.out.println("Ha pasado el primer while, coches:" + coches.size());
                        
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
                            
//                            if(coches.contains(matrícula)){

                %>                         
                <tr><td><%=matrícula%></td>
                    <td><%=marca%></td>
                    <td><%=gama%></td>
                    <td><%=preciodia%> €</td>
                    <td id="image"><img src="<%=imagen%>" alt="" height=400 width=300></td>
                    <td id="res"><input type="submit" value="reservar" class="button"  id="<%=matrícula%>" onclick="setCar(this.id)"></input></td></tr>
                    <%}
//                            }
                            rs.close();
                            set.close();
                            //con.close();
                        } catch (Exception ex) {
                            System.out.println("Error en acceso a BD coches" + ex);
                        }

                        
                    %><%!
                    public String getDateInFormat(String date){
        
                            date = date.substring(0, 10) +"T"+date.substring(11,date.length());
                            date =date.substring(0, date.length());
                            return date;
        
                        }
                    %>
                </table>
             </form>
    </body>
</html>

