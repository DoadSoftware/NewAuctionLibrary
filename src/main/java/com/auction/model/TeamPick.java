package com.auction.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TeamPick {

	private int teamId;
	private String teamName;
	private String teamStatus;
	private int pickOrder;
	private int passCount;
	private List<String> passLog;
	private List<Player> pickList;

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

	public String getTeamStatus() {
		return teamStatus;
	}

	public void setTeamStatus(String teamStatus) {
		this.teamStatus = teamStatus;
	}

	public int getPickOrder() {
		return pickOrder;
	}

	public void setPickOrder(int pickOrder) {
		this.pickOrder = pickOrder;
	}

	public List<Player> getPickList() {
		return pickList;
	}

	public void setPickList(List<Player> pickList) {
		this.pickList = pickList;
	}

	public int getPassCount() {
		return passCount;
	}

	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

	public List<String> getPassLog() {
		return passLog;
	}

	public void setPassLog(List<String> passLog) {
		this.passLog = passLog;
	}

	@Override
	public String toString() {
		return "TeamPick [teamId=" + teamId + ", teamName=" + teamName + ", teamStatus=" + teamStatus
				+ ", pickOrder=" + pickOrder + ", pickList=" + pickList + "]";
	}
}