package com.wanted.pre.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class RecruitmentDetailAddListVO {
//		"채용공고_id": 채용공고_id,
//	  "회사명":"원티드랩",
//	  "국가":"한국",
//	  "지역":"서울",
//	  "채용포지션":"백엔드 주니어 개발자",
//	  "채용보상금":1500000,
//	  "사용기술":"Python",
//		"채용내용": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
//		"회사가올린다른채용공고":[채용공고_id, 채용공고_id, ..] # id List (선택사항 및 가산점요소).
	private Long recrNo;
	private String comId;	
	private String country;
	private String region;
	private String position;
	private long money;
	private String skill;
	private String content;
	private List<Long> recrList;

}
