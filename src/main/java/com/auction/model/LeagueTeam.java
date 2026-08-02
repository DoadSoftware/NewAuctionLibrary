package com.auction.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LeagueTeam")
@XmlAccessorType(XmlAccessType.FIELD)
public class LeagueTeam {

	@XmlElement(name="TeamName")
	private String TeamName;

	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	
}
