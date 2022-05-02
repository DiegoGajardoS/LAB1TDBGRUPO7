/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Tarea {
    private Long id;
    private String titulo;
    private String descripcion;
    private Long id_estado;
    private Long id_emergencia;
    private Integer cant_voluntarios;
    private boolean deleted;
    

    //***** GETTERS *****//

    public Long getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public Long getEstadoId(){
        return id_estado;
    }

    public Long getEmergenciaId(){
        return id_emergencia;
    }

    public Integer getCant_Voluntarios(){
        return cant_voluntarios;
    }

    public boolean getDelete(){
        return deleted;
    }

    //***** SETTERS *****//

    public void setId(Long id){
        this.id = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setEstadoId(Long id){
        this.id_estado = id;
    }

    public void setEmergenciaId(Long id){
        this.id_emergencia = id;
    }

    public void setCant_Voluntarios(Integer cv){
        this.cant_voluntarios = cv;
    }

    public void setDelete(boolean deleted){
        this.deleted = deleted;
    }
}