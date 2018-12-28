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
public class Busqueda {
    private String lugarRecogida;
    private String lugarDevolucion;
    private String fechaRecogida;
    private String fechaDevolucion;
    private String gamaVehiculo;
    
    public void setLugarRecogida(String lugarRecogida){
        this.lugarRecogida=lugarRecogida;
    }
    public void setLugarDevolucion(String lugarDevolucion){
        this.lugarDevolucion=lugarDevolucion;
    }
    public void setFechaRecogida(String fechaRecogida){
        this.fechaRecogida=fechaRecogida;
    }
    public void setFechaDevolucion(String fechaDevolucion){
        this.fechaDevolucion=fechaDevolucion;
    }
    public void setGamaVehiculo(String gamaVehiculo){
        this.gamaVehiculo=gamaVehiculo;
    }
    public String getLugarRecogida(){
        return lugarRecogida;
    }
     public String getLugarDevolucion(){
        return lugarDevolucion;
    }
     public String getFechaRecogida(){
        return fechaRecogida;
    }
     public String getFechaDevolucion(){
        return fechaDevolucion;
    }
     public String getGamaVehiculo(){
        return gamaVehiculo;
    }
}
