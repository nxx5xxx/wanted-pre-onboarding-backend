package com.wanted.pre.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter @ToString
public class Member {
//	사용자ID 		memberId;
//	지원공고리스트 	recrList - 사용할일이 없기에 주석처리;
	@Id
	private String memberId;
	
//	@OneToMany(mappedBy = "member" , cascade = CascadeType.ALL , orphanRemoval = true , fetch = FetchType.LAZY)
//	private List<Recruitment> recrList = new ArrayList<>();
}
