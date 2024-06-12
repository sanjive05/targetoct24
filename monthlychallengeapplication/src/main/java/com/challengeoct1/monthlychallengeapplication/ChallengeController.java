package com.challengeoct1.monthlychallengeapplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Challenge> getChallenge(){
        return new ResponseEntity(challengeService.getAllChallenges(), HttpStatus.OK);
    }
    @PostMapping("/challenges")
    public ResponseEntity<String> setChallenge(@RequestBody Challenge challenge){
        if(challengeService.setChallenge(challenge)) {
            return new ResponseEntity("Challenge added Successfully...",HttpStatus.OK);
        }
        return new ResponseEntity<>("Sorry something went wrong",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getAChallenge(@PathVariable String month){
        if(challengeService.getAChallenge(month) != null){
            return new ResponseEntity(challengeService.getAChallenge(month),HttpStatus.OK);
        }
        return new ResponseEntity(null,HttpStatus.NOT_FOUND);
    }
}
