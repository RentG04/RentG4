window.onload = function()
{
    var usuario = document.getElementById("regUsuario");
    var correo = document.getElementById("regCorreo");
    var contra = document.getElementById("regContra");
    var dni = document.getElementById("regDNI");


    usuario.onchange = function(){
        if(usuario.value.length < 3 || !usuario){
            //alert("Introduzca un usuario válido");
            document.getElementById("error-usuario").innerHTML = "*Nombre de usuario no valido";
            usuario.focus();
        }
        else{
            document.getElementById("error-usuario").innerHTML = "";
        }
    };

    correo.onchange = function(){
        if(correo.value.length < 5 || !correo){
            //alert("Introduzca un correo válido");
            document.getElementById("error-correo").innerHTML = "*Correo electronico no valido";
            correo.focus();
        }
        else{
            document.getElementById("error-correo").innerHTML = "";
        }
    };

    contra.onchange = function(){
        if(contra.value.length < 8 || !contra){
            //alert("Introduzca una contraseña válida");
            document.getElementById("error-contrasena").innerHTML = "*Contraseña no valida";
            contra.focus();
        }
        else{
            document.getElementById("error-contrasena").innerHTML = "";
        }
    };

    dni.onchange = function(){
        if(dni.value.length != 9 || !dni){
            //alert("Introduzca un dni válido");
            document.getElementById("error-dni").innerHTML = "*DNI no valido";
            dni.focus();
        }
        else{
            document.getElementById("error-dni").innerHTML = "";
        }
    };

};