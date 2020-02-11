package com.hcl.ing.forextransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.forextransfer.entity.Transactions;
@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long>{

}
