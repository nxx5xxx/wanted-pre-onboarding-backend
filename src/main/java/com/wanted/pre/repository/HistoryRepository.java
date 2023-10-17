package com.wanted.pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wanted.pre.entity.History;

public interface HistoryRepository extends JpaRepository<History, Long>{
	//지원내역에 이미 지원한 여부를 판단
	@Query("select h from History h where h.recruitment.recrNo = :recrNo and h.member.memberId = :memberId")
	History findHisNoByRecrNoAndMemberId(long recrNo,String memberId);

}
