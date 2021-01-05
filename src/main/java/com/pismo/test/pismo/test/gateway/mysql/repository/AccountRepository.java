package com.pismo.test.pismo.test.gateway.mysql.repository;

import com.pismo.test.pismo.test.gateway.mysql.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
}
