package com.banditdb.banditdb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountData, Integer> {
    List<AccountData> findByusername (String username);
}
