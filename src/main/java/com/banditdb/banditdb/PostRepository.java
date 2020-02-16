package com.banditdb.banditdb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostData, Integer> {
}
