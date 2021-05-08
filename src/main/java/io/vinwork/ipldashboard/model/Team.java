package io.vinwork.ipldashboard.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String teamName;
    private long totalMatchs;
    private long totalWins;

    @Transient
    private List<Match> matches;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public long getTotalMatchs() {
        return totalMatchs;
    }
    public void setTotalMatchs(long totalMatchs) {
        this.totalMatchs = totalMatchs;
    }
    public long getTotalWins() {
        return totalWins;
    }
    public void setTotalWins(long totalWins) {
        this.totalWins = totalWins;
    }
    public Team(String teamName, long totalMatchs) {
        this.teamName = teamName;
        this.totalMatchs = totalMatchs;
    }

    public List<Match> getMatches() {
        return matches;
    }
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
    public Team() {
    }
    
    @Override
    public String toString() {
        return "Team [id=" + id + ", teamName=" + teamName + ", totalMatchs=" + totalMatchs + ", totalWins=" + totalWins
                + "]";
    }
    
    
}
