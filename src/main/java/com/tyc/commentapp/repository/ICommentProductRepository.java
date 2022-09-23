package com.tyc.commentapp.repository;

import com.tyc.commentapp.repository.entity.CommentProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICommentProductRepository extends JpaRepository<CommentProduct, Long> {
    Optional<List<CommentProduct>> findAllOptionalByProductId(Long productId);
    Optional<List<CommentProduct>> findAllOptionalByProductIdAndCommentDateBetween(Long productId,LocalDate startDate, LocalDate finishDate);
    Optional<List<CommentProduct>> findAllOptionalByUserId(Long userId);
    Optional<List<CommentProduct>> findAllOptionalByUserIdAndCommentDateBetween(Long userId, LocalDate startDate, LocalDate finishDate);
    Optional<List<CommentProduct>> findAllOptionalByCommentContaining(String value);
    @Query("select cp from CommentProduct cp where length(cp.comment) > ?1")
    Optional<List<CommentProduct>> findByCommentLength(int value);
}
