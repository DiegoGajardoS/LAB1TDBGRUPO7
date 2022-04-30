package grupo7.tbd.lab1.services;

import grupo7.tbd.lab1.models.Vol_Habilidad;
import grupo7.tbd.lab1.repositories.Vol_habilidadRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class Vol_habilidadService {
    private final Vol_habilidadRepository vol_habilidadRepository;

    public Vol_habilidadService(Vol_habilidadRepository Vol_habilidadRepository){
        this.vol_habilidadRepository = Vol_habilidadRepository;
    }

    @GetMapping("/vol_habilidades")
    public List<Vol_Habilidad> getAllVol_habilidades() {
        return vol_habilidadRepository.getAllVol_habilidades();
    }

    //Get by ID
    @GetMapping("/vol_habilidades/{id}")
    public List<Vol_Habilidad> getVol_habilidad(@PathVariable int id) {
        return vol_habilidadRepository.getVol_habilidad(id);
    }

    // post -> createVol_habilidad
    @PostMapping("/vol_habilidades")
    @ResponseBody
    public Vol_Habilidad createVol_habilidad(@RequestBody Vol_Habilidad vol_habilidad){
        Vol_Habilidad result = vol_habilidadRepository.createVol_habilidad(vol_habilidad);
        return result;
    }

    //DELETE
    @DeleteMapping("/vol_habilidades/delete/{id}")
    @ResponseBody
    public List<Vol_Habilidad> deleteVol_habilidad(@PathVariable int id){
        vol_habilidadRepository.deleteVol_habilidad(id);
        return vol_habilidadRepository.getAllVol_habilidades();
    }
    //UPDATE
    @PutMapping("/vol_habilidades/update/{id}")
    @ResponseBody
    public List<Vol_Habilidad> updateVol_habilidad(@RequestBody Vol_Habilidad vol_habilidad, @PathVariable int id){
        vol_habilidadRepository.updateVol_habilidad(vol_habilidad, id);
        return vol_habilidadRepository.getAllVol_habilidades();
    }
}
