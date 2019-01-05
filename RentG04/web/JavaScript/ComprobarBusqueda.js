
function comprobar(){
    var campo1 = document.getElementById("DNIRes");
    var campo2 = document.getElementById("matrRes");
    var campo3 = document.getElementById("horaentregaRes");
    var campo4 = document.getElementById("horarecogidaRes");
    
    if(campo1.value == "" && campo2.value == "" && campo3.value == "" && campo4.value==""){
        alert("Rellene al menos un campo");
        return false;
    }else{
        return true;
    }
    
}


