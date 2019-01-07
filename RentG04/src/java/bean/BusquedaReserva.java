/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Iker Lopez
 */
public class BusquedaReserva {
    private String email;
    private String matricula;
    private String fechaRecogida;
    private String fechaDevolucion;
    private int campo;
    
    
    public void setFechaRecogida(String fechaRecogida){
        this.fechaRecogida=fechaRecogida;
    }
    public void setFechaDevolucion(String fechaDevolucion){
        this.fechaDevolucion=fechaDevolucion;
    }
    public void setEmail(String email){
        this.email=email;
    }
    
     public String getFechaRecogida(){
        return fechaRecogida;
    }
     public String getFechaDevolucion(){
        return fechaDevolucion;
    }
     public String getEmail(){
        return email;
    }
     public void setMatricula(String matricula){
        this.matricula=matricula;
    }
    
     public String getMatricula(){
        return matricula;
    }
     
     public void setCampo(int campo){
        this.campo=campo;
    }
    
     public int getCampo(){
        return campo;
    }
}
