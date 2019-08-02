package com.digitalvoting.informationservice;


public class Party {

    private int partyId;

    private String partyName;

    public void Party() {
    }

    public Party(int partyId, String partyName) {
        this.partyId = partyId;
        this.partyName = partyName;
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
}
