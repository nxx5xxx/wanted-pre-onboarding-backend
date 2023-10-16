package com.wanted.pre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.vo.RecruitmentsVO;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long>{
//	"채용공고_id": 채용공고_id,
//	  "회사명":"원티드랩",
//	  "국가":"한국",
//	  "지역":"서울",
//	  "채용포지션":"백엔드 주니어 개발자",
//	  "채용보상금":1500000,
//	  "사용기술":"Python"
	@Query("select new com.wanted.pre.vo.RecruitmentsVO(r.recrNo, c.comId, c.country, c.region, r.position, r.money, r.skill) from Recruitment r, Company c where r.comId = c.comId")
	List<RecruitmentsVO> findRecruitmentsInfomation();
}
