package com.wanted.pre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanted.pre.entity.History;
import com.wanted.pre.entity.Member;
import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.repository.CompanyRepository;
import com.wanted.pre.repository.HistoryRepository;
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
	@Autowired
	HistoryRepository hisRepo;
	//공고등록
	@Override
	public void insertRecruit(Recruitment recruitment) {
		recrRepo.save(recruitment);
	}
	
	//공고업데이트
	@Override
	public void updateRecruit(Recruitment recruitment,Long recrNo) {
		recruitment.setRecrNo(recrNo);
		recrRepo.save(recruitment);
	}
	
	//공고제거
	@Override
	public void deleteRecruit(Long recrNo) {
		recrRepo.deleteById(recrNo);
	}
	
	//공고리스트
	@Override
	public List<RecruitmentsVO> findRecruitmentsInfomation() {
		return recrRepo.findRecruitmentsInfomation();
	}
	
	//공고검색
	@Override
	public List<RecruitmentsVO> searchRecruitments(String search) {
		return recrRepo.searchRecruitments(search);
	}
	
	//공고상세 및 회사의 다른채용목록
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
	
	//채용공고에 지원
	@Override
	public String memberRecruit(long recrNo, String memberId) {
		try {
			if(hisRepo.findHisNoByRecrNoAndMemberId(recrNo, memberId) != null)return "이미 지원한 공고입니다";
			History his = new History();
			Recruitment rec = new Recruitment();
			Member mem = new Member();
			rec.setRecrNo(recrNo);
			mem.setMemberId(memberId);
			his.setRecruitment(rec);
			his.setMember(mem);
			hisRepo.save(his);
			
			return "성공적으로 지원되었습니다";
		} catch (Exception e) {
			return "공고번호와 아이디를 다시 확인해주세요";
		}

		
	}

}
