package com.tyc.commentapp.service;

import com.tyc.commentapp.repository.ICommentProductRepository;
import com.tyc.commentapp.repository.entity.CommentProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
