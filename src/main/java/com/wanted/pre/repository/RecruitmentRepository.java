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
	@Query("select new com.wanted.pre.vo.RecruitmentsVO(r.recrNo, r.company.comId, r.company.country, r.company.region, r.position, r.money, r.skill) from Recruitment r")
	List<RecruitmentsVO> findRecruitmentsInfomation();
	
	//리스트 중 검색
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
	@Query("select new com.wanted.pre.vo.RecruitmentDetailVO(r.recrNo, r.company.comId, r.company.country, r.company.region, r.position, r.money, r.skill, r.content ) "
			+ "from Recruitment r where "
			+ "recrNo=:recrNo")
	RecruitmentDetailVO findRecruitmentDetail(long recrNo);
	//회사가 올린 다른공고 리스트
	@Query(value = "select recr_no from recruitment r, company c where r.com_id=c.com_id and c.com_id=:comId",nativeQuery = true)
	List<Long> findNecrNoByCompany_ComId(String comId);
	
	//지원내역에 이미 지원한 여부를 판단 > HistoryRepository로 
}
