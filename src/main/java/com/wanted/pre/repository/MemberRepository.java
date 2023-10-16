package com.wanted.pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wanted.pre.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

}
