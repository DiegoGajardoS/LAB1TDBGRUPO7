package grupo7.tbd.lab1.services;

import grupo7.tbd.lab1.models.Tarea;
import grupo7.tbd.lab1.repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TareaService {
    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    //GET ALL
    @GetMapping("/tareas")
    public List<Tarea> getAllTareas() {
        return tareaRepository.getAllTareas();
    }

    //GET BY ID
    @GetMapping("/tareas/{id}")
    public List<Tarea> getTarea(@PathVariable int id) {
        return tareaRepository.getTarea(id);
    }

    //CREATE
    @PostMapping("/tareas")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        Tarea result = tareaRepository.createTarea(tarea);
        return result;
    }

    //DELETE
    @DeleteMapping("/tareas/delete/{id}")
    @ResponseBody
    public List<Tarea> deleteTarea(@PathVariable int id){
        tareaRepository.deleteTarea(id);
        return tareaRepository.getAllTareas();
    }
    //UPDATE
    @PutMapping("/tareas/update/{id}")
    @ResponseBody
    public List<Tarea> updateTarea(@RequestBody Tarea tarea, @PathVariable int id){
        tareaRepository.updateTarea(tarea, id);
        return tareaRepository.getAllTareas();
    }
}
