package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Voluntario;
import java.util.List;

public interface VoluntarioRepository {
    public Long countVoluntarios();
    public Voluntario createVoluntario(Voluntario Voluntario);
    public List<Voluntario> getAllVoluntarios();
    public Voluntario getVoluntario(Long id);
    public Voluntario updateVoluntario(Voluntario Voluntario, Long id);
    public boolean deleteVoluntario(Long id);
}