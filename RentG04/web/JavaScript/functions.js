
window.onload = function()
{
    
    var str="";
    var dir = String(window.location.href); 
    if(sessionStorage.getItem('usuarioLogin') == null){  
        if(dir.substring(dir.lastIndexOf('/')+1) == 'index.html'){
            str +=     '             <li><button type="button" class="button" value="login" onclick=\"location.href='+'\'login.jsp\''+'">Login</button></li>';
            str +=      '            <li><button type="button" class="button" value="registro" onclick="location.href='+'\'registro.jsp\''+'">Registro</button></li>';
            document.getElementById("botones").innerHTML = str;
        }else if(dir.substring(dir.lastIndexOf('/')+1,dir.lastIndexOf('/')+11) == 'login.html'){
            str +=      '            <li><button type="button" class="button" value="registro" onclick="location.href='+'\'registro.jsp\''+'">Registro</button></li>';
            document.getElementById("botones").innerHTML = str;
        }else if(dir.substring(dir.lastIndexOf('/')+1,dir.lastIndexOf('/')+14) == 'registro.html'){
            str +=     '             <li><button type="button" class="button" value="login" onclick=\"location.href='+'\'login.jsp\''+'">Login</button></li>';
            document.getElementById("botones").innerHTML = str;
            validarRegistro();
        }else if(dir.substring(dir.lastIndexOf('/')+1) == 'buscarCoche.html'){
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
        if(dir.substring(dir.lastIndexOf('/')+1) == 'index.html'){
            str +=     '             <li><button type="button" class="button" value="perfil" onclick=\"location.href='+'\'perfil.jsp\''+'">Perfil</button></li>';
            str +=     '             <li><button type="button" class="button" value="reserva" onclick=\"location.href='+'\'miReserva.jsp\''+'">Mis Reservas</button></li>';
            str +=      '            <li><button type="button" class="button" value="salir" onclick="salir()">Salir</button></li>';
            
            document.getElementById("botones").innerHTML = '<li>'+'Hola, ' +retStorageSession("nomUsuario") + '</li>' + str;
        }else if(dir.substring(dir.lastIndexOf('/')+1,dir.lastIndexOf('/')+12) == 'perfil.html'){
            str +=     '             <li><button type="button" class="button" value="reserva" onclick=\"location.href='+'\'miReserva.jsp\''+'">Mis Reservas</button></li>';
            str +=      '            <li><button type="button" class="button" value="salir" onclick=\"'+'salir()'+'\">Salir</button></li>';
            document.getElementById("botones").innerHTML = str;
            document.getElementById("nombrePerfil").innerHTML = retStorageSession("nomUsuario");
            rellenarDatos();
            validarPerfil();           
        }else if(dir.substring(dir.lastIndexOf('/')+1) == 'buscarCoche.html'){
            str +=     '             <li><button type="button" class="button" value="perfil" onclick=\"location.href='+'\'perfil.jsp\''+'">Perfil</button></li>';
            str +=     '             <li><button type="button" class="button" value="reserva" onclick=\"location.href='+'\'miReserva.jsp\''+'">Mis Reservas</button></li>';
            str +=      '            <li><button type="button" class="button" value="salir" onclick="salir()">Salir</button></li>';
            document.getElementById("botones").innerHTML = '<li>'+'Hola, ' +retStorageSession("nomUsuario") + '</li>' + str;
            
        }else if(dir.substring(dir.lastIndexOf('/')+1) == 'miReserva.html'){
            str +=     '             <li><button type="button" class="button" value="perfil" onclick=\"location.href='+'\'perfil.jsp\''+'">Perfil</button></li>';
            str +=      '            <li><button type="button" class="button" value="salir" onclick="salir()">Salir</button></li>';
            document.getElementById("botones").innerHTML = '<li>'+'Hola, ' +retStorageSession("nomUsuario") + '</li>' + str;
            
        }else{
            str +=     '             <li><button type="button" class="button" value="perfil" onclick=\"location.href='+'\'perfil.jsp\''+'">Perfil</button></li>';
            str +=     '             <li><button type="button" class="button" value="reserva" onclick=\"location.href='+'\'miReserva.jsp\''+'">Mis Reservas</button></li>';
            str +=      '            <li><button type="button" class="button" value="salir" onclick="salir()">Salir</button></li>';
            document.getElementById("botones").innerHTML = '<li>'+'Hola, ' +retStorageSession("nomUsuario") + '</li>' + str;
        }
    }
    
//    document.getElementById("botones").innerHTML = str;
    iniciar();
    
};

var bd;
function iniciar() {

    zonadatos = document.getElementById("zonadatos");

    var solicitud = window.indexedDB.open("rentg04");

    solicitud.onsuccess = function (e) {

        bd = e.target.result;
    };

    solicitud.onupgradeneeded = function (e) {

        bd = e.target.result;
        bd.createObjectStore("cliente", {keyPath: "dni"});
        bd.createObjectStore("reserva", {keyPath: "id",autoIncrement:true});
        bd.createObjectStore("coche", {keyPath: "matricula"});
        
        
        
    };

}





function add() {
    
    var usuario = document.getElementById("regUsuario").value;
        var correo = document.getElementById("regCorreo").value;
        var contra = document.getElementById("regContra").value;
        var dniUsuario = document.getElementById("regDNI").value;
        var item ={
            dni: dniUsuario,
            email: correo,
            nombre: usuario,
            contrasena: contra,
            fotopath: ""
        };
    var transaccion = bd.transaction(["cliente"], "readwrite");
    var almacen = transaccion.objectStore("cliente");
    var agregar = almacen.add(item); 
};
function updatePerfil() {
    var transaccion = bd.transaction(["cliente"], "readwrite");
    var objectStore = transaccion.objectStore("cliente");
    objectStore.delete(retStorageSession("dniUsuario"));
    var usuario = document.getElementById("perfUsuario").value;
        var correo = document.getElementById("perfCorreo").value;
        var contra = document.getElementById("perfContra").value;
        var dniUsuario = document.getElementById("perfDNI").value;
//        borrar();
        sessionStorage.setItem('nomUsuario', usuario);
        sessionStorage.setItem('usuarioLogin', correo);
        sessionStorage.setItem('contrasenaLogin', contra);
        sessionStorage.setItem('dniUsuario', dniUsuario);
//        storageSession('usuarioLogin', 'perfCorreo');
//        storageSession('contrasenaLogin', 'perfContra');
//        storageSession('nomUsuario', 'perfUsuario');
//        storageSession('dniUsuario', 'perfDNI');
        var item ={
            dni: dniUsuario,
            email: correo,
            nombre: usuario,
            contrasena: contra,
            fotopath: ""
        };
    var tran = bd.transaction(["cliente"], "readwrite");
    var al = tran.objectStore("cliente");
    var agregar = al.add(item); 
};

function comprobar(){
    var correo = document.getElementById("logCorreo").value;
    var contra = document.getElementById("logContra").value;
    var transaccion = bd.transaction(["cliente"], "readonly");
    var almacen = transaccion.objectStore("cliente");
    var clientes = [];
    
    almacen.openCursor().onsuccess = function (e) {

        var result = e.target.result;

        if (result == null){
            return;
        }
        clientes.push(result.value);
        result.continue();
    };
    var logueado = false;
    transaccion.oncomplete = function () {
        for (var key in clientes){
            var emailObt=clientes[key].email;
            var contrasenaObt=clientes[key].contrasena;
            if(emailObt == correo && contrasenaObt == contra){
                   var nom = clientes[key].nombre;
                   var dni = clientes[key].dni;
                   storageSession('usuarioLogin', 'logCorreo');
                   storageSession('contrasenaLogin', 'logContra');
                   sessionStorage.setItem('nomUsuario', nom);
                   sessionStorage.setItem('dniUsuario', dni);
                   logueado = true;
                   document.location.href = 'index.html';
            };
        };
        if(!logueado){
            alert("Usuario o contraseña incorrectos");
        }
    };
    
    function storageSession(name,id){ 
        if(document.getElementById(id).value !== "" && document.getElementById(id).value !== sessionStorage.getItem(name)){
            sessionStorage.setItem(name,document.getElementById(id).value);
        }     
    }
    
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
    var coche1={
          matricula: "0000AAA",
          marca: "Ford fiesta",
          color: "Rojo",
          combustible: "gasolina",
          disponible: "true"
        };
        var coche2={
          matricula: "1111BBB",
          marca: "Toyota Prius",
          color: "Blanco",
          combustible: "Hibrido",
          disponible: "true"
        };
        var coche3={
          matricula: "2222CCC",
          marca: "Audi A6",
          color: "Blanco",
          combustible: "gasolina",
          disponible: "true"
        };
        
        var t = bd.transaction("coche","readwrite");
        var a = t.objectStore("coche");
        a.add(coche1);        
        a.add(coche2);
        a.add(coche3);
        cargarTablaCoches();
};

function cargarTablaCoches(){
    
    var transaccion = bd.transaction(["coche"], "readonly");
    var almacen = transaccion.objectStore("coche");
    var coches =[];
    var str ='<h1 style="padding-top:120px;" >Resultados de la busqueda</h1><table id="tablaCoches">';
    almacen.openCursor().onsuccess = function (e) {
       
        var result = e.target.result;
        
        if(result)
        {
            console.log(result.value.matricula);
            coches.push(result.value);
            str += '<tr><th>  '+result.value.matricula+' </th><th>  '+result.value.marca+'  </th><th>  '+result.value.combustible+' </th></tr>';
            result.continue();
        }   
        else{  
            str += '</table>';
            console.log(coches);
            document.getElementById("mainContainer").innerHTML = str;
        }
    };

}
