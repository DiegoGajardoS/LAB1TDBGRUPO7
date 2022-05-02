package grupo7.tbd.lab1.services;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import grupo7.tbd.lab1.models.Voluntario;
import grupo7.tbd.lab1.repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;
    private final Gson gson;

    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.gson = new GsonBuilder().create();
        this.voluntarioRepository = voluntarioRepository;
    }

    @GetMapping("/voluntarios/")
    ResponseEntity<String> getAllVoluntarios(){
        List<Voluntario> volOut = voluntarioRepository.getAllVoluntarios();
        return new ResponseEntity<>(gson.toJson(volOut),HttpStatus.OK);
    }

    @GetMapping("/voluntarios/{id}")
    ResponseEntity<String> getVoluntario(@PathVariable Long id){
        Voluntario vol = voluntarioRepository.getVoluntario(id);
        if(vol != null){
            return new ResponseEntity<>(gson.toJson(vol),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/voluntarios/create")
    ResponseEntity<String> createVoluntarios(@RequestBody String request){
        Voluntario VoluntariosOut = gson.fromJson(request,Voluntario.class);
        if (VoluntariosOut != null){
            VoluntariosOut = voluntarioRepository.createVoluntario(VoluntariosOut);
            return new ResponseEntity<>(gson.toJson(VoluntariosOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(origins = {"http://localhost:8080"})
    @ResponseBody
    @RequestMapping(value ="/voluntarios/{id}",  method =RequestMethod.PUT,consumes="application/json")
    ResponseEntity<String> updateVoluntarios(@RequestBody String request, @PathVariable Long id){
        Voluntario vol = gson.fromJson(request, Voluntario.class);
        Voluntario VoluntariosOut = voluntarioRepository.getVoluntario(id);
        if(VoluntariosOut != null){
            if(vol.getNombre() != null){
                VoluntariosOut.setNombre(vol.getNombre());
            }
            if(vol.getDisponibilidad() != null){
                VoluntariosOut.setDisponibilidad(vol.getDisponibilidad());
            }
            if(vol.getDireccion() != null){
                VoluntariosOut.setDireccion(vol.getDireccion());
            }
            if(vol.getCorreo_electronico() != null){
                VoluntariosOut.setCorreo_electronico(vol.getCorreo_electronico());
            }
            if(vol.getTelefono() != null){
                VoluntariosOut.setTelefono(vol.getTelefono());
            }
            if(vol.getUbicacion()!= null){
                VoluntariosOut.setUbicacion(vol.getUbicacion());
            }
            VoluntariosOut = voluntarioRepository.updateVoluntario(VoluntariosOut, id);
            return new ResponseEntity<>(gson.toJson(VoluntariosOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/voluntarios/{id}")
    ResponseEntity<String> deleteVoluntarios(@PathVariable Long id){
        if(voluntarioRepository.deleteVoluntario(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
