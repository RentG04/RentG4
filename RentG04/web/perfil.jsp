<%-- 
    Document   : perfil
    Created on : 18-dic-2018, 16:30:21
    Author     : Iker Lopez
--%>

<%@page import="bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        
        <meta charset="UTF-8">
        <title>Registro</title>
        <link rel="stylesheet" href="styles/styles.css">
        <link rel="shortcut icon" href="images/icon.ico">
        <script src="JavaScript/DragAndDropDNI.js"></script>
        <script src="JavaScript/ValidacionPerfil.js"></script>
        <script src="JavaScript/functions.js"></script>
        <script src="JavaScript/DatosPerfil.js"></script>
        
    </head> 
    <body>
        <header class="main-header" >
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
        
        <form id="form_actualizar" class="container" ondragover="prevDef()" action="ActualizarDatos" method="POST">
            <h1 id="nombrePerfil"></h1>
            <label id="dnibox" dropzone="" ondragover="drover()" ondragleave="drleave()">
                <span id="fileLabelText">
                    <br>
                    Arrastre y suelte su foto aquí.
                </span>
            </label>
            <br>
            Usuario*<br>
            <input type="text" name="Usuario" class="textbox" value="${usr.usuario}" pattern="[A-Za-z]{3,}" size="25" id="perfUsuario" required />
            <br>
            <div class="error" id="error-usuariop"></div>
            Correo*<br>
            <input readonly type="email" name="Email" value="${usr.email}" size="25" id="perfCorreo" required />
            <br>
            <div class="error" id="error-correop"></div>
            Contraseña*<br>
            <input type="password" name="Contrasena" value="${usr.contraseña}" id="perfContra" pattern="[A-Za-z0-9]{8,16}" size="25" required />
            <br>
            <div class="error" id="error-contrasenap"></div>
            DNI<br>
            <input readonly type="text" name="Dni" value="${usr.dni}" size="25" id="perfDNI" pattern="[0-9]{8}[A-Za-z]{1}" />   
            <br>
            <div class="error" id="error-dnip"></div>
            <br>
            Telefono<br>
            <input type="text" name="Telefono" class="textbox" value="${usr.telefono}" pattern="[0-9]{9}" size="25" id="perfTelefono"/>
            <br>
            <div class="error" id="error-usuariop"></div>
            
            <input type="submit" class="button" value="Guardar" id="guardarPerfil" onclick="updatePerfil()"/>
         </form>       
    </body>
</html>
