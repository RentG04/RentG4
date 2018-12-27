<%-- 
    Document   : buscarCoche
    Created on : 27-dic-2018, 23:44:25
    Author     : Iker Lopez
--%>

<%@page import="utils.ObtenerCabecera"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
            <meta charset="utf-8">
            <title>VitoRent</title>
            <link rel="stylesheet" href="styles/styles.css">
            <link rel="shortcut icon" href="images/icon.ico">
            <script src="JavaScript/ValidaFecha.js"></script>       
    </head>
    <body>
        <%= ObtenerCabecera.get(request, "index") %>
        <div id="mainContainer">
            
        </div>
    </body>
</html>

