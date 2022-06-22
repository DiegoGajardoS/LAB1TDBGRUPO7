/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Ranking;
import java.util.List;

public interface RankingRepository {
    
    public Ranking createRanking(Ranking ranking);
    public List<Ranking> getRankings();  
    public Ranking getRanking(Long id);
    public Ranking updateRanking(Ranking ranking, Long id);
    public boolean deleteRanking(Long id);
    public Long countRanking();
}
