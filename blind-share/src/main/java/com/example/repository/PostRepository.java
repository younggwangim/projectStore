package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Post;

/**
 * @author Hansong Y
 *
 * Dao (DB 연결, 트랜잭션등의 관리, SQL 실행결과를  자바객체로 변환 ResultSet과 동일)
 */
@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT x FROM Post x ORDER BY x.id")
    List<Post> findAllOrderByName();

    @Query("SELECT x FROM Post x ORDER BY x.id")
    Page<Post> findAllOrderByName(Pageable pageable);
}

