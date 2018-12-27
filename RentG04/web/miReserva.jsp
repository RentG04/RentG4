<%-- 
    Document   : miReserva
    Created on : 18-dic-2018, 16:29:40
    Author     : Iker Lopez
--%>

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
        <header class="main-header">
            <a href="index.jsp">
                    <img alt="logo" src="images/logoTrans.png" width="100"/>
                    <img alt="logo1" class="logo1" id="logo1" src="images/logoTrans2.png" width="200">
                </a>
            
                <nav>
                    <ul id="botones">
                          <%
                        HttpSession s = request.getSession();
                        try{
                            Usuario u = (Usuario)s.getAttribute("usr");
                            if(u==null){
                    %>
                                <li><button type="button" class="button" value="login" onclick='location.href="login.jsp"'>Login</button></li>
                                <li><button type="button" class="button" value="registro" onclick='location.href="registro.jsp"'>Registro</button></li>
                    <%
                            }else{
                                %>
                                <li><button type='button' class='button' value='perfil' onclick='location.href="perfil.jsp"'>Bienvenido <strong>${usr.usuario}</strong></button></li>
                                <img src='${usr.foto}' width="45px" align="center">
                                <li><button type='button' class='button' value='perfil' onclick='location.href="miReserva.jsp"'>Mis reservas</button></li>
                                <li><a href="Logout" ><button type='button' class='button' value='logout'>Logout</button></a></li>
                                <%
                            }  
                        }catch(Exception e){
                        e.printStackTrace();} 
                    %>
                    </ul>
                </nav>
                    
        </header>
        
    </body>
</html>

