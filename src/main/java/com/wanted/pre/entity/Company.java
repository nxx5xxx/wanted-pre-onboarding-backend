package com.wanted.pre.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter @ToString
public class Company {
//	회사에 들어가는것	-	회사고유ID	comId;
//	국가		country;
//	지역		region;
//	공고리스트	recList;
	
	@Id
	@Column(name = "com_id",nullable = false)
	private String comId;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private String region;
	
	@OneToMany(mappedBy = "company" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Recruitment> recrList = new ArrayList<>();
	

}
