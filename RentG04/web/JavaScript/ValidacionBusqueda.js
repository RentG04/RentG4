window.onload = function()
{
    var recogida = document.getElementById("horarecogida");
    var devolucion = document.getElementById("horaentrega");
    
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();
    var hour = today.getHours();
    var min = today.getMinutes();
    var sec = today.getSeconds(); 
    if(dd<10){
        dd='0'+dd;
    } 
    if(mm<10){
        mm='0'+mm;
    } 
    if(hour<10){
        hour='0'+hour;
    }
    if(min<10){
        min='0'+min;
    }
    if(sec<10){
        sec='0'+sec;
    }
    today = yyyy+'-'+mm+'-'+dd+'T'+hour+':'+min+':'+sec;
//    if(dd==30 && (mm==04 || mm==06 || mm==09 || mm==11)){
//        dd=01;
//        mm=mm+1;
//    }else if(dd==31 && (mm==01 || mm==03 || mm==05 || mm==07 || mm==08 || mm==10 || mm==12)){
//        if(mm==12){
//            yyyy = yyyy+1;
//            mm= 01;
//            dd=01;
//        }else{
//            dd=01;
//            mm=mm+1;
//        }
//    }else if(dd==28 && mm==02){
//        dd=01;
//        mm=03;
//    }else{
//        dd=dd+1
//    }
//    
//    
//    entrega = yyyy+'-'+mm+'-'+dd+'T'+hour+':'+min+':'+sec;
        

    recogida.min = today;
    devolucion.min = today;

    recogida.onblur = function(){
        devolucion.min = recogida.value;
    };
};


