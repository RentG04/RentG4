/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Iker Lopez
 */
public class Reserva {
    private String matricula;
    private String email;
    private String fechaInicio;
    private String fechaFin;
    private String precio;
    private String extras;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getEmail() {
        return email;
    }

    public String getExtras() {
        return extras;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }


    public String getMatricula() {
        return matricula;
    }

    public String getPrecio() {
        return precio;
    }   
    
    public boolean calcularPrecio(int precioDia){
        //Aqui calculamos el precio y lo guardamos en la variable precio
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
 
        try
        {
            Date fechaInicial=dateFormat.parse(fechaInicio);
            Date fechaFinal=dateFormat.parse(fechaFin);

            float dias= (((float)(fechaFinal.getTime()-fechaInicial.getTime()))/86400000);
            float p = precioDia*dias;
            System.out.println("dias ------> "+dias);
            precio = Float.toString(p);
            return true;
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
}
