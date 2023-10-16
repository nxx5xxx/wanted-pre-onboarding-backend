package com.wanted.pre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wanted.pre.entity.Recruitment;
import com.wanted.pre.service.RecruitmentService;

@RestController
@Controller
public class ApiController {
	@Autowired
	RecruitmentService recrService;
	
	//	1.공고등록
	@PostMapping("recruitment")
	void insertRecruitment(@RequestBody Recruitment recruitment) {
		recrService.insertRecruit(recruitment);
	}
	
	//	2.공고수정
	@PutMapping("recruitment/{recrNo}")
	void updateRecruitment(@RequestBody Recruitment recruitment,@PathVariable Long recrNo) {
		recrService.updateRecruit(recruitment,recrNo);
	}
	
	//	3.공고삭제
	@DeleteMapping("recruitment/{recrNo}")
	void deleteRecruitment(@PathVariable Long recrNo) {
		recrService.deleteRecruit(recrNo);
	}
}
