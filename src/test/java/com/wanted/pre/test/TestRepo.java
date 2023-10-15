package com.wanted.pre.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wanted.pre.entity.TestEntity;

@Repository
public interface TestRepo extends JpaRepository<TestEntity, Long>{
	
}
