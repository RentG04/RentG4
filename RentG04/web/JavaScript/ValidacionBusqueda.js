function comprobar()
{
    var recogida = document.getElementById("horarecogida");
    var devolucion = document.getElementById("horaentrega");
    
    var fecha1 = new Date(recogida);
    var fecha2 = new Date(devolucion);
    
    if(fecha2.getMilliseconds()-fecha1.getMilliseconds()<0){
        alert("La fecha de entrega debe ser posterior a la de recogida");
        return false;
    }else{
        return true;
    }
    
    
    

    recogida.min = today;
    devolucion.min = today;

    recogida.onblur = function(){
        devolucion.min = recogida.value;
    };
};


