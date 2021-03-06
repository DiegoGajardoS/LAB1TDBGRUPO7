/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Estado_Tarea;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class Estado_TareaRepositoryImp implements Estado_TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Long countEstado_Tarea(){
        String query = "select count(*) from estado_tarea";
        Connection conn = sql2o.open();
        Long resultado = (Long) conn.createQuery(query,true).executeAndFetchFirst(Long.class);
        return resultado + 1; 
    }
    
    @Override
    public Estado_Tarea createEstado_Tarea(Estado_Tarea estado_tarea){
        Long id_prueba=countEstado_Tarea();
        String query = "insert into estado_tarea (id,estado) values (:id,:estado)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query, true).addParameter("id",id_prueba)
                    .addParameter("estado", estado_tarea.getEstado())
                    .executeUpdate().getKey(Long.class);
            estado_tarea.setId(id_prueba);
            return estado_tarea;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Estado_Tarea getEstado_Tarea(Long id){
        String query = "select * from estado_tarea where id = :id and deleted = false";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(query).addParameter("id",id).executeAndFetchFirst(Estado_Tarea.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Estado_Tarea> getEstado_Tareas() {
        String query = "select * from estado_tarea";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(query).executeAndFetch(Estado_Tarea.class);
         }
         catch (Exception e){
             System.out.println(e.getMessage());
             return null;
         }
     }

     @Override
     public boolean deleteEstado_Tarea(Long id){
         String query = "update estado_tarea set deleted = true where id = :id and deleted = false";
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
    public Estado_Tarea updateEstado_Tarea( Estado_Tarea estado_tarea, Long id){
        String query = "update estado_tarea set estado = :estado where id = :id and deleted = false";
        try(Connection conn = sql2o.open()){
            Long insertedid = (Long) conn.createQuery(query).addParameter("id", id)
            .addParameter("estado", estado_tarea.getEstado())
                            .executeUpdate().getKey(Long.class);
            estado_tarea.setId(insertedid);
            return estado_tarea;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

     }
    
}
