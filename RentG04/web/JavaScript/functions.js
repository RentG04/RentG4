/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function setCar(matricula){
    document.getElementById("coche").value=matricula;
}

function diferenciaFechas(entrega, devolucion){
    var fecha1 = new Date(entrega);
    var fecha2 = new Date(devolucion);
    
    var milis1 = fecha1.getTime();
    var milis2 = fecha2.getTime();
    
    var diferencia = milis2 - milis1;
    
    var horas = (diferencia / (1000 * 60 * 60)).toFixed(1);
    alert("Horas: " + horas);
    return horas;
}

