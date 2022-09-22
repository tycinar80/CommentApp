package com.tyc.commentapp.controller;

import com.tyc.commentapp.repository.entity.CommentProduct;
import com.tyc.commentapp.repository.entity.Product;
import com.tyc.commentapp.repository.entity.User;
import com.tyc.commentapp.service.CommentProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/commentproduct")
@RequiredArgsConstructor
public class CommentProductController {
    private CommentProductService commentProductService;

    public ResponseEntity<CommentProduct> save(String comment, LocalDate commentDate, Long  productId, Long userId) {
        CommentProduct commentProduct = CommentProduct.builder()
                .comment(comment)
                .commentDate(commentDate)
                .productId(productId)
                .userId(userId)
                .build();
        return ResponseEntity.ok(commentProduct);
    }

    public ResponseEntity<List<CommentProduct>> findAll() {
        return ResponseEntity.ok(commentProductService.findAll());
    }
}
