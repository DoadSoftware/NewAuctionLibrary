package com.auction.model;

import java.util.ArrayList;
import java.util.*;

public class PlayerCount extends Team{
	
	int a,b,c,northZone,eastZone,U19,southZone,ind_male,ind_female,for_male,for_female,
		westZone,centralZone,rtm,remaingPurse,expectedPurse,players,purseRemaing,
		senior,emerging,development,icon;
	
	List<Player> Player = new ArrayList<Player>();
	
	Map<String, Integer> category = new HashMap();
	
	Map<String, ArrayList<Player>> playerCategoryWise = new HashMap();
	 
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getNorthZone() {
		return northZone;
	}

	public void setNorthZone(int northZone) {
		this.northZone = northZone;
	}

	public int getEastZone() {
		return eastZone;
	}

	public void setEastZone(int eastZone) {
		this.eastZone = eastZone;
	}

	public int getU19() {
		return U19;
	}

	public void setU19(int u19) {
		U19 = u19;
	}

	public int getSouthZone() {
		return southZone;
	}

	public void setSouthZone(int southZone) {
		this.southZone = southZone;
	}

	public int getWestZone() {
		return westZone;
	}

	public void setWestZone(int westZone) {
		this.westZone = westZone;
	}

	public int getCentralZone() {
		return centralZone;
	}

	public void setCentralZone(int centralZone) {
		this.centralZone = centralZone;
	}

	public int getRtm() {
		return rtm;
	}

	public void setRtm(int rtm) {
		this.rtm = rtm;
	}

	public int getRemaingPurse() {
		return remaingPurse;
	}

	public void setRemaingPurse(int remaingPurse) {
		this.remaingPurse = remaingPurse;
	}

	public int getExpectedPurse() {
		return expectedPurse;
	}

	public void setExpectedPurse(int expectedPurse) {
		this.expectedPurse = expectedPurse;
	}

	public int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}

	public int getPurseRemaing() {
		return purseRemaing;
	}

	public void setPurseRemaing(int remaingPurses) {
		this.purseRemaing = remaingPurses;
	}

	public List<Player> getPlayer() {
		return Player;
	}

	public void setPlayer(List<Player> player) {
		Player = player;
	}

	public int getInd_male() {
		return ind_male;
	}

	public void setInd_male(int ind_male) {
		this.ind_male = ind_male;
	}

	public int getInd_female() {
		return ind_female;
	}

	public void setInd_female(int ind_female) {
		this.ind_female = ind_female;
	}

	public int getFor_male() {
		return for_male;
	}

	public void setFor_male(int for_male) {
		this.for_male = for_male;
	}

	public int getfor_female() {
		return for_female;
	}

	public void setFor_female(int for_female) {
		this.for_female = for_female;
	}

	public Map<String, Integer> getCategory() {
		return category;
	}

	public void setCategory(Map<String, Integer> category) {
		this.category = category;
	}

	public Map<String, ArrayList<Player>> getPlayerCategoryWise() {
		return playerCategoryWise;
	}

	public void setPlayerCategoryWise(Map<String, ArrayList<Player>> playerCategoryWise) {
		this.playerCategoryWise = playerCategoryWise;
	}

	@Override
	public String toString() {
		return "PlayerCount [a=" + a + ", b=" + b + ", c=" + c + ", northZone=" + northZone + ", eastZone=" + eastZone
				+ ", U19=" + U19 + ", southZone=" + southZone + ", ind_male=" + ind_male + ", ind_female=" + ind_female
				+ ", for_male=" + for_male + ", for_female=" + for_female + ", westZone=" + westZone + ", centralZone="
				+ centralZone + ", rtm=" + rtm + ", remaingPurse=" + remaingPurse + ", expectedPurse=" + expectedPurse
				+ ", players=" + players + ", purseRemaing=" + purseRemaing + ", Player=" + Player + ", category="
				+ category + ", playerCategoryWise=" + playerCategoryWise + "]";
	}

}
