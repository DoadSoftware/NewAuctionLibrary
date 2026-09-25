package com.auction.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DraftedPlayer {

    @JsonProperty("RefPlayerId")
    private String refPlayerId;

    @JsonProperty("FSAId")
    private long fsaId;

    @JsonProperty("PlayerName")
    private String playerName;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("ShortName")
    private String shortName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Age")
    private Integer age;

    @JsonProperty("Role")
    private String role;

    @JsonProperty("Category")
    private String category;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("RoundNo")
    private int roundNo;

    @JsonProperty("RoundNumber")
    private int roundNumber;

    @JsonProperty("RoundName")
    private String roundName;

    @JsonProperty("Batting")
    private String batting;

    @JsonProperty("Bowling")
    private String bowling;

    @JsonProperty("BattingPrefix")
    private String battingPrefix;

    @JsonProperty("BowlingPrefix")
    private String bowlingPrefix;

    @JsonProperty("Achievements")
    private String achievements;

    @JsonProperty("Height")
    private Double height;

    @JsonProperty("Weight")
    private Double weight;

    @JsonProperty("Drafted")
    private int drafted;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("DraftedTeamId")
    private int draftedTeamId;

    @JsonProperty("DraftedTeam")
    private String draftedTeam;


    public String getRefPlayerId() {
        return refPlayerId;
    }

    public void setRefPlayerId(String refPlayerId) {
        this.refPlayerId = refPlayerId;
    }


    public long getFSAId() {
        return fsaId;
    }

    public void setFSAId(long fsaId) {
        this.fsaId = fsaId;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public int getRoundNo() {
        return roundNo;
    }

    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }


    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }


    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }


    public String getBatting() {
        return batting;
    }

    public void setBatting(String batting) {
        this.batting = batting;
    }


    public String getBowling() {
        return bowling;
    }

    public void setBowling(String bowling) {
        this.bowling = bowling;
    }


    public String getBattingPrefix() {
        return battingPrefix;
    }

    public void setBattingPrefix(String battingPrefix) {
        this.battingPrefix = battingPrefix;
    }


    public String getBowlingPrefix() {
        return bowlingPrefix;
    }

    public void setBowlingPrefix(String bowlingPrefix) {
        this.bowlingPrefix = bowlingPrefix;
    }


    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }


    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }


    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    public int getDrafted() {
        return drafted;
    }

    public void setDrafted(int drafted) {
        this.drafted = drafted;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getDraftedTeamId() {
        return draftedTeamId;
    }

    public void setDraftedTeamId(int draftedTeamId) {
        this.draftedTeamId = draftedTeamId;
    }


    public String getDraftedTeam() {
        return draftedTeam;
    }

    public void setDraftedTeam(String draftedTeam) {
        this.draftedTeam = draftedTeam;
    }

	@Override
	public String toString() {
		return "DraftedPlayer [refPlayerId=" + refPlayerId + ", fsaId=" + fsaId + ", playerName=" + playerName
				+ ", firstName=" + firstName + ", shortName=" + shortName + ", lastName=" + lastName + ", age=" + age
				+ ", role=" + role + ", category=" + category + ", country=" + country + ", roundNo=" + roundNo
				+ ", roundNumber=" + roundNumber + ", roundName=" + roundName + ", batting=" + batting + ", bowling="
				+ bowling + ", battingPrefix=" + battingPrefix + ", bowlingPrefix=" + bowlingPrefix + ", achievements="
				+ achievements + ", height=" + height + ", weight=" + weight + ", drafted=" + drafted + ", status="
				+ status + ", draftedTeamId=" + draftedTeamId + ", draftedTeam=" + draftedTeam + "]";
	}

}
