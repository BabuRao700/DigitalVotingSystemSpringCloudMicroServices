package com.digitalvoting.votingservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "VOTE_COUNT")
public class Vote implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "party_id")
    private int partyId;

    @Column(name = "party_name")
    private String partyName;

    @Column(name = "vote_count")
    private int numberOfVotes;

    public Vote() {
    }

    public Vote(int partyId, String partyName, int numberOfVotes) {
        this.partyId = partyId;
        this.partyName = partyName;
        this.numberOfVotes = numberOfVotes;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
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

}
