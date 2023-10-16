package com.wanted.pre.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wanted.pre.entity.Company;
import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.repository.CompanyRepository;
import com.wanted.pre.repository.RecruitmentRepository;

@SpringBootTest
class RecruitTest {
	@Autowired
	RecruitmentRepository reRepo;
	@Autowired
	CompanyRepository comRepo;
	
	@Test
	@DisplayName("채용공고 등록 테스트")
	void insertRecruit() {
		Recruitment recr = new Recruitment();
		
		//recr.setCompany(comRepo.findById((long)1).orElseThrow());
		//recr.setCompany(new Company().setComId("구글"));
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

}
