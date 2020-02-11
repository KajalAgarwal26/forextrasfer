package com.hcl.ing.forextransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ing.forextransfer.entity.Accounts;

public interface AccountRepository extends JpaRepository<Accounts,Long>{
	
	public Accounts findByUserId(Long userId);

}
