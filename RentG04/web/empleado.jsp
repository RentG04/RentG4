<%-- 
    Document   : index
    Created on : 18-dic-2018, 16:09:30
    Author     : Iker Lopez
--%>
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
            <script src="JavaScript/functions.js"></script>
            <script src="JavaScript/ValidaFecha.js"></script>
            
    </head>

    <body>
        <header class="main-header">
            <a>
                    <img alt="logo" src="images/logoTrans.png" width="100"/>
                    <img alt="logo1" class="logo1" id="logo1" src="images/logoTrans2.png" width="200">
            </a>           
            <nav>
                <ul id="botones">
                    <%
                        HttpSession s = request.getSession();
                        try{
                            Empleado u = (Empleado)s.getAttribute("usr");
                            if(u==null){
                    %>
                                <li><button type="button" class="button" value="login" onclick='location.href="login.jsp"'>Login</button></li>
                                <li><button type="button" class="button" value="registro" onclick='location.href="registro.jsp"'>Registro</button></li>
                    <%
                            }else{
                                %>
                                <li><button type='button' class='button' value='perfil' onclick='location.href="empleado.jsp"'>Bienvenido <strong>${usr.usuario}</strong></button></li>
                                <li><a href="Logout" ><button type='button' class='button' value='logout'>Logout</button></a></li>
                                <%
                            }  
                        }catch(Exception e){
                        e.printStackTrace();} 
                    %>
                </ul>
            </nav>       
        </header>
        <div id="mainContainer">
            <form id="form_buscar" class="container">
                <h1>Buscar Reserva</h1>
                
                <button class="button" type="button"  value="buscar">Buscar</button>
            </form>
        </div>
    </body>
</html>

