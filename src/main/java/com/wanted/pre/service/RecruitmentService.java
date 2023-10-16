package com.wanted.pre.service;

import com.wanted.pre.entity.Recruitment;

public interface RecruitmentService {
	//채용공고 등록
	void insertRecruit(Recruitment recruitment);
	//채용공고 수정
	void updateRecruit(Recruitment recruitment,Long recrNo);
	//채용공고 삭제
	void deleteRecruit(Long recrNo);
}