<%@page import="utils.ObtenerCabecera"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login Empleado</title>
        <link rel="stylesheet" href="styles/styles.css">
        <link rel="shortcut icon" href="images/icon.ico">
    </head>
    <body>
        <%= ObtenerCabecera.get(request, "loginEmpleado") %>
        <form id="form_login" action="LoginOficinista" method="post" class="container">
   
            <h1>Login Empleado</h1>
            Usuario<br>
            <input type="text" name="Usuario" value="" id="logCorreoOfi"  size="25" required />
            <br>
            Contraseña<br>
            <input type="password" name="Contrasena" value="" id="logContraOfi" size="25" required />
            <br>
            <input type="submit" class = "button" value="Login" />
        </form>
</html>