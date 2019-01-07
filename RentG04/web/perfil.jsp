<%-- 
    Document   : perfil
    Created on : 18-dic-2018, 16:30:21
    Author     : Iker Lopez
--%>

<%@page import="utils.ObtenerCabecera"%>
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
    </head> 
    <body>
        <header class="main-header" >
                <a href="index.jsp">
                    <img alt="logo" src="images/logoTrans.png" width="100"/>
                    <img alt="logo1" class="logo1" id="logo1" src="images/logoTrans2.png" width="200">
                </a>
                <nav>
                    <ul id="botones">
                        <%= ObtenerCabecera.get(request, "perfil") %>
                </ul>
                </nav> 
            </header>
        
                <form id="form_actualizar" class="container" ondragover="prevDef()" action="ActualizarDatos" method="POST" enctype="multipart/form-data">
            <h1 id="nombrePerfil"></h1>
<!--            <label id="dnibox" dropzone="" ondragover="drover()" ondragleave="drleave()">
                <span id="fileLabelText">
                    <br>
                    Arrastre y suelte su foto aquí.
                </span>
            </label>-->

            <input type="file" name="Archivo" id="regArchivo" value=""/>
            <label for="regArchivo" id="dnibox" type="file" dropzone="" ondragover="drover()" ondragleave="drleave()" name="Archivo">
                <span id="fileLabelText">
                    Arrastre y Suelte su foto aquí
                    <br>
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
            Teléfono<br>
            <input type="text" name="Telefono" class="textbox" value="${usr.telefono}" pattern="[0-9]{9}" size="25" id="perfTelefono"/>
            <br>
            <div class="error" id="error-usuariop"></div>
            
            <input type="submit" class="button" value="Guardar" id="guardarPerfil" onclick="updatePerfil()"/>
         </form>       
    </body>
</html>
