package io.vinwork.ipldashboard.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.vinwork.ipldashboard.model.Match;
import io.vinwork.ipldashboard.model.Team;
import io.vinwork.ipldashboard.repository.MatchRepository;
import io.vinwork.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {

 
    private TeamRepository teamRepository;

    private MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository){
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }
    
    @GetMapping("/team/{teamName}")
    public Team getteam(@PathVariable String teamName){

        Team team = this.teamRepository.findByTeamName(teamName);

        List<Match> matches = this.matchRepository.findLatestMatchByTeam(teamName, 4);
        team.setMatches(matches);

        return team;

    }
}
