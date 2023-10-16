package com.wanted.pre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.repository.CompanyRepository;
import com.wanted.pre.repository.RecruitmentRepository;
import com.wanted.pre.vo.RecruitmentsVO;

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
	
	@Override
	public List<RecruitmentsVO> findRecruitmentsInfomation() {
		return recrRepo.findRecruitmentsInfomation();
	}
	
	@Override
	public List<RecruitmentsVO> searchRecruitments(String search) {
		return recrRepo.searchRecruitments(search);
	}
}
