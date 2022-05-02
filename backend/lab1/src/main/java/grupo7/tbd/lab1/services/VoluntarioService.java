package grupo7.tbd.lab1.services;

import grupo7.tbd.lab1.models.Voluntario;
import grupo7.tbd.lab1.repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    //GET ALL
    @GetMapping("/voluntarios")
    public List<Voluntario> getAllVoluntarios() {
        return voluntarioRepository.getAllVoluntarios();
    }

    //GET BY ID
    @GetMapping("/voluntarios/{id}")
    public List<Voluntario> getVoluntario(@PathVariable int id) {
        return voluntarioRepository.getVoluntario(id);
    }

    //CREATE
    @PostMapping("/voluntarios")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        Voluntario result = voluntarioRepository.createVoluntario(voluntario);
        return result;
    }

    //DELETE
    @DeleteMapping("/voluntarios/delete/{id}")
    @ResponseBody
    public List<Voluntario> deleteVoluntario(@PathVariable int id){
        voluntarioRepository.deleteVoluntario(id);
        return voluntarioRepository.getAllVoluntarios();
    }
    //UPDATE
    @PutMapping("/voluntarios/update/{id}")
    @ResponseBody
    public List<Voluntario> updateVoluntario(@RequestBody Voluntario voluntarios, @PathVariable int id){
        voluntarioRepository.updateVoluntario(voluntarios, id);
        return voluntarioRepository.getAllVoluntarios();
    }
}
