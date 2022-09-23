package com.tyc.commentapp.controller;

import com.tyc.commentapp.repository.entity.CommentProduct;
import com.tyc.commentapp.service.CommentProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commentproduct")
@RequiredArgsConstructor
public class CommentProductController {
    private final CommentProductService commentProductService;

    @GetMapping("/save")
    public ResponseEntity<CommentProduct> save(String comment, String  commentDate, Long  productId, Long userId) {
        CommentProduct commentProduct = CommentProduct.builder()
                .comment(comment)
                .commentDate(LocalDate.parse(commentDate))
                .productId(productId)
                .userId(userId)
                .build();
        return ResponseEntity.ok(commentProductService.save(commentProduct));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<CommentProduct>> findAll() {
        return ResponseEntity.ok(commentProductService.findAll());
    }
    @GetMapping("/findallbyproductid")
    public ResponseEntity<List<CommentProduct>> findAllOptionalByProductId(Long productId) {
        return ResponseEntity.ok(commentProductService.findAllOptionalByProductId(productId).get());
    }
    @GetMapping("/findallbyproductidandcommentdatebetween")
    public ResponseEntity<List<CommentProduct>> findAllOptionalByProductIdAndCommentDateBetween(Long productId,String startDate, String  finishDate) {
        return ResponseEntity.ok(commentProductService.findAllOptionalByProductIdAndCommentDateBetween(productId,startDate, finishDate).get());
    }
    @GetMapping("/findallbyuserid")
    public ResponseEntity<List<CommentProduct>> findAllOptionalByUserId(Long userId) {
        return ResponseEntity.ok(commentProductService.findAllOptionalByUserId(userId).get());
    }
    @GetMapping("/findallbyuseridandcommentdatebetween")
    public ResponseEntity<List<CommentProduct>> findAllOptionalByUserIdAndCommentDateBetween(Long userId, LocalDate startDate, LocalDate finishDate) {
        return ResponseEntity.ok(commentProductService.findAllOptionalByUserIdAndCommentDateBetween(userId, startDate, finishDate).get());
    }
    @GetMapping("/findallbycommentcontaining")
    public ResponseEntity<List<CommentProduct>> findAllOptionalByCommentContaining(String value) {
        return ResponseEntity.ok(commentProductService.findAllOptionalByCommentContaining(value).get());
    }
    @GetMapping("/findbycommentlength")
    public ResponseEntity<List<CommentProduct>> findByCommentLength(int value) {
        return ResponseEntity.ok(commentProductService.findByCommentLength(value).get());
    }
    @GetMapping("/findallbycontainingiterable")
    public List<CommentProduct> findAllByContainingIterable(String value) {
        String[] searchingValue = value.split("-");
        List<CommentProduct> commentList = new ArrayList<>();
        for (int i = 0; i < searchingValue.length; i++) {
            List<CommentProduct> tempCommentList = commentProductService.findAllOptionalByCommentContaining(searchingValue[i]).get();
            if(!tempCommentList.isEmpty()) commentList.addAll(tempCommentList);
        }
        return commentList;
    }
}
