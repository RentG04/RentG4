function validarPerfil(){
    var usuario = document.getElementById("perfUsuario");
    var correo = document.getElementById("perfCorreo");
    var contra = document.getElementById("perfContra");
    
    
    usuario.onchange = function(){
        if(usuario.value.length < 3 || !usuario){
            //alert("Introduzca un usuario válido");
            document.getElementById("error-usuariop").innerHTML = "*Nombre de usuario no valido";
            usuario.focus();
        }
        else{
            document.getElementById("error-usuariop").innerHTML = "";
        }
    };
    
    correo.onchange = function(){
        if(correo.value.length < 5 || !correo){
            //alert("Introduzca un correo válido");
            document.getElementById("error-correop").innerHTML = "*Correo electronico no valido";
            correo.focus();
        }
        else{
            document.getElementById("error-correop").innerHTML = "";
        }
    };
    
    contra.onchange = function(){
        if(contra.value.length < 8 || !contra){
            //alert("Introduzca una contraseña válida");
            document.getElementById("error-contrasenap").innerHTML = "*Contraseña no valida";
            contra.focus();
        }
        else{
            document.getElementById("error-contrasenap").innerHTML = "";
        }
    };
    
    
    
};

