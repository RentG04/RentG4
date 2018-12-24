<%-- 
    Document   : perfil
    Created on : 18-dic-2018, 16:30:21
    Author     : Iker Lopez
--%>

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
                               
                    </ul>
                </nav> 
            </header>
        
        <form id="form_registro" class="container" ondragover="prevDef()">
            <h1 id="nombrePerfil"></h1>
            <label id="dnibox" dropzone="" ondragover="drover()" ondragleave="drleave()">
                <span id="fileLabelText">
                    <br>
                    Arrastre y suelte su foto aquí.
                </span>
            </label>
            <br>
            Usuario*<br>
            <input type="text" name="Usuario" class="textbox" value="" pattern="[A-Za-z]{3,}" size="25" id="perfUsuario" required />
            <br>
            <div class="error" id="error-usuariop"></div>
            Correo*<br>
            <input type="email" name="Email" value="" size="25" id="perfCorreo" required />
            <br>
            <div class="error" id="error-correop"></div>
            Contraseña*<br>
            <input type="password" name="Contrasena" value="" id="perfContra" pattern="[A-Za-z0-9]{8,16}" size="25" required />
            <br>
            <div class="error" id="error-contrasenap"></div>
            DNI*<br>
            <input readonly type="text" name="Dni" value="" size="25" id="perfDNI" pattern="[0-9]{8}[A-Za-z]{1}" required />
            
            <br>
            <div class="error" id="error-dnip"></div>
            
            <br>
            
            <input type="submit" class="button" value="Guardar" id="guardarPerfil" onclick="updatePerfil()"/>
         </form>       
    </body>
</html>
