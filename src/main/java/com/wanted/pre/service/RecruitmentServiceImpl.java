package com.wanted.pre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.repository.CompanyRepository;
import com.wanted.pre.repository.RecruitmentRepository;

@Service
public class RecruitmentServiceImpl implements RecruitmentService{
	@Autowired
	RecruitmentRepository recrRepo;
	@Autowired
	CompanyRepository comRepo;
	
	@Override
	public void insertRecruit(Recruitment recruitment) {
		recrRepo.save(recruitment);
	}
	
	@Override
	public void updateRecruit(Recruitment recruitment,Long recrNo) {
		recruitment.setRecrNo(recrNo);
		recrRepo.save(recruitment);
	}
	
	@Override
	public void deleteRecruit(Long recrNo) {
		recrRepo.deleteById(recrNo);
		
	}
}
