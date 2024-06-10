package com.challengeoct1.monthlychallengeapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
    private List<Challenge> challenge = new ArrayList<>();
    public ChallengeController(){
        Challenge challenge1 = new Challenge();
        challenge1.setId(1001);
        challenge1.setMonth("January");
        challenge1.setDescription("Complete this spring boot course...");
        challenge.add(challenge1);
    }
    @GetMapping("/challenges")
    public List<Challenge> getChallenge(){
        return challenge;
    }
    @PostMapping("/challenges")
    public String setChallenge(@RequestBody Challenge challenge){
        this.challenge.add(challenge);
        return "Challenge added Successfully...";
    }
}
