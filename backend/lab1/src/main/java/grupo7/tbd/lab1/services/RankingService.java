package grupo7.tbd.lab1.services;


import grupo7.tbd.lab1.models.Ranking;
import grupo7.tbd.lab1.repositories.RankingRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

@CrossOrigin
@RestController
public class RankingService {
    
    private final RankingRepository RankingRepository;
    private final Gson gson;

    RankingService(RankingRepository RankingRepository){
        this.gson = new GsonBuilder().create();
        this.RankingRepository = RankingRepository;
    }

    @GetMapping("/rankings/")
    ResponseEntity<String> getRankings(){
        List<Ranking> Ran = RankingRepository.getRankings() ;
        return new ResponseEntity<>(gson.toJson(Ran),HttpStatus.OK);
    }

    @GetMapping("/rankings/{id}")
    ResponseEntity<String> getRanking(@PathVariable Long id){
        Ranking Ranking = RankingRepository.getRanking(id);
        if(Ranking != null){
            return new ResponseEntity<>(gson.toJson(Ranking),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/rankings/create")
    ResponseEntity<String> createRanking(@RequestBody String request){
        Ranking RankingOut = gson.fromJson(request,Ranking.class);
        if (RankingOut != null){
            RankingOut = RankingRepository.createRanking(RankingOut);
            return new ResponseEntity<>(gson.toJson(RankingOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(origins = {"http://localhost:8080"})
    @ResponseBody
    @RequestMapping(value ="/rankings/{id}",  method =RequestMethod.PUT,consumes="application/json")
    ResponseEntity<String> updateRanking(@RequestBody String request, @PathVariable Long id){
        Ranking rank=gson.fromJson(request,Ranking.class);
        Ranking RankingOut = RankingRepository.getRanking(id);
        if(RankingOut != null){
            if(rank.getvalor() != null){
                RankingOut.setvalor(rank.getvalor());
            }
            if(rank.getId_tarea() != null){
                RankingOut.setId_tarea(rank.getId_tarea());
            }
            if(rank.getId_voluntario() != null){
                RankingOut.setId_voluntario(rank.getId_voluntario());
            }
      
            RankingOut = RankingRepository.updateRanking(RankingOut, id);
            return new ResponseEntity<>(gson.toJson(RankingOut),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/rankings/{id}")
    ResponseEntity<String> deleteRanking(@PathVariable Long id){
        if(RankingRepository.deleteRanking(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
