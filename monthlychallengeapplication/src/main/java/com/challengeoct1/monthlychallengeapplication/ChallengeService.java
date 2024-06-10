package com.challengeoct1.monthlychallengeapplication;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenge = new ArrayList<>();
    private long id=1l;
    public ChallengeService(){

    }
    public List<Challenge> getAllChallenges(){
        return challenge;
    }
    public boolean setChallenge(Challenge challenge){
        challenge.setId(id++);
        this.challenge.add(challenge);
        return challenge !=null ? true :false ;
    }

    public Challenge getAChallenge(String month) {
        for(Challenge ch : challenge){
            if(ch.getMonth().equals(month)){
                return ch;
            }
        }
        return null;
    }
}
