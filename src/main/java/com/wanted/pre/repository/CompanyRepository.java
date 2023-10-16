package com.wanted.pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wanted.pre.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, String>{

}
