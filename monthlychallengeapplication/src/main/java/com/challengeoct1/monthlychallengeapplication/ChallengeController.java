package com.challengeoct1.monthlychallengeapplication;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
    private ChallengeService challengeService;
    public ChallengeController(ChallengeService challengeService){
        this.challengeService=challengeService;

    }
    @GetMapping("/challenges")
    public List<Challenge> getChallenge(){
        return challengeService.getAllChallenges();
    }
    @PostMapping("/challenges")
    public String setChallenge(@RequestBody Challenge challenge){
        if(challengeService.setChallenge(challenge)) {
            return "Challenge added Successfully...";
        }
        return "Sorry something went wrong";
    }
    @GetMapping("/challenges/{month}")
    public Challenge getAChallenge(@PathVariable String month){
        return challengeService.getAChallenge(month);
    }
}
