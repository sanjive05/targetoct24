package com.challengeoct1.monthlychallengeapplication;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChallengeRepository extends JpaRepository <Challenge , Long>{

    Challenge findByMonthIgnoreCase(String month);

    @Query(nativeQuery = true, value = "SELECT count(id) from challenge")
    int findLastAddreddId();
}