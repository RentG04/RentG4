<%-- 
    Document   : registro
    Created on : 18-dic-2018, 16:31:06
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
        <script src="JavaScript/ValidacionRegistro.js"></script>
        <script src="JavaScript/functions.js"></script>
        
    </head> 
    <body>
        <header class="main-header" >
                <a href="index.jsp">
                    <img alt="logo" src="images/logoTrans.png" width="100"/>
                    <img alt="logo1" class="logo1" id="logo1" src="images/logoTrans2.png" width="200">
                </a>
                <nav >
                    <ul id="botones">
                        
                               <!--<li><button type="button" class="button" value="login" onclick="location.href='login.html'">Login</button></li>-->
                               <!--<li><button type="button" class="button" value="salir" onclick="salir()">Salir</button></li>-->
                    </ul>
                    
                </nav> 
            </header>
        
        <form id="form_registro" class="container" ondragover="prevDef()">
            <h1>Registro</h1>
            <label id="dnibox" dropzone="" ondragover="drover()" ondragleave="drleave()">
                <span id="fileLabelText">
                    <br>
                    Arrastre y suelte su foto aquí.
                </span>
            </label>
            <br>
            Usuario*<br>
            <input type="text" name="Usuario" class="textbox" value="" pattern="[A-Za-z]{3,}" size="25" id="regUsuario" required />
            <br>
            <div class="error" id="error-usuario"></div>
            Correo*<br>
            <input type="email" name="Email" value="" size="25" id="regCorreo" required />
            <br>
            <div class="error" id="error-correo"></div>
            Contraseña*<br>
            <input type="password" name="Contrasena" value="" id="regContra" pattern="[A-Za-z0-9]{8,16}" size="25" required />
            <br>
            <div class="error" id="error-contrasena"></div>
            DNI*<br>
            <input type="text" name="Dni" value="" size="25" id="regDNI" pattern="[0-9]{8}[A-Za-z]{1}" required />
            
            <br>
            <div class="error" id="error-dni"></div>
            
<!--            <input type="file" name="files[]" id="fileInput" multiple onchange="addFiles(event)">
            <p>Suelta tu foto aquí.</p>-->
            
           
<!--            <label for="fileInput" id="fileLabel" ondragover="overrideDefault(event);fileHover();" ondragenter="overrideDefault(event);fileHover();" ondragleave="overrideDefault(event);fileHoverEnd();" ondrop="overrideDefault(event);fileHoverEnd();
                  addFiles(event);">
              <br>
              <span id="fileLabelText">
                Suelta tu foto aquí
              </span>
              <br>
              <span id="uploadStatus"></span>
            </label>-->
            <br>
            <input type="reset" class="button" value="Limpiar" />
            <input type="submit" class="button" value="Registrarse" id="registrobtn" onclick="add()"/>
         </form>       
    </body>
</html>

