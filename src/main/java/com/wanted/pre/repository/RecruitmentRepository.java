package com.wanted.pre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.vo.RecruitmentDetailVO;
import com.wanted.pre.vo.RecruitmentsVO;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Long>{
	//공고리스트
//	@Query("select new com.wanted.pre.vo.RecruitmentsVO(r.recrNo, c.comId, c.country, c.region, r.position, r.money, r.skill) from Recruitment r, Company c where r.comId = c.comId")
//	List<RecruitmentsVO> findRecruitmentsInfomation();
	@Query("select new com.wanted.pre.vo.RecruitmentsVO(r.recrNo, r.company.comId, r.company.country, r.company.region, r.position, r.money, r.skill) from Recruitment r")
	List<RecruitmentsVO> findRecruitmentsInfomation();

	
	//리스트 중 검색
//	@Query("select new com.wanted.pre.vo.RecruitmentsVO(r.recrNo, c.comId, c.country, c.region, r.position, r.money, r.skill) "
//			+ "from Recruitment r, Company c where r.comId = c.comId AND "
//			+ "(r.comId Like %:search% "
//			+ "OR c.country Like %:search% "
//			+ "OR c.region Like %:search% "
//			+ "OR r.money Like %:search% "
//			+ "OR r.position Like %:search% "
//			+ "OR r.skill Like %:search%) ")
//	List<RecruitmentsVO> searchRecruitments(String search);
	@Query("select new com.wanted.pre.vo.RecruitmentsVO(r.recrNo, r.company.comId, r.company.country, r.company.region, r.position, r.money, r.skill) "
	+ "from Recruitment r where "
	+ "(r.company.comId Like %:search% "
	+ "OR r.company.country Like %:search% "
	+ "OR r.company.region Like %:search% "
	+ "OR r.money Like %:search% "
	+ "OR r.position Like %:search% "
	+ "OR r.skill Like %:search%) ")
	List<RecruitmentsVO> searchRecruitments(String search);
	
	//공고상세
//	@Query("select new com.wanted.pre.vo.RecruitmentDetailVO(r.recrNo, r.company.comId, r.company.country, r.company.region, r.position, r.money, r.skill, r.content, r.company.recrList) "
//			+ "from Recruitment r where "
//			+ "recrNo=:recrNo")
//	List<RecruitmentDetailVO> findRecruitmentDetail(long recrNo);
	@Query("select new com.wanted.pre.vo.RecruitmentDetailVO(r.recrNo, r.company.comId, r.company.country, r.company.region, r.position, r.money, r.skill, r.content) "
			+ "from Recruitment r where "
			+ "recrNo=:recrNo")
	List<RecruitmentDetailVO> findRecruitmentDetail(long recrNo);

}
