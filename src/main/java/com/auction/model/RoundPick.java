package com.auction.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoundPick {
	private String pickRound;
	private int pickOrder;
	private int teamId;
	private String teamName;
	
	
	public String getPickRound() {
		return pickRound;
	}
	public void setPickRound(String pickRound) {
		this.pickRound = pickRound;
	}
	public int getPickOrder() {
		return pickOrder;
	}
	public void setPickOrder(int pickOrder) {
		this.pickOrder = pickOrder;
	}
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

	
}