package com.wanted.pre.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Company {
//	회사에 들어가는것	-	회사고유ID	comId;
//	회사명		company;
//	국가		country;
//	지역		region;
//	공고리스트	recList;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comId;
	
	//회사이름 중복 허용하려고 고유ID따로넣고 회사명 따로넣었지만 여기에선 로그인을 안쓰므로 일단 unique로 넣고사용
	@Column(name="company_name",unique=true)
	private String companyName;
	
	private String country;
	private String region;
	
	@OneToMany(mappedBy = "company" , cascade = CascadeType.ALL , orphanRemoval = true , fetch = FetchType.LAZY)
	private List<Recruitment> recrList = new ArrayList<>();
	

}
