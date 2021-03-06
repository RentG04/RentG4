<%-- 
    Document   : index
    Created on : 18-dic-2018, 16:09:30
    Author     : Iker Lopez
--%>
<%@page import="utils.ObtenerCabecera"%>
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
            <script src="JavaScript/ValidacionBusqueda.js"></script>
    </head>
    <body>
        <%= ObtenerCabecera.get(request, "index") %>
        <div id="mainContainer">
            <form id="form_buscar" class="container" onsubmit="return comprobar()" action="BuscarCoche" method="post">
                <h1>Buscar vehiculo</h1>

                Lugar de recogida<br>
                <select name="LugarDeRecogida" id ="lugar_recogida" class="lugar-recogida">
                    <option>Oficina de Vitoria-Gasteiz</option>
                    <option>Oficina de Bilbao</option>
                    <option>Oficina de Donosti</option>
                </select>
                
                <div id = "lugar_entrega">
                    Lugar de entrega<br>
                </div>
                <select name="LugarDeEntrega" id ="lugar_recogida" class="lugar-recogida">
                    <option>Oficina de Vitoria-Gasteiz</option>
                    <option>Oficina de Bilbao</option>
                    <option>Oficina de Donosti</option>
                </select>

                Fecha y hora de recogida<br>
                <input type="datetime-local" id="horarecogida" name="FechaRecogida" required>
                    
                Fecha y hora de entrega<br>
                <input type="datetime-local" id="horaentrega" name="FechaDevolucion" required> 
                
                Gama del vehiculo<br>
                <select name="GamaVehiculo">
                    <option>Todas</option>
                    <option>Baja</option>
                    <option>Media</option>
                    <option>Alta</option>
                </select>
                
                <button class="button" type="submit"  value="buscar">Buscar</button>
            </form>
        </div>
    </body>
</html>
