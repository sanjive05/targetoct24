package com.challengeoct1.monthlychallengeapplication;

import org.apache.tomcat.util.collections.SynchronizedStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public class ChallengeService {

    @Autowired
    ChallengeRepository repository ;

    private static long id=1l;

    public ChallengeService(){
        try {
            System.out.println("Inside Servive" + repository.findLastAddreddId());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public List<Challenge> getAllChallenges(){
        this.id=repository.findLastAddreddId();
        return repository.findAll();
    }
    public boolean setChallenge(Challenge challenge){
        challenge.setId(++id);
        repository.save(challenge);
        return challenge !=null ? true :false ;
    }

    public Challenge getAChallenge(String month) {
        Optional<Challenge> challenge1 = Optional.ofNullable(repository.findByMonthIgnoreCase(month));
        return challenge1.orElse(null);
    }

    public boolean updateChallenge(Challenge challenge,Long id) {
        Optional<Challenge> challenge1 = repository.findById(id);
        if(challenge1.isPresent()){
            Challenge challengeToUpdate = challenge1.get();
            challengeToUpdate.setMonth(challenge.getMonth());
            challengeToUpdate.setDescription(challenge.getDescription());
            repository.save(challengeToUpdate);
            return true;
        }

        return false;
    }

    public boolean deleteChallenge(Long id) {
        Optional<Challenge> challenge1 = repository.findById(id);
        if(challenge1.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
