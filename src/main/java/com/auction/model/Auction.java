package com.auction.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Auction {
  private List<Team> team;
  private List<Player> players;
  private Player currentPlayers;
  private Clock clock;
  
  
  private List<Player> playersList;
  
  private List<PlayerCount> TeamZoneList;
  
  private List<TeamPick> pick;

  private boolean pickActive;
  
	private String currentRound = "";
	private String currentCategory = "";
	private String currentTeamPick = "";
  
public List<Team> getTeam() {
	return team;
}

public void setTeam(List<Team> team) {
	this.team = team;
}

public List<Player> getPlayers() {
	return players;
}

public void setPlayers(List<Player> players) {
	this.players = players;
}

public List<Player> getPlayersList() {
	return playersList;
}

public void setPlayersList(List<Player> playersList) {
	this.playersList = playersList;
}

public Player getCurrentPlayers() {
	return currentPlayers;
}

public void setCurrentPlayers(Player currentPlayers) {
	this.currentPlayers = currentPlayers;
}

public List<PlayerCount> getTeamZoneList() {
	return TeamZoneList;
}

public void setTeamZoneList(List<PlayerCount> teamZoneList) {
	TeamZoneList = teamZoneList;
}


public List<TeamPick> getPick() {
	return pick;
}

public void setPick(List<TeamPick> pick) {
	this.pick = pick;
}

public boolean isPickActive() {
	return pickActive;
}

public void setPickActive(boolean pickActive) {
	this.pickActive = pickActive;
}

public Clock getClock() {
	return clock;
}

public void setClock(Clock clock) {
	this.clock = clock;
}

public String getCurrentRound() {
	return currentRound;
}

public void setCurrentRound(String currentRound) {
	this.currentRound = currentRound;
}

public String getCurrentCategory() {
	return currentCategory;
}

public void setCurrentCategory(String currentCategory) {
	this.currentCategory = currentCategory;
}

public String getCurrentTeamPick() {
	return currentTeamPick;
}

public void setCurrentTeamPick(String currentTeamPick) {
	this.currentTeamPick = currentTeamPick;
}


}