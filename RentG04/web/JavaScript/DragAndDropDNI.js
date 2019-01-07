
window.addEventListener('load', inicio, false);
  
    function inicio(ev){
        localStorage.clear(); 
        ev.preventDefault();
        document.getElementById('dnibox').addEventListener('dragover', permitirDrop, false);    
        document.getElementById('dnibox').addEventListener('drop', drop, false);
    }
    
    function drop(ev){
        
        ev.preventDefault();
        var fileR= new FileReader();
        fileR.addEventListener('load',leer,false);
        fileR.readAsDataURL(ev.dataTransfer.files[0]);
        
    }      
    
    function permitirDrop(ev){
        
        ev.preventDefault();
        
    }    
    
    function leer(ev)
    {
        
        document.getElementById('dnibox').style.backgroundImage="url('" + ev.target.result + "')";
        document.getElementById('dnibox').style.border="0px dashed gray"
        document.getElementById("dnibox").style.boxShadow="0 0 0 orange";
        document.getElementById("fileLabelText").style.display="none";
    }
    
    function drover(){
      
      document.getElementById("dnibox").style.boxShadow="0 0 16px orange";  
    }
    function drleave(){
      
      
      document.getElementById("dnibox").style.boxShadow="0 0 0 orange";  
    }
