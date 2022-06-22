/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;
import grupo7.tbd.lab1.models.Emergencia;
import grupo7.tbd.lab1.models.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Long countEmergencia(){
        String query = "select count(*) from emergencia";
        Connection conn = sql2o.open();
        Long resultado = (Long) conn.createQuery(query,true).executeAndFetchFirst(Long.class);
        return resultado + 1; 
    }

    @Override
    public Emergencia createEmergencia(Emergencia emergencia){
        Long id_prueba =countEmergencia();
        String coordenada = emergencia.getLongitud().toString() + " " + emergencia.getLatitud().toString();
        String query = "INSERT INTO emergencia(id,titulo,direccion,descripcion,id_institucion,activo,ubicacion) values (:id,:titulo,:direccion,:descripcion,:id_institucion,:activo" + 
        ", ST_GeomFromText('POINT(" + coordenada + ")' , 4326 ))";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query,true).addParameter("id",id_prueba).addParameter("titulo", emergencia.getTitulo())
                            .addParameter("descripcion", emergencia.getDescripcion())
                            .addParameter("id_institucion", emergencia.getInstitucionId())
                            .addParameter("direccion", emergencia.getDireccion())
                            .addParameter("activo", emergencia.getActivo())
                            .executeUpdate().getKey(Long.class);
            emergencia.setId(id_prueba);
            return emergencia;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia getEmergencia(Long id){
        String query = "select titulo,direccion,descripcion,st_x(st_astext(ubicacion)) AS longitud, st_y(st_astext(ubicacion)) AS latitud from emergencia where id = :id and deleted = false";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(query).addParameter("id",id).executeAndFetchFirst(Emergencia.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Emergencia> getEmergencias() {
        String query = "select titulo,direccion,descripcion,st_x(st_astext(ubicacion)) AS longitud, st_y(st_astext(ubicacion)) AS latitud from emergencia where deleted = false";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(query).executeAndFetch(Emergencia.class);
         }
         catch (Exception e){
             System.out.println(e.getMessage());
             return null;
         }
     }

    @Override
    public boolean deleteEmergencia(Long id){
        String query = "update emergencia set deleted = true where id = :id and deleted = false";
        try(Connection conn = sql2o.open()){
            id = conn.createQuery(query).addParameter("id",id).executeUpdate().getKey(Long.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Emergencia updateEmergencia( Emergencia emergencia,Long id){
        String coordenada = emergencia.getLongitud().toString() + " " + emergencia.getLatitud().toString();
        String query = "update emergencia set titulo = :titulo,descripcion = :descripcion, direccion = :direccion,id_institucion = :id_institucion,activo = :activo,ubicacion = ST_GeomFromText('POINT(" + coordenada + ")' , 4326 ) where id = :id and deleted = false";
        try(Connection conn = sql2o.open()){
          Long insertedid = (Long) conn.createQuery(query).addParameter("id", id)
            .addParameter("titulo", emergencia.getTitulo())
            .addParameter("descripcion", emergencia.getDescripcion())
            .addParameter("id_institucion", emergencia.getInstitucionId())
            .addParameter("direccion", emergencia.getDireccion())
            .addParameter("activo", emergencia.getActivo())
            .executeUpdate().getKey(Long.class);
            emergencia.setId(insertedid);
            return emergencia;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    
    @Override
    public List<Emergencia> getEmergenciasByRegionUsuario(Long id_vol){
        String query = "Select t2.titulo,t2.descripcion,latitud,longitud from(SELECT distinct emergencia.titulo, emergencia.descripcion, st_x(st_astext(emergencia.ubicacion)) AS longitud, st_y(st_astext(emergencia.ubicacion)) AS latitud from division_regional,emergencia" +
"	WHERE ST_Contains((Select geom from division_regional where nom_reg = (SELECT t1.nom_reg from (SELECT distinct division_regional.nom_reg from division_regional,voluntario,emergencia where ST_CONTAINS(division_regional.geom,(select ubicacion from voluntario where id = :id_vol)) = true )" +
"	as t1)),emergencia.ubicacion) = true) as t2;";
        try(Connection conn = sql2o.open()){
            System.out.println(conn.createQuery(query,true).addParameter("id_vol", id_vol).executeAndFetch(Emergencia.class));
            List<Emergencia> emergencias=conn.createQuery(query).addParameter("id_vol", id_vol).executeAndFetch(Emergencia.class);
            return (emergencias);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            
            return null;
        }
    }
    
    @Override
    public List<Habilidad> getHabilidadesEmergencia(Long id_em){
        String query = "SELECT eme_habilidad.id , habilidad.nombreH FROM eme_habilidad,habilidad WHERE habilidad.id=eme_habilidad.id_habilidad and eme_habilidad.id_emergencia=:id_em ";
        try(Connection conn = sql2o.open()){
            System.out.println(conn.createQuery(query,true).addParameter("id_em", id_em).executeAndFetch(Habilidad.class));
            List<Habilidad> habilidades=conn.createQuery(query).addParameter("id_em", id_em).executeAndFetch(Habilidad.class);
            return(habilidades);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
