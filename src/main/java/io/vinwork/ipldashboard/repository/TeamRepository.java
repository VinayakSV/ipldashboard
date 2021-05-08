package io.vinwork.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.vinwork.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
    
    Team findByTeamName(String teamName);
}
