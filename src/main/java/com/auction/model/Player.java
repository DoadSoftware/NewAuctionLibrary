package com.auction.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;

@Entity
@Table(name = "Players")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Player
{

  @Id
  @Column(name = "PlayerID")
  private int playerId;
  
  @Column(name = "PlayerNumber")
  private String playerNumber;
  
  @Column(name = "FullName")
  private String full_name;

  @Column(name = "FirstName")
  private String firstname;

  @Column(name = "Surname")
  private String surname;
  
  @Column(name = "TickerName")
  private String ticker_name;
  
  @Column(name = "Iconic")
  private String iconic;
  
  @Column(name = "DOB")
  private String dob;
  
  @Column(name = "PlayerPosition")
  private String player_position;
  
  @Column(name = "Rank")
  private String rank;
  
  @Column(name = "Pair")
  private String pair;
  
  @Column(name = "U19") 
  private Integer u19;

  @Column(name = "Role")
  private String role;
  
  @Column(name = "Age")
  private String age;

  @Column(name = "Height")
  private String height;
  
  @Column(name = "Weight")
  private String weight;
  
  @Column(name = "Category")
  private String category;
  
  @Column(name = "Nationality")
  private String nationality;
  
  @Column(name = "BasePrice")
  private String basePrice;
  
  @Column(name = "PhotoName")
  private String photoName;
  
  @Column(name = "BatsmanStyle")
  private String batsmanStyle;
  
  @Column(name = "BowlerStyle")
  private String bowlerStyle;
  
  @Column(name = "Gender")
  private String gender;
  
  @Column(name = "LastYearTeam")
  private Integer lastYearTeam;
  
  @Column(name = "LastYearPrice")
  private Integer lastYearPrice;
 
  @Column(name = "OverseasPlayer")
  private Integer overseasPlayer;
  
  @Column(name = "Members")
  private String members;
  
  @Column(name = "Developement")
  private String developement;

@Transient
  private int teamId;
  
  @Transient
  private Team team;
  
  @Transient
  private int soldForPoints;
  
  @Transient
  private String draftType;
  
  @Transient
  private String categoryType;
  
  @Transient
  private String soldOrUnsold;
  
  @Transient
  private String playersId;
  
  @Column(name = "Draft")
  private String draft;
  
  public Player() {
	 super();
	 this.soldOrUnsold = "";
  }

public Player(int playerId, String full_name, int teamId, int soldForPoints, String soldOrUnsold) {
	super();
	this.playerId = playerId;
	this.full_name = full_name;
	this.teamId = teamId;
	this.soldForPoints = soldForPoints;
	this.soldOrUnsold = soldOrUnsold;
}

public Player(int playerId, String playerNumber, String full_name, String ticker_name, String category,String nationality,
		String photoName, int teamId, int soldForPoints, String soldOrUnsold, String draft,String baseprice, String pair, String gender, String playersId, String draftType, String categoryType,
		String members, String developement) {
	super();
	this.playerId = playerId;
	this.playersId = playersId;
	this.playerNumber = playerNumber;
	this.full_name = full_name;
	this.ticker_name = ticker_name;
	this.category = category;
	this.nationality = nationality;
	this.photoName = photoName;
	this.teamId = teamId;
	this.soldForPoints = soldForPoints;
	this.soldOrUnsold = soldOrUnsold;
	this.draft = draft;
	this.basePrice = baseprice;
	this.pair = pair;
	this.gender = gender;
	this.draftType = draftType;
	this.categoryType = categoryType;
	this.members = members;
	this.developement = developement;
	
}

public String getPlayersId() {
	return playersId;
}

public void setPlayersId(String playersId) {
	this.playersId = playersId;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getPlayer_position() {
	return player_position;
}

public void setPlayer_position(String player_position) {
	this.player_position = player_position;
}

public String getRank() {
	return rank;
}

public void setRank(String rank) {
	this.rank = rank;
}

public String getPair() {
	return pair;
}

public void setPair(String pair) {
	this.pair = pair;
}

public int getPlayerId() {
	return playerId;
}

public void setPlayerId(int playerId) {
	this.playerId = playerId;
}

public String getFull_name() {
	return full_name;
}

public void setFull_name(String full_name) {
	this.full_name = full_name;
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

public Integer getOverseasPlayer() {
	return overseasPlayer;
}

public void setOverseasPlayer(Integer overseasPlayer) {
	this.overseasPlayer = overseasPlayer;
}

public String getTicker_name() {
	return ticker_name;
}

public void setTicker_name(String ticker_name) {
	this.ticker_name = ticker_name;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public String getHeight() {
	return height;
}

public void setHeight(String height) {
	this.height = height;
}

public String getWeight() {
	return weight;
}

public void setWeight(String weight) {
	this.weight = weight;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getNationality() {
	return nationality;
}

public void setNationality(String nationality) {
	this.nationality = nationality;
}

public String getBasePrice() {
	return basePrice;
}

public void setBasePrice(String basePrice) {
	this.basePrice = basePrice;
}

public String getPhotoName() {
	return photoName;
}

public void setPhotoName(String photoName) {
	this.photoName = photoName;
}

public int getTeamId() {
	return teamId;
}

public void setTeamId(int teamId) {
	this.teamId = teamId;
}

public int getSoldForPoints() {
	return soldForPoints;
}

public void setSoldForPoints(int soldForPoints) {
	this.soldForPoints = soldForPoints;
}

public String getDraftType() {
	return draftType;
}

public void setDraftType(String draftType) {
	this.draftType = draftType;
}

public String getCategoryType() {
	return categoryType;
}

public void setCategoryType(String categoryType) {
	this.categoryType = categoryType;
}

public String getSoldOrUnsold() {
	return soldOrUnsold;
}

public void setSoldOrUnsold(String soldOrUnsold) {
	this.soldOrUnsold = soldOrUnsold;
}

public String getPlayerNumber() {
	return playerNumber;
}

public void setPlayerNumber(String playerNumber) {
	this.playerNumber = playerNumber;
}

public String getBatsmanStyle() {
	return batsmanStyle;
}

public void setBatsmanStyle(String batsmanStyle) {
	this.batsmanStyle = batsmanStyle;
}

public String getBowlerStyle() {
	return bowlerStyle;
}

public void setBowlerStyle(String bowlerStyle) {
	this.bowlerStyle = bowlerStyle;
}

public Integer getLastYearTeam() {
	return lastYearTeam;
}

public void setLastYearTeam(Integer lastYearTeam) {
	this.lastYearTeam = lastYearTeam;
}

public Integer getLastYearPrice() {
	return lastYearPrice;
}

public void setLastYearPrice(Integer lastYearPrice) {
	this.lastYearPrice = lastYearPrice;
}

public String getIconic() {
	return iconic;
}

public void setIconic(String iconic) {
	this.iconic = iconic;
}

public Integer getU19() {
	return u19;
}

public void setU19(Integer u19) {
	this.u19 = u19;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}


public String getDraft() {
	return draft;
}

public void setDraft(String draft) {
	this.draft = draft;
}

public Team getTeam() {
	return team;
}

public void setTeam(Team team) {
	this.team = team;
}

public String getMembers() {
	return members;
}

public void setMembers(String members) {
	this.members = members;
}

public String getDevelopement() {
	return developement;
}

public void setDevelopement(String developement) {
	this.developement = developement;
}

@Override
public String toString() {
	return "Player [playerId=" + playerId + ", playerNumber=" + playerNumber + ", full_name=" + full_name
			+ ", firstname=" + firstname + ", surname=" + surname + ", ticker_name=" + ticker_name + ", iconic="
			+ iconic + ", dob=" + dob + ", player_position=" + player_position + ", rank=" + rank + ", pair=" + pair
			+ ", u19=" + u19 + ", role=" + role + ", age=" + age + ", height=" + height + ", weight=" + weight
			+ ", category=" + category + ", nationality=" + nationality + ", basePrice=" + basePrice + ", photoName="
			+ photoName + ", batsmanStyle=" + batsmanStyle + ", bowlerStyle=" + bowlerStyle + ", gender=" + gender
			+ ", lastYearTeam=" + lastYearTeam + ", lastYearPrice=" + lastYearPrice + ", overseasPlayer="
			+ overseasPlayer + ", members=" + members + ", developement=" + developement + ", teamId=" + teamId
			+ ", team=" + team + ", soldForPoints=" + soldForPoints + ", draftType=" + draftType + ", categoryType="
			+ categoryType + ", soldOrUnsold=" + soldOrUnsold + ", playersId=" + playersId + ", draft=" + draft + "]";
}

}