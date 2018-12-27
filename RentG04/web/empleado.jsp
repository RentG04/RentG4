<%-- 
    Document   : index
    Created on : 18-dic-2018, 16:09:30
    Author     : Iker Lopez
--%>
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
            
    </head>
    <body>    
        <%= ObtenerCabecera.get(request, "empleado") %>      
        <div id="mainContainer">
            <form id="form_buscar" class="container">
                <h1>Buscar Reserva</h1>
                
                <button class="button" type="button"  value="buscar">Buscar</button>
            </form>
        </div>
    </body>
</html>

