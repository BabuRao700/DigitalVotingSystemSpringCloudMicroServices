package com.digitalvoting.informationservice;

public class Vote {
    private int partyId;

    private String partyName;

    private int numberOfVotes;

    Vote () {

    }

    public Vote(int partyId, String partyName, int numberOfVotes) {
        this.partyId = partyId;
        this.partyName = partyName;
        this.numberOfVotes = numberOfVotes;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }
}
