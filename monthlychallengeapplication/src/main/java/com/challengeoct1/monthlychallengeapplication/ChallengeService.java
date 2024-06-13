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

    public boolean updateChallenge(Challenge challenge,Long id) {

        for(Challenge challenge1:this.challenge){
            if(challenge1.getId()==id) {
                challenge1.setMonth(challenge.getMonth());
                challenge1.setDescription(challenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        for(Challenge challenge1:this.challenge){
            if(challenge1.getId()==id) {
                this.challenge.remove(challenge1);
                return true;
            }
        }
        return false;
    }
}
