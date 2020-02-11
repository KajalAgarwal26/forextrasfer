package com.hcl.ing.forextransfer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.forextransfer.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{
	
	public Optional<Users> findByMobNumAndPassword(String mobNum,String password);
	
}
