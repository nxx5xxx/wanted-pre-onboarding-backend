package com.wanted.pre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.repository.CompanyRepository;
import com.wanted.pre.repository.RecruitmentRepository;
import com.wanted.pre.vo.RecruitmentDetailAddListVO;
import com.wanted.pre.vo.RecruitmentDetailVO;
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
	
	@Override
	public RecruitmentDetailAddListVO findRecruitmentDetail(long recrNo) {
		RecruitmentDetailVO rvo = recrRepo.findRecruitmentDetail(recrNo);
		if(rvo == null)return null;
		RecruitmentDetailAddListVO rlvo = new RecruitmentDetailAddListVO();
		rlvo.setRecrNo(rvo.getRecrNo());
		rlvo.setComId(rvo.getComId());	
		rlvo.setCountry(rvo.getCountry());
		rlvo.setRegion(rvo.getRegion());
		rlvo.setPosition(rvo.getPosition());
		rlvo.setMoney(rvo.getMoney());
		rlvo.setSkill(rvo.getSkill());
		rlvo.setContent(rvo.getContent());
		List<Long> otherRecruimentList = recrRepo.findNecrNoByCompany_ComId(rvo.getComId());
		otherRecruimentList.remove(recrNo);
		rlvo.setRecrList(otherRecruimentList);
		return rlvo;

	}

}
