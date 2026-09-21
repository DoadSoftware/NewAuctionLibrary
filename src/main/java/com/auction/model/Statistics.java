package com.auction.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Statistics")
public class Statistics
{
  @Id
  @Column(name="StatisticsId")
  private Integer statistics_id;
  
  @Column(name="PlayerID")
  private Integer player_id;
  
  @Column(name="StatsTypeId")
  private Integer stats_type_id;
  
  @Column(name="Matches")
  private String Matches;
  
  @Column(name="Runs")
  private String Runs;
  
  @Column(name="Wickets")
  private String Wickets;
  
  @Column(name="StrikeRate")
  private String StrikeRate;
  
  @Column(name="Economy")
  private String Economy;
  
  @Column(name="Info1")
  private String info1;
  
  @Column(name="Info2")
  private String info2;
  
  @Column(name="Info3")
  private String info3;
  
  @Column(name="Info4")
  private String info4;
  
  @Column(name="Rank")
  private String rank;
  
  @Column(name="BestRank")
  private String best_rank;
  
  @Column(name="UTT_Assignment")
  private String utt_assignment;
  
  @Column(name="BatAvg")
  private String batAvg;
  
  @Column(name="BowlAvg")
  private String bowlAvg;
  
  @Column(name="Best_Figure")
  private String best_Figure;
  
  @Column(name="Best_Score")
  private String best_Score;
  
  public String getBest_rank() {
	return best_rank;
}

public void setBest_rank(String best_rank) {
	this.best_rank = best_rank;
}

public String getUtt_assignment() {
	return utt_assignment;
}

public void setUtt_assignment(String utt_assignment) {
	this.utt_assignment = utt_assignment;
}

@Column(name="Style")
  private String style;
  
  @Column(name="Grip")
  private String grip;
  
  @Column(name="Age")
  private Integer age;

  @Column(name="Best")
  private Integer best;

  @Column(name = "MatchWon")
  private Integer matchWon;

  @Column(name = "MatchLost")
  private Integer matchLost;

  @Column(name = "ConsicutiveVictories")
  private Integer consecutiveVictories;

  @Column(name = "Effectiveness")
  private Double effectiveness;

  @Column(name = "Titles")
  private Integer titles;

  @Column(name = "Race")
  private Integer race;

public Integer getStatistics_id() {
	return statistics_id;
}

public void setStatistics_id(Integer statistics_id) {
	this.statistics_id = statistics_id;
}

public Integer getPlayer_id() {
	return player_id;
}

public void setPlayer_id(Integer player_id) {
	this.player_id = player_id;
}

public Integer getStats_type_id() {
	return stats_type_id;
}

public void setStats_type_id(Integer stats_type_id) {
	this.stats_type_id = stats_type_id;
}

public String getMatches() {
	return Matches;
}

public void setMatches(String matches) {
	Matches = matches;
}

public String getRuns() {
	return Runs;
}

public void setRuns(String runs) {
	Runs = runs;
}

public String getWickets() {
	return Wickets;
}

public void setWickets(String wickets) {
	Wickets = wickets;
}

public String getStrikeRate() {
	return StrikeRate;
}

public void setStrikeRate(String strikeRate) {
	StrikeRate = strikeRate;
}

public String getEconomy() {
	return Economy;
}

public void setEconomy(String economy) {
	Economy = economy;
}

public String getInfo1() {
	return info1;
}

public void setInfo1(String info1) {
	this.info1 = info1;
}

public String getInfo2() {
	return info2;
}

public void setInfo2(String info2) {
	this.info2 = info2;
}

public String getInfo3() {
	return info3;
}

public void setInfo3(String info3) {
	this.info3 = info3;
}

public String getInfo4() {
	return info4;
}

public void setInfo4(String info4) {
	this.info4 = info4;
}

public String getRank() {
	return rank;
}

public void setRank(String rank) {
	this.rank = rank;
}

public String getStyle() {
	return style;
}

public void setStyle(String style) {
	this.style = style;
}

public String getGrip() {
	return grip;
}

public void setGrip(String grip) {
	this.grip = grip;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public Integer getBest() {
	return best;
}

public void setBest(Integer best) {
	this.best = best;
}

public Integer getMatchWon() {
	return matchWon;
}

public void setMatchWon(Integer matchWon) {
	this.matchWon = matchWon;
}

public Integer getMatchLost() {
	return matchLost;
}

public void setMatchLost(Integer matchLost) {
	this.matchLost = matchLost;
}

public Integer getConsecutiveVictories() {
	return consecutiveVictories;
}

public void setConsecutiveVictories(Integer consecutiveVictories) {
	this.consecutiveVictories = consecutiveVictories;
}

public Double getEffectiveness() {
	return effectiveness;
}

public void setEffectiveness(Double effectiveness) {
	this.effectiveness = effectiveness;
}

public Integer getTitles() {
	return titles;
}

public void setTitles(Integer titles) {
	this.titles = titles;
}

public Integer getRace() {
	return race;
}

public void setRace(Integer race) {
	this.race = race;
}

public String getBatAvg() {
	return batAvg;
}

public void setBatAvg(String batAvg) {
	this.batAvg = batAvg;
}

public String getBowlAvg() {
	return bowlAvg;
}

public void setBowlAvg(String bowlAvg) {
	this.bowlAvg = bowlAvg;
}

public String getBest_Figure() {
	return best_Figure;
}

public void setBest_Figure(String best_Figure) {
	this.best_Figure = best_Figure;
}

public String getBest_Score() {
	return best_Score;
}

public void setBest_Score(String best_Score) {
	this.best_Score = best_Score;
}

}