<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login Empleado</title>
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
                    <li><button type="button" class="button" value="salir" onclick="location.href='index.jsp'">Volver</button></li>
                </ul>
            </nav> 
        </header>

        <form id="form_login" action ="LoginOficinsta" method="post" class="container">
   
            <h1>Login Empleado</h1>
            Correo<br>
            <input type="email" name="Usuario" value="" id="logCorreoOfi"  size="25" required />
            <br>
            Contraseña<br>
            <input type="password" name="Contrasena" value="" id="logContraOfi" size="25" required />
            <br>
            <input type="submit" class = "button" onclick="comprobar()" value="Login" />  
            
        </form>
</html>