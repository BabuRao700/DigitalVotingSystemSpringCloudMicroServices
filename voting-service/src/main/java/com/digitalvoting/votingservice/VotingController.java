package com.digitalvoting.votingservice;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller("/vote")
public class VotingController {

    @Autowired
    private VoteRepository repository;

    @RequestMapping(path = "/saveVote",
            method = RequestMethod.POST)
    public ResponseEntity saveVote(@RequestBody String partyJson) {
        try {
            Party party = new Gson().fromJson(partyJson, Party.class);
            Vote vote = repository.findById(party.getPartyId())
                    .orElse(new Vote(party.getPartyId(), party.getPartyName(), 0));
            vote.setNumberOfVotes(vote.getNumberOfVotes() + 1);

            repository.save(vote);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/getAllVoteCount",
            method = RequestMethod.GET,
            produces =   { "application/json" })
    public ResponseEntity getAllVoteCount() {
        List<Vote> allVotes = repository.findAll();
        return new ResponseEntity(allVotes, HttpStatus.OK);
    }
}
