package com.wanted.pre.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class TestEntity {
	@Id
	private Long no;
	private String id;
	private int pw;
}
