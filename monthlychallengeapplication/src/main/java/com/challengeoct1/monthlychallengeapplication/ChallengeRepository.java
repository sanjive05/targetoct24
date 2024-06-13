package com.challengeoct1.monthlychallengeapplication;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository <Challenge , Long>{

    Challenge findByMonthIgnoreCase(String month);
}