package com.wanted.pre.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class RecruitmentDetailVO {
//		"채용공고_id": 채용공고_id,
//	  "회사명":"원티드랩",
//	  "국가":"한국",
//	  "지역":"서울",
//	  "채용포지션":"백엔드 주니어 개발자",
//	  "채용보상금":1500000,
//	  "사용기술":"Python",
//		"채용내용": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
	private Long recrNo;
	private String comId;	
	private String country;
	private String region;
	private String position;
	private long money;
	private String skill;
	private String content;

}
