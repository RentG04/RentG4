<%-- 
    Document   : miReserva
    Created on : 18-dic-2018, 16:29:40
    Author     : Iker Lopez
--%>

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
        
    </body>
</html>

