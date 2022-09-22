package com.tyc.commentapp.repository;

import com.tyc.commentapp.repository.entity.CommentProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentProductRepository extends JpaRepository<CommentProduct, Long> {
}
