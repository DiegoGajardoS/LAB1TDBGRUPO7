package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Tarea;
import java.util.List;

public interface TareaRepository {
    public Tarea createTarea(Tarea Tarea);
    public List<Tarea> getTareas();  
    public Tarea getTarea(Long id);
    public Tarea updateTarea(Tarea Tarea, Long id);
    public boolean deleteTarea(Long id);
    public Long countTarea();
}