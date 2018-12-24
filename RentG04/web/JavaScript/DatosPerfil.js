function rellenarDatos(){
    document.getElementById("perfUsuario").value = retStorageSession("nomUsuario");
    document.getElementById("perfCorreo").value = retStorageSession("usuarioLogin");
    document.getElementById("perfContra").value = retStorageSession("contrasenaLogin");
    document.getElementById("perfDNI").value = retStorageSession("dniUsuario");
};


