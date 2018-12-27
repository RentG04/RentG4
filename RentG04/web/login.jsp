<%-- 
    Document   : login
    Created on : 18-dic-2018, 16:27:35
    Author     : Iker Lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="styles/styles.css">
        <link rel="shortcut icon" href="images/icon.ico">
        <script src="JavaScript/functions.js"></script>
    </head>
    <body>
        <header class="main-header" >
            <a href="index.jsp">
                <img alt="logo" src="images/logoTrans.png" width="100"/>
                <img alt="logo1" class="logo1" id="logo1" src="images/logoTrans2.png" width="200">
            </a>
            <nav>
                <ul id="botones">
                     <li><button type="button" class="button" value="registro" onclick="location.href='registro.jsp'">Login</button></li>     
                </ul>
            </nav> 
        </header>

        <%
                String error = "";
                if (null != request.getAttribute("errorlogin")) {
                       error = (String) request.getAttribute("errorlogin");
                   }%>
        <form id="form_login" action ="LoginUsuario" method="post" class="container">
   
            <h1>Login</h1>
            Correo<br>
            <input type="email" name="Usuario" value="" id="logCorreo"  size="25" required />
            <br>
            Contraseña<br>
            <input type="password" name="Contrasena" value="" id="logContra" size="25" required />
            <br>
            <input type="submit" class = "button" onclick="comprobar()" value="Login" />
            <input type="button" class="button" value="Registrarse" onclick="location.href = 'registro.jsp'"/>
            
            <a href="loginEmpleado.jsp">Soy empleado</a>
            <div id="error-login"><h2><%=error%></h2></div> 
            
            <!--Comprobar si el correo existe en la base de datos, y la contrasña también-->
        </form>
</html>