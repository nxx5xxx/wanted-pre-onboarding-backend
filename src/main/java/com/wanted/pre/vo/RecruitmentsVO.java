package com.wanted.pre.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class RecruitmentsVO {
//	"채용공고_id": 채용공고_id,
//	  "회사명":"원티드랩",
//	  "국가":"한국",
//	  "지역":"서울",
//	  "채용포지션":"백엔드 주니어 개발자",
//	  "채용보상금":1500000,
//	  "사용기술":"Python"
	private Long recrNo;
	private String comId;	
	private String country;
	private String region;
	private String position;
	private long money;
//	private String content;
	private String skill;
	public RecruitmentsVO(Long recrNo, String comId, String country, String region, String position, long money,
			String skill) {
		this.recrNo = recrNo;
		this.comId = comId;
		this.country = country;
		this.region = region;
		this.position = position;
		this.money = money;
		this.skill = skill;
	}
	
	
	
}
