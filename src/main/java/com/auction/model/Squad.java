package com.auction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Squads")
public class Squad
{
  @Id
  @Column(name = "SquadId")
  private int squadId;
  
  @Column(name="PlayerID")
  private Integer player_id;

  @Column(name = "FIRSTNAME")
  private String firstname;

  @Column(name = "SURNAME")
  private String surname;
  
  @Column(name = "Age")
  private Integer age;
  
  @Column(name = "BOWLINGSTYLE")
  private String bowlingStyle;
  
  @Column(name = "BATTINGSTYLE")
  private String battingStyle;
  
  @Column(name = "TEAMID")
  private Integer teamId;
  
  @Column(name = "ROLE")
  private String role;

public Squad() {
	super();
	// TODO Auto-generated constructor stub
}

public int getSquadId() {
	return squadId;
}

public void setSquadId(int squadId) {
	this.squadId = squadId;
}

public Integer getPlayer_id() {
	return player_id;
}

public void setPlayer_id(Integer player_id) {
	this.player_id = player_id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getSurname() {
	return surname;
}

public void setSurname(String surname) {
	this.surname = surname;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public String getBowlingStyle() {
	return bowlingStyle;
}

public void setBowlingStyle(String bowlingStyle) {
	this.bowlingStyle = bowlingStyle;
}

public String getBattingStyle() {
	return battingStyle;
}

public void setBattingStyle(String battingStyle) {
	this.battingStyle = battingStyle;
}

public Integer getTeamId() {
	return teamId;
}

public void setTeamId(Integer teamId) {
	this.teamId = teamId;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

@Override
public String toString() {
	return "Squad [squadId=" + squadId + ", firstname=" + firstname + ", surname=" + surname + ", age=" + age
			+ ", bowlingStyle=" + bowlingStyle + ", battingStyle=" + battingStyle + ", teamId=" + teamId + ", role="
			+ role + "]";
}
 
}