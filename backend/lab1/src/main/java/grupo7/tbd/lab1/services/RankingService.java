package grupo7.tbd.lab1.services;


import grupo7.tbd.lab1.models.Ranking;
import grupo7.tbd.lab1.repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RankingService {
    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }

    //GET ALL
    @GetMapping("/rankings")
    public List<Ranking> getAllRankings() {
        return rankingRepository.getAllRankings();
    }

    //GET BY ID
    @GetMapping("/rankings/{id}")
    public List<Ranking> getRanking(@PathVariable int id) {
        return rankingRepository.getRanking(id);
    }

    //CREATE
    @PostMapping("/rankings")
    @ResponseBody
    public Ranking createRanking(@RequestBody Ranking ranking){
        Ranking result = rankingRepository.createRanking(ranking);
        return result;
    }

    //DELETE
    @DeleteMapping("/rankings/delete/{id}")
    @ResponseBody
    public List<Ranking> deleteRanking(@PathVariable int id){
        rankingRepository.deleteRanking(id);
        return rankingRepository.getAllRankings();
    }
    //UPDATE
    @PutMapping("/rankings/update/{id}")
    @ResponseBody
    public List<Ranking> updateRanking(@RequestBody Ranking ranking, @PathVariable int id){
        rankingRepository.updateRanking(ranking, id);
        return rankingRepository.getAllRankings();
    }
    
}
