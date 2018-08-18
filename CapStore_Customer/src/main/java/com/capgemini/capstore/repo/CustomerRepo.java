package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Authentication;


@Repository
public interface CustomerRepo extends JpaRepository<Authentication, Integer> {
	@Query("select e from Authentication e where e.mobileNo =?1")
	public Authentication findByMobileNo(String mobileNo);

}
