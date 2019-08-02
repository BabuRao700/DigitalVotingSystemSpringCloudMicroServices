package com.digitalvoting.informationservice;

import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller("/digitalVoting")
public class InfoController {

    @RequestMapping(path = "/getAllPartyInfo", method = RequestMethod.GET)
    public ResponseEntity getPartyData() {
        List<Party> partyList = getMockPartyData();
        return new ResponseEntity(partyList, HttpStatus.OK);
    }

    @RequestMapping(path = "/saveVote", method = RequestMethod.POST)
    public ResponseEntity saveVote(@RequestBody String castedParty) {
        //save in database;
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity(castedParty);
        template.postForEntity("http://localhost:8091/saveVote", request, String.class);

        return new ResponseEntity(castedParty, HttpStatus.OK);
    }

    @RequestMapping(path = "/getVoteCount", method = RequestMethod.GET)
    public ResponseEntity getVoteCount() {
        RestTemplate template = new RestTemplate();
        List<Vote> vote = template.getForObject("http://localhost:8091/getAllVoteCount", List.class);
        return new ResponseEntity(vote, HttpStatus.OK);
    }

    private List<Party> getMockPartyData() {
        List<Party> partyList = new ArrayList<>();
        Party party1 = new Party(1, "TDP");
        Party party2 = new Party(2, "YSRCP");
        Party party3 = new Party(3, "JSP");

        partyList.add(party1);
        partyList.add(party2);
        partyList.add(party3);

        return partyList;
    }

}
