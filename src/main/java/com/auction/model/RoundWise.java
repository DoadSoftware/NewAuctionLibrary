package com.auction.model;

import java.util.List;

public class RoundWise {

    private int roundNo;
    private String roundName;
    private List<DraftedPlayer> players;

    public int getRoundNo() {
        return roundNo;
    }

    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public List<DraftedPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<DraftedPlayer> players) {
        this.players = players;
    }

	@Override
	public String toString() {
		return "RoundWise [roundNo=" + roundNo + ", roundName=" + roundName + ", players=" + players + "]";
	}
    
    
}