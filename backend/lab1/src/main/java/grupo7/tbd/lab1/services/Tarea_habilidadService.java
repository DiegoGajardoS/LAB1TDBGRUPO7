package grupo7.tbd.lab1.services;

import grupo7.tbd.lab1.models.Tarea_Habilidad;
import grupo7.tbd.lab1.repositories.Tarea_habilidadRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Tarea_habilidadService {
    private final Tarea_habilidadRepository tarea_habilidadRepository;

    public Tarea_habilidadService(Tarea_habilidadRepository tarea_habilidadRepository){
        this.tarea_habilidadRepository = tarea_habilidadRepository;
    }

    //GET ALL
    @GetMapping("/tarea_habilidades")
    public List<Tarea_Habilidad> getAllTarea_habilidades() {
        return tarea_habilidadRepository.getAllTarea_habilidades();
    }

    //GET BY ID
    @GetMapping("/tarea_habilidades/{id}")
    public List<Tarea_Habilidad> getTarea_habilidad(@PathVariable int id) {
        return tarea_habilidadRepository.getTarea_habilidad(id);
    }

    //CREATE
    @PostMapping("/tarea_habilidades")
    @ResponseBody
    public Tarea_Habilidad createTarea_habilidad(@RequestBody Tarea_Habilidad tarea_habilidad){
        Tarea_Habilidad result = tarea_habilidadRepository.createTarea_habilidad(tarea_habilidad);
        return result;
    }

    //DELETE
    @DeleteMapping("/tarea_habilidades/delete/{id}")
    @ResponseBody
    public List<Tarea_Habilidad> deleteTarea_habilidad(@PathVariable int id){
        tarea_habilidadRepository.deleteTarea_habilidad(id);
        return tarea_habilidadRepository.getAllTarea_habilidades();
    }
    //UPDATE
    @PutMapping("/tarea_habilidades/update/{id}")
    @ResponseBody
    public List<Tarea_Habilidad> updateTarea_habilidad(@RequestBody Tarea_Habilidad tarea_habilidad, @PathVariable int id){
        tarea_habilidadRepository.updateTarea_habilidad(tarea_habilidad, id);
        return tarea_habilidadRepository.getAllTarea_habilidades();
    }
}
