package com.auction.model;

import java.util.List;

public class TeamWise {

    private int teamId;
    private String teamName;
    private List<DraftedPlayer> players;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<DraftedPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<DraftedPlayer> players) {
        this.players = players;
    }

	@Override
	public String toString() {
		return "TeamWise [teamId=" + teamId + ", teamName=" + teamName + ", players=" + players + "]";
	}
    
    
}