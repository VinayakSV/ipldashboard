package io.vinwork.ipldashboard.data;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import io.vinwork.ipldashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

  @Override
  public Match process(final MatchInput matchInput) throws Exception {
    
    log.info("As part of batch the processing start here...");

    Match match = new Match();

    match.setId(Long.parseLong(matchInput.getId()));
    match.setCity(matchInput.getCity());
    match.setDate(LocalDate.parse(matchInput.getDate()));
    match.setPlayerOfMatch(matchInput.getPlayer_of_match());
    match.setVenue(matchInput.getVenue());

    // Set Team 1 and team 2 depending on the innings order
    String firstInningsTeam, secondInningsteam;
    if(matchInput.getToss_decision().equalsIgnoreCase("bat")){
        firstInningsTeam = matchInput.getToss_winner();
        secondInningsteam = matchInput.getToss_winner().equals(match.getTeam1())
        ? matchInput.getTeam2() : matchInput.getTeam1();
    }else{
        secondInningsteam = matchInput.getToss_winner();
        firstInningsTeam = matchInput.getToss_winner().equals(match.getTeam1())
        ? matchInput.getTeam2() : matchInput.getTeam1();
    }

    match.setTeam1(firstInningsTeam);
    match.setTeam2(secondInningsteam);
    match.setTossWinner(matchInput.getToss_winner());
    match.setTossDecision(matchInput.getToss_decision());
    match.setMatchWinner(matchInput.getWinner());
    match.setResult(matchInput.getResult());
    match.setResultMargin(matchInput.getResult_margin());
    match.setUmpire1(matchInput.getUmpire1());
    match.setUmpire2(matchInput.getUmpire2());

    log.info("As part of batch the processing ends here...");

    return match;
  }

}
