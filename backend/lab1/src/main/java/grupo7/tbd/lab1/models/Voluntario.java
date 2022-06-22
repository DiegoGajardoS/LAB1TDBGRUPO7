/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Voluntario {
     
    private Long id;
    private String nombre;
    private Boolean disponibilidad;
    private String telefono;
    private String direccion;
    private String correo_electronico;
    private String rut;
    private Double latitud;
    private Double longitud;   
    private Boolean deleted;
    //***** GETTERS *****//
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }
    public String getTelefono(){
        return telefono;
    }

    public String getDireccion(){
        return direccion;
    }
    public String getCorreo_electronico(){
        return correo_electronico;
    }
    
    public String getRut(){
        return rut;
    }
    public Double getLatitud(){
        return latitud;
    }
    
   public Double getLongitud(){
       return longitud;
   }

    public Boolean getDeleted(){
        return deleted;
    }


    //***** SETTERS *****//
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisponibilidad(Boolean disponibilidad) {

        this.disponibilidad = disponibilidad;
    }
    
    public void setTelefono(String telefono){
        this.telefono= telefono;
    }
    
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
   
    public void setCorreo_electronico(String correo){
        this.correo_electronico = correo;
    }
    
    public void setRut(String rut){
        this.rut = rut;
    }
    public void setLatitud(Double latitud){
        this.latitud = latitud;
    }
    
    public void setLongitud(Double longitud){
        this.longitud = longitud;
    }

    public void setDeleted(Boolean deleted){
        this.deleted = deleted;
    }
    
}