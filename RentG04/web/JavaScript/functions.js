
window.onload = function()
{
    /*
    var str="";
    var dir = String(window.location.href); 
    if(sessionStorage.getItem('usuarioLogin') == null){  
        if(dir.substring(dir.lastIndexOf('/')+1) == 'index.jsp'){
            str +=     '             <li><button type="button" class="button" value="login" onclick=\"location.href='+'\'login.jsp\''+'">Login</button></li>';
            str +=      '            <li><button type="button" class="button" value="registro" onclick="location.href='+'\'registro.jsp\''+'">Registro</button></li>';
            document.getElementById("botones").innerHTML = str;
        }else if(dir.substring(dir.lastIndexOf('/')+1,dir.lastIndexOf('/')+10) == 'login.jsp'){
            str +=      '            <li><button type="button" class="button" value="registro" onclick="location.href='+'\'registro.jsp\''+'">Registro</button></li>';
            document.getElementById("botones").innerHTML = str;
        }else if(dir.substring(dir.lastIndexOf('/')+1,dir.lastIndexOf('/')+18) == 'loginEmpleado.jsp'){
            str +=      '            <li><button type="button" class="button" value="registro" onclick="location.href='+'\'registro.jsp\''+'">Registro</button></li>';
            document.getElementById("botones").innerHTML = str;
        }else if(dir.substring(dir.lastIndexOf('/')+1,dir.lastIndexOf('/')+13) == 'registro.jsp'){
            str +=     '             <li><button type="button" class="button" value="login" onclick=\"location.href='+'\'login.jsp\''+'">Login</button></li>';
            document.getElementById("botones").innerHTML = str;
            validarRegistro();
        }else if(dir.substring(dir.lastIndexOf('/')+1) == 'buscarCoche.jsp'){
            str +=     '             <li><button type="button" class="button" value="login" onclick=\"location.href='+'\'login.jsp\''+'">Login</button></li>';
            str +=      '            <li><button type="button" class="button" value="registro" onclick="location.href='+'\'registro.jsp\''+'">Registro</button></li>';
            document.getElementById("botones").innerHTML = str;
            
        }else{
            str +=     '             <li><button type="button" class="button" value="login" onclick=\"location.href='+'\'login.jsp\''+'">Login</button></li>';
            str +=      '            <li><button type="button" class="button" value="registro" onclick="location.href='+'\'registro.jsp\''+'">Registro</button></li>';
            document.getElementById("botones").innerHTML = str;
        }
    }
    else
    {
        if(dir.substring(dir.lastIndexOf('/')+1) == 'index.jsp'){
            str +=     '             <li><button type="button" class="button" value="perfil" onclick=\"location.href='+'\'perfil.jsp\''+'">Perfil</button></li>';
            str +=     '             <li><button type="button" class="button" value="reserva" onclick=\"location.href='+'\'miReserva.jsp\''+'">Mis Reservas</button></li>';
            str +=      '            <li><button type="button" class="button" value="salir" onclick="salir()">Salir</button></li>';
            
            document.getElementById("botones").innerHTML = '<li>'+'Hola, ' +retStorageSession("nomUsuario") + '</li>' + str;
        }else if(dir.substring(dir.lastIndexOf('/')+1,dir.lastIndexOf('/')+11) == 'perfil.jsp'){
            str +=     '             <li><button type="button" class="button" value="reserva" onclick=\"location.href='+'\'miReserva.jsp\''+'">Mis Reservas</button></li>';
            str +=      '            <li><button type="button" class="button" value="salir" onclick=\"'+'salir()'+'\">Salir</button></li>';
            document.getElementById("botones").innerHTML = str;
            document.getElementById("nombrePerfil").innerHTML = retStorageSession("nomUsuario");
            rellenarDatos();
            validarPerfil();           
        }else if(dir.substring(dir.lastIndexOf('/')+1) == 'buscarCoche.jsp'){
            str +=     '             <li><button type="button" class="button" value="perfil" onclick=\"location.href='+'\'perfil.jsp\''+'">Perfil</button></li>';
            str +=     '             <li><button type="button" class="button" value="reserva" onclick=\"location.href='+'\'miReserva.jsp\''+'">Mis Reservas</button></li>';
            str +=      '            <li><button type="button" class="button" value="salir" onclick="salir()">Salir</button></li>';
            document.getElementById("botones").innerHTML = '<li>'+'Hola, ' +retStorageSession("nomUsuario") + '</li>' + str;
            
        }else if(dir.substring(dir.lastIndexOf('/')+1) == 'miReserva.jsp'){
            str +=     '             <li><button type="button" class="button" value="perfil" onclick=\"location.href='+'\'perfil.jsp\''+'">Perfil</button></li>';
            str +=      '            <li><button type="button" class="button" value="salir" onclick="salir()">Salir</button></li>';
            document.getElementById("botones").innerHTML = '<li>'+'Hola, ' +retStorageSession("nomUsuario") + '</li>' + str;
            
        }else{
            str +=     '             <li><button type="button" class="button" value="perfil" onclick=\"location.href='+'\'perfil.jsp\''+'">Perfil</button></li>';
            str +=     '             <li><button type="button" class="button" value="reserva" onclick=\"location.href='+'\'miReserva.jsp\''+'">Mis Reservas</button></li>';
            str +=      '            <li><button type="button" class="button" value="salir" onclick="salir()">Salir</button></li>';
            document.getElementById("botones").innerHTML = '<li>'+'Hola, ' +retStorageSession("nomUsuario") + '</li>' + str;
        }
    }*/
    
//    document.getElementById("botones").innerHTML = str;
   // iniciar();
    
};


function iniciar() {

}





function add() {
     
};
function updatePerfil() {
  
};

function comprobar(){
  
};
function retStorageSession(name){
        return sessionStorage.getItem(name);
    }

    function borrar(){
        sessionStorage.clear();
    };
function salir(){
        borrar();
        document.location.href = 'index.html';
};

function cargarCoches(){
   
};

function cargarTablaCoches(){
   
}
