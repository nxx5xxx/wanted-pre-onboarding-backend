package com.wanted.pre.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wanted.pre.entity.Company;
import com.wanted.pre.entity.Member;
import com.wanted.pre.repository.CompanyRepository;
import com.wanted.pre.repository.MemberRepository;

@SpringBootTest
class InsertCompanyMember {
	@Autowired
	CompanyRepository comRepo;
	@Autowired
	MemberRepository memRepo;
	
	@Test
	@DisplayName("회사등록 테스트")
	void insertCompany() {
		Company comp = new Company();
		comp.setComId("네이버");
		comp.setCountry("대한민국");
		comp.setRegion("분당");
		comRepo.save(comp);
	}
	
	@Test
	@DisplayName("회사등록 테스트")
	void insertCompany2() {
		Company comp = new Company();
		comp.setComId("원티드");
		comp.setCountry("대한민국");
		comp.setRegion("성남");
		comRepo.save(comp);
	}
	
	@Test
	@DisplayName("유저 등록 테스트")
	void insertMember() {
		Member mem = new Member();
		mem.setMemberId("test01");
		//System.out.println(mem.getMemberId());
		//mem.setRecrList(null);
		memRepo.save(mem);
	}

}
