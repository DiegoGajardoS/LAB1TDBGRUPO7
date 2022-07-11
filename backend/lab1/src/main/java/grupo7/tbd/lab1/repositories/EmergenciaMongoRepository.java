package grupo7.tbd.lab1.repositories;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import grupo7.tbd.lab1.models.EmergenciaMongo;
public interface EmergenciaMongoRepository{
    public List<Document> getEmergencias();
}