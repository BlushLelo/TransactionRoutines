package com.pismo.test.pismo.test.gateway.mysql.repository;

import com.pismo.test.pismo.test.gateway.mysql.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
}
