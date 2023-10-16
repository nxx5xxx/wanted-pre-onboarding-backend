package com.wanted.pre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recruitment {
//  채용공고
//	고유번호 	recrNo;
//	회사ID	comId;
//	채용포지션	position;
//	보상금		money;
//	내용		content;
//	사용기술	skill;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recrNo;
	
	@Column(name = "com_id")
	private String comId;
	
	private String position;
	private long money;
	private String content;
	private String skill;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;

}
