package com.wanted.pre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wanted.pre.dto.HistoryDTO;
import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.service.RecruitmentService;

@RestController
@Controller
public class ApiController {
	@Autowired
	RecruitmentService recrService;
	
	//	1.공고등록
	@PostMapping("recruitment")
	String insertRecruitment(@RequestBody Recruitment recruitment) {
		try {
			recrService.insertRecruit(recruitment);
			return "공고 등록이 완료되었습니다";
		} catch (Exception e) {
			return "등록 내용을 다시 확인해주세요";
		}
	}
	
	//	2.공고수정
	@PutMapping("recruitment/{recrNo}")
	String updateRecruitment(@RequestBody Recruitment recruitment,@PathVariable Long recrNo) {
		try {
			recrService.updateRecruit(recruitment,recrNo);
			return "공고 수정이 완료되었습니다";
		} catch (Exception e) {
			return "수정 내용을 다시 확인해주세요";
		}
	}
	
	//	3.공고삭제
	@DeleteMapping("recruitment/{recrNo}")
	String deleteRecruitment(@PathVariable Long recrNo) {
		try {
			recrService.deleteRecruit(recrNo);
			return "공고가 삭제되었습니다";
		} catch (Exception e) {
			return "공고번호를 다시 확인해주세요";
		} 
	}
	
	//	4-1.공고리스트
	@GetMapping("recruitments")
	Object selectAllRecruitment() {
		return recrService.findRecruitmentsInfomation(); 
	}
	
	// 4-2.공고리스트 중 검색
	@GetMapping("recruitments/{search}")
	Object selectAllRecruitment(@PathVariable String search) {
		return recrService.searchRecruitments(search); 
	}
	
	// 5.채용공고 상세 + 회사가올린 다른 채용공고
	@GetMapping("recruitment/{recrNo}")
	Object recruitmentDetail(@PathVariable long recrNo) {
        return recrService.findRecruitmentDetail(recrNo); 
	}
	
	// 6.채용공고에 지원
	@PostMapping("member")
	String memberRecruit(@RequestBody HistoryDTO hisDTO) {
		return recrService.memberRecruit(hisDTO.getRecrNo(), hisDTO.getMemberId());
		
	}
}


