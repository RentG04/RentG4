<%-- 
    Document   : index
    Created on : 18-dic-2018, 16:09:30
    Author     : Iker Lopez
--%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="utils.ObtenerCabecera"%>
<%@page import="bean.Empleado"%>
<%@page import="bean.Usuario"%>
<%@page import="utils.BD"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">
    <head>
            <meta charset="utf-8">
            <title>VitoRent</title>
            <link rel="stylesheet" href="styles/styles.css">
            <link rel="shortcut icon" href="images/icon.ico">
            <script src="JavaScript/ValidaFecha.js"></script>
            <script src="JavaScript/ComprobarBusqueda.js"></script>
            
    </head>
    <body>    
        <%= ObtenerCabecera.get(request, "empleado") %>      
        <div id="mainContainer">
            <form id="form_buscar" onsubmit="return comprobar()" class="container" action="ReservasEmpleado" method="post">
                <h1>Buscar Reserva</h1>
                Email Cliente <br>
                <input type="text" name="EmailRes" class="textbox" value="" size="25" id="EmailRes"/>

                Matrícula Coche <br>
                <input type="text" name="matrRes" class="textbox" value="" size="25" id="matrRes"/>
                Fecha y hora de recogida<br>
                <input type="datetime-local" id="horarecogidaRes" name="FechaRecogida">
                    
                Fecha y hora de entrega<br>
                <input type="datetime-local" id="horaentregaRes" name="FechaDevolucion"> 
                <button class="button" type="submit" id="bus" value="buscar">Buscar</button>
            </form>
        </div>
    </body>
</html>

