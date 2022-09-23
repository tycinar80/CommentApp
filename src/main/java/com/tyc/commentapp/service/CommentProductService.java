package com.tyc.commentapp.service;

import com.tyc.commentapp.repository.ICommentProductRepository;
import com.tyc.commentapp.repository.entity.CommentProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentProductService {
    private final ICommentProductRepository commentProductRepository;

    public CommentProduct save(CommentProduct commentProduct) {
        return commentProductRepository.save(commentProduct);
    }

    public List<CommentProduct> findAll() {
        return commentProductRepository.findAll();
    }

    public Optional<List<CommentProduct>> findAllOptionalByProductId(Long productId) {
        return commentProductRepository.findAllOptionalByProductId(productId);
    }

    public Optional<List<CommentProduct>> findAllOptionalByProductIdAndCommentDateBetween(Long productId,String startDate, String  finishDate) {
        return commentProductRepository.findAllOptionalByProductIdAndCommentDateBetween(productId,LocalDate.parse(startDate), LocalDate.parse(finishDate));
    }

    public Optional<List<CommentProduct>> findAllOptionalByUserId(Long userId) {
        return commentProductRepository.findAllOptionalByUserId(userId);
    }

    public Optional<List<CommentProduct>> findAllOptionalByUserIdAndCommentDateBetween(Long userId, LocalDate startDate, LocalDate finishDate) {
        return commentProductRepository.findAllOptionalByUserIdAndCommentDateBetween(userId, startDate, finishDate);
    }

    public Optional<List<CommentProduct>> findAllOptionalByCommentContaining(String value) {
        return commentProductRepository.findAllOptionalByCommentContaining(value);
    }

    public Optional<List<CommentProduct>> findByCommentLength(int value) {
        return commentProductRepository.findByCommentLength(value);
    }
}
