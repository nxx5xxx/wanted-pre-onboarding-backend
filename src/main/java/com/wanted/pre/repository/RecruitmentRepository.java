package com.wanted.pre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.vo.RecruitmentsVO;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long>{
	//공고리스트
	@Query("select new com.wanted.pre.vo.RecruitmentsVO(r.recrNo, c.comId, c.country, c.region, r.position, r.money, r.skill) from Recruitment r, Company c where r.comId = c.comId")
	List<RecruitmentsVO> findRecruitmentsInfomation();
	
	//리스트 중 검색
	@Query("select new com.wanted.pre.vo.RecruitmentsVO(r.recrNo, c.comId, c.country, c.region, r.position, r.money, r.skill) "
			+ "from Recruitment r, Company c where r.comId = c.comId AND "
			+ "(r.comId Like %:search% "
			+ "OR c.country Like %:search% "
			+ "OR c.region Like %:search% "
			+ "OR r.money Like %:search% "
			+ "OR r.position Like %:search% "
			+ "OR r.skill Like %:search%) ")
	List<RecruitmentsVO> searchRecruitments(String search);
	
	
}
