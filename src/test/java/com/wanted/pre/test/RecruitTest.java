package com.wanted.pre.test;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wanted.pre.entity.History;
import com.wanted.pre.entity.Member;
import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.repository.CompanyRepository;
import com.wanted.pre.repository.HistoryRepository;
import com.wanted.pre.repository.RecruitmentRepository;
import com.wanted.pre.vo.RecruitmentDetailAddListVO;
import com.wanted.pre.vo.RecruitmentDetailVO;
import com.wanted.pre.vo.RecruitmentsVO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class RecruitTest {
	@Autowired
	RecruitmentRepository reRepo;
	@Autowired
	CompanyRepository comRepo;
	@Autowired
	HistoryRepository hisRepo;
	
	@Test
	@DisplayName("채용공고 등록 테스트")
	void insertRecruit() {
		Recruitment recr = new Recruitment();
		recr.setCompany(comRepo.findByComId("원티드"));
		recr.setPosition("백엔드 주니어 개발자");
		recr.setMoney(1000000);
		recr.setContent("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..");
		recr.setSkill("Python");
		reRepo.save(recr);
	}
	
	@Test
	@DisplayName("채용 수정 테스트")
	void updateRecruit() {
		Recruitment recr = reRepo.findById((long)1).orElseThrow();
		recr.setContent("원티드랩에서 백엔드 주니어 개발자를 '적극'채용합니다. 자격요건은..");
		reRepo.save(recr);
	}
	
	@Test
	@DisplayName("채용 공고 삭제 테스트")
	void deleteRecruit() {
		Recruitment recr = reRepo.findById((long)2).orElseThrow();
		reRepo.delete(recr);
	}
	
	@Test
	@DisplayName("채용 공고 목록 테스트")
	void findRecruitmentsInfomation() {
		List<RecruitmentsVO> list = reRepo.findRecruitmentsInfomation();
		for(RecruitmentsVO data : list)log.info(data);
	}
	
	@Test
	@DisplayName("채용 공고 목록 중 검색")
	void search() {
		String search = "원티드";
		List<RecruitmentsVO> list = reRepo.searchRecruitments(search);
		for(RecruitmentsVO data : list)log.info(data);
	}
	@Test
	@DisplayName("채용 공고 상세페이지 + 회사가 올린 다른 리스트")
	void recruitmentDetail() {
		long recrNo = 1;
		RecruitmentDetailVO rvo = reRepo.findRecruitmentDetail(recrNo);
		RecruitmentDetailAddListVO rlvo = new RecruitmentDetailAddListVO();
		rlvo.setRecrNo(rvo.getRecrNo());
		rlvo.setComId(rvo.getComId());	
		rlvo.setCountry(rvo.getCountry());
		rlvo.setRegion(rvo.getRegion());
		rlvo.setPosition(rvo.getPosition());
		rlvo.setMoney(rvo.getMoney());
		rlvo.setSkill(rvo.getSkill());
		rlvo.setContent(rvo.getContent());
		List<Long> otherRecruimentList = reRepo.findNecrNoByCompany_ComId(rvo.getComId());
		otherRecruimentList.remove(recrNo);
		rlvo.setRecrList(otherRecruimentList);
		log.info(rlvo.toString());
	}
	
	@Test
	@DisplayName("사용자 채용공고 지원")
	void memberRecruit() {
		long recrNo = 5;
		String memberId = "test01";
		if(hisRepo.findHisNoByRecrNoAndMemberId(recrNo, memberId) != null) {
			log.info("이미 지원한 공고입니다");
		}
		History his = new History();
		Recruitment rec = new Recruitment();
		Member mem = new Member();
		rec.setRecrNo(recrNo);
		mem.setMemberId(memberId);
		his.setRecruitment(rec);
		his.setMember(mem);
		hisRepo.save(his);
		log.info("성공적으로 지원되었습니다");
	}

}
