package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;


@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
@Autowired
     private Sql2o sql2o;

    @Override
    public Long countVoluntarios(){
        String query = "select count(*) from voluntario";
         Connection conn = sql2o.open();
         Long resultado = (Long) conn.createQuery(query,true).executeAndFetchFirst(Long.class);
         return resultado + 1; 
     }
    
    @Override
    public Voluntario createVoluntario(Voluntario voluntario){
        Long id_vol = countVoluntarios();
        String query = "INSERT INTO voluntario (id,nombre,disponibilidad,telefono,direccion,correo_electronico,rut,ubicacion) values (:id,:nombre,:disponibilidad,:telefono,:direccion,:correo_electronico,:rut,:ubicacion)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query,true).addParameter("id",id_vol)
                            .addParameter("disponibilidad", voluntario.getDisponibilidad())
                            .addParameter("nombre", voluntario.getNombre())
                            .addParameter("telefono", voluntario.getTelefono())
                            .addParameter("direccion", voluntario.getDireccion())
                            .addParameter("correo_electronico", voluntario.getCorreo_electronico())
                            .addParameter("rut", voluntario.getRut())
                            .addParameter("ubicacion", voluntario.getUbicacion())
                            .executeUpdate().getKey(Long.class);
            voluntario.setId(id_vol);
            return voluntario;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario getVoluntario(Long id){
        String query = "select * from voluntario where id = :id and deleted = false";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(query).addParameter("id",id).executeAndFetchFirst(Voluntario.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntario> getAllVoluntarios() {
        String query = "select * from voluntario where deleted = false";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(query).executeAndFetch(Voluntario.class);
         }
         catch (Exception e){
             System.out.println(e.getMessage());
             return null;
         }
     }

    @Override
    public boolean deleteVoluntario(Long id){
        String query = "update voluntario set deleted=true where id=:id and deleted=false";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query).addParameter("id",id).executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Voluntario updateVoluntario( Voluntario voluntario,Long id){
        String query = "update voluntario set nombre = :nombre , disponibilidad = :disponibilidad , telefono = :telefono, direccion = :direccion, correo_electronico = :correo_electronico, rut = :rut, ubicacion = :ubicacion where id = :id and deleted = false";
        try(Connection conn = sql2o.open()){
            Long insertedid = (Long) conn.createQuery(query).addParameter("id", id)
            .addParameter("id",voluntario.getId())
            .addParameter("nombre", voluntario.getNombre())
            .addParameter("disponibilidad", voluntario.getDisponibilidad())
            .addParameter("telefono", voluntario.getTelefono())
            .addParameter("direccion", voluntario.getDireccion())
            .addParameter("correo_electronico", voluntario.getCorreo_electronico())
            .addParameter("rut", voluntario.getRut())
            .addParameter("ubicacion", voluntario.getUbicacion())
            .executeUpdate().getKey(Long.class);
            voluntario.setId(insertedid);
        
            return voluntario;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

     }
 }