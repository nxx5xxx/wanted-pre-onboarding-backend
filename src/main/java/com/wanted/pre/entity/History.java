package com.wanted.pre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class History {
/*지원내역 -			지원내역고유번호	hisNo;
				채용공고ID		recrNo;
				사용자ID		userId;*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hisNo;
	
	@OneToOne
	@JoinColumn(name="recr_no",nullable = false)
	private Recruitment recruitment;
	
	@OneToOne
	@JoinColumn(name="member_id",nullable = false)
	private Member member;
	
	
		
}
