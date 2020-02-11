package com.hcl.ing.forextransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ing.forextransfer.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long>{


}
