package grupo7.tbd.lab1.repositories;

import java.util.List;
import org.bson.Document;
import grupo7.tbd.lab1.models.TareaMongo;

public interface TareaMongoRepository{
    public List<Document> getTareas(Long id_emergencia);
}
