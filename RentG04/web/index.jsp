<%-- 
    Document   : index
    Created on : 18-dic-2018, 16:09:30
    Author     : Iker Lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">
    <head>
            <meta charset="utf-8">
            <title>VitoRent</title>
            <link rel="stylesheet" href="styles/styles.css">
            <link rel="shortcut icon" href="images/icon.ico">
            <script src="JavaScript/functions.js"></script>
            
    </head>

    <body>
        <header class="main-header">
            <a href="index.jsp">
                    <img alt="logo" src="images/logoTrans.png" width="100"/>
                    <img alt="logo1" class="logo1" id="logo1" src="images/logoTrans2.png" width="200">
                </a>
            
<!--                <nav id="nombre">
                    
                </nav> -->
            
                <nav>
                    <ul id="botones">
                               
                    </ul>
                </nav>
                    
        </header>
        <div id="mainContainer">
            <form id="form_buscar" class="container">
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
                <input type="datetime-local" id="horarecogida"  >
                    
                Fecha y hora de entrega<br>
                <input type="datetime-local" id="horaentrega"  > 
                
                Gama del vehiculo<br>
                <select name="gama_vehiculo">
                    <option>Baja</option>
                    <option>Media</option>
                    <option>Alta</option>
                </select>
                
                <button class="button" type="button"  value="buscar" onclick="cargarCoches()">Buscar</button>
            </form>
        </div>
    </body>
</html>
