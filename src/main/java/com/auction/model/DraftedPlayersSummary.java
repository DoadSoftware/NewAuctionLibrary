package com.auction.model;

import java.util.List;

public class DraftedPlayersSummary {

    private String success;
    private String message;
    private String header;
    private Data data;
    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private List<TeamWise> teamWise;
        private List<RoundWise> roundWise;
        
        public List<TeamWise> getTeamWise() {
            return teamWise;
        }

        public void setTeamWise(List<TeamWise> teamWise) {
            this.teamWise = teamWise;
        }
        public List<RoundWise> getRoundWise() {
            return roundWise;
        }

        public void setRoundWise(List<RoundWise> roundWise) {
            this.roundWise = roundWise;
        }
    }
}