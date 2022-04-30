package grupo7.tbd.lab1.services;

import grupo7.tbd.lab1.models.Voluntario;
import grupo7.tbd.lab1.repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class VoluntarioService {
    private final VoluntarioRepository voluntariosRepository;

    public VoluntarioService(VoluntarioRepository VoluntariosRepository){
        this.voluntariosRepository = VoluntariosRepository;
    }

    @GetMapping("/voluntarios")
    public List<Voluntario> getAllVoluntarios() {
        return voluntariosRepository.getAllVoluntarios();
    }

    //GET BY ID
    @GetMapping("/voluntarios/{id}")
    public List<Voluntario> getVoluntario(@PathVariable int id) {
        return voluntariosRepository.getVoluntario(id);
    }

    //CREATE
    @PostMapping("/voluntarios")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntarios){
        Voluntario result = voluntariosRepository.createVoluntario(voluntarios);
        return result;
    }

    //DELETE
    @DeleteMapping("/voluntarios/delete/{id}")
    @ResponseBody
    public List<Voluntario> deleteVoluntario(@PathVariable int id){
        voluntariosRepository.deleteVoluntario(id);
        return voluntariosRepository.getAllVoluntarios();
    }
    //UPDATE
    @PutMapping("/voluntarios/update/{id}")
    @ResponseBody
    public List<Voluntario> updateVoluntario(@RequestBody Voluntario voluntarios, @PathVariable int id){
        voluntariosRepository.updateVoluntario(voluntarios, id);
        return voluntariosRepository.getAllVoluntarios();
    }
}
