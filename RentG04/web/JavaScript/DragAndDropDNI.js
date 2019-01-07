
window.addEventListener('load', inicio, false);
var droppedFiles;

    function inicio(ev){
        
       ev.preventDefault();
        //document.getElementById('dnibox').addEventListener('dragover', permitirDrop, false);    
        //document.getElementById('dnibox').addEventListener('drop', drop, false);
        document.getElementById('regArchivo').addEventListener('change',addFiles,false);
        
//    }
//    
//    function drop(ev){
//        
//        ev.preventDefault();
//        ev.stopPropagation;
//        droppedFiles = ev.dataTransfer.files[0];
//        var fileR= new FileReader();
//        fileR.addEventListener('load',leer,false);
//        fileR.readAsDataURL(ev.dataTransfer.files[0]);    
//        
//    }      
//    
//    function permitirDrop(ev){
//        
//        ev.preventDefault();
//        ev.stopPropagation();
//        
//    }    
//    
    function leer(ev)
    {
        //ev.preventDefault();
        //ev.stopPropagation;
        document.getElementById('dnibox').style.backgroundImage="url('" + ev.target.result + "')";
        document.getElementById('dnibox').style.border="0px dashed gray"
        document.getElementById("dnibox").style.boxShadow="0 0 0 orange";
        document.getElementById("fileLabelText").innerHTML= droppedFiles.name;
        document.getElementById("fileLabelText").style.textalign = "center";
    }
//    
//    function drover(){
//        
//      document.getElementById("dnibox").style.boxShadow="0 0 16px orange";  
//    }
//    function drleave(){
//      
//      document.getElementById("dnibox").style.boxShadow="0 0 0 orange";  
//    }
    function addFiles(event){
        
        event.preventDefault();
        event.stopPropagation;
        droppedFiles = event.target.files[0];
        var fileR= new FileReader();
        fileR.addEventListener('load',leer,false);
        fileR.readAsDataURL(event.target.files[0]);  
    }
}
