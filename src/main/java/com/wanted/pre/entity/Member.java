package com.wanted.pre.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter @ToString
public class Member {
//	사용자ID 		memberId;
//	지원공고리스트 	recrList;
	@Id
	private String memberId;
	
	@OneToMany(mappedBy = "member" , cascade = CascadeType.ALL , orphanRemoval = true , fetch = FetchType.LAZY)
	private List<Recruitment> recrList = new ArrayList<>();
}
