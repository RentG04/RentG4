/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import utils.ImagenUsuario;

/**
 *
 * @author unigo
 */
public class Usuario {
    private String usuario;
    private String email;
    private String contraseña;
    private ImagenUsuario foto;
    private String dni;
    private String telefono;
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getTelefono(){
        return telefono;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    public String getDni(){
        return dni;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setFoto(ImagenUsuario foto) {
        this.foto = foto;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public ImagenUsuario getFoto() {
        return foto;
    }
    
}
