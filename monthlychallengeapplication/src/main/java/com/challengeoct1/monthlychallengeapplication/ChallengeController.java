package com.challengeoct1.monthlychallengeapplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeController {
    private ChallengeService challengeService;
    public ChallengeController(ChallengeService challengeService){
        this.challengeService=challengeService;

    }
    @GetMapping
    public ResponseEntity<Challenge> getChallenge(){
        return new ResponseEntity(challengeService.getAllChallenges(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> setChallenge(@RequestBody Challenge challenge){
        if(challengeService.setChallenge(challenge)) {
            return new ResponseEntity("Challenge added Successfully...",HttpStatus.OK);
        }
        return new ResponseEntity<>("Sorry something went wrong",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getAChallenge(@PathVariable String month){
        if(challengeService.getAChallenge(month) != null){
            return new ResponseEntity(challengeService.getAChallenge(month),HttpStatus.OK);
        }
        return new ResponseEntity(null,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAChallenge(@PathVariable Long id,@RequestBody Challenge challenge){
        if(challengeService.updateChallenge(challenge,id)){
            return new ResponseEntity<>("Challenge updated successfully... ",HttpStatus.OK);
        }
        return new ResponseEntity<>("challenge not found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAChallenge(@PathVariable Long id ){
        if(challengeService.deleteChallenge(id)){
            return new ResponseEntity<>("Challenge deleted successfully...",HttpStatus.OK);
        }
        return new ResponseEntity<>("challenge not found",HttpStatus.NOT_FOUND);
    }
}
