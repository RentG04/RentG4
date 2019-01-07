function comprobar()
{
    
    var recogida = document.getElementById("horarecogida");
    var devolucion = document.getElementById("horaentrega");
    var hoy = new Date();
    var fecha1 = new Date(recogida.value);
    var fecha2 = new Date(devolucion.value);
    if(fecha1.getTime()<hoy.getTime()){
        alert("La fecha de recogida debe ser posterior a la fecha actual");
        return false;
    }else{
        if(fecha2.getTime()-fecha1.getTime()<7200000){
            alert("La fecha de entrega debe ser al menos 2 horas después de la recogida");
            return false;
        }else{
            return true;
        }
    }
};


