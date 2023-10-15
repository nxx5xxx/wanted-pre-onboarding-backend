package com.wanted.pre;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wanted.pre.entity.TestEntity;
import com.wanted.pre.test.TestRepo;

@SpringBootTest
public class DBTest {
	@Autowired
	TestRepo testRepo;
	
	@Test
	@DisplayName("DB조회테스트")
	public void test() {
		List<TestEntity> te = testRepo.findAll();
		for(TestEntity data : te) {
			System.out.println(data);
		}
		
	}

}