package com.wanted.pre.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {
//	사용자ID 		memberId;
//	지원공고리스트 	recList;
	@Id
	private String memberId;
	
	@OneToMany(mappedBy = "member" , cascade = CascadeType.ALL , orphanRemoval = true , fetch = FetchType.LAZY)
	private List<Recruitment> recrList = new ArrayList<>();
}
