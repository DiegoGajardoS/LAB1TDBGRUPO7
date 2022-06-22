/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Emergencia{
    private Long id;
    private String titulo;
    private String direccion;
    private String descripcion;
    private Long id_institucion;
    private Boolean activo;
    private Double latitud;
    private Double longitud;
    private Boolean deleted;
    

    //***** GETTERS *****//
    public Long getId() {
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public Long getInstitucionId(){
        return id_institucion;
    }
    public Boolean getActivo(){
        return activo;
    }
    public Double getLatitud(){
        return latitud;
    }
    public Double getLongitud(){
        return longitud;
    }
    public Boolean getDeleteEstado(){
        return deleted;
    }
   

    //***** SETTERS *****//
    public void setId(Long id){
        this.id = id;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setInstitucionId(Long id_institucion){
        this.id_institucion = id_institucion;
    }
    public void setActivo(boolean activo){
        this.activo=activo;
    }
    public void setDeleteEstado(Boolean deleted){
        this.deleted = deleted;
    }
    public void setLatitud(Double latitud){
        this.latitud = latitud;
    }
    public void setLongitud(Double longitud){
        this.longitud = longitud;
    }
}  
