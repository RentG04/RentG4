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
public class Empleado {
    private String usuario;
    private String contraseña;
    
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getContraseña(){
        return contraseña;
    }
}
