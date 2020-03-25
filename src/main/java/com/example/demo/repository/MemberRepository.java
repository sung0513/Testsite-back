package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.*;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m where m.name =  :name")
    List<Member> findByName(String name);


    @Query("SELECT m FROM Member m")
    Member findOne(Long id);
}

