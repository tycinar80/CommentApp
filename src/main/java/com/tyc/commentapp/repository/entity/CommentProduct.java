package com.tyc.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "tblcommentproduct")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String comment;
    private LocalDate commentDate;
    private Long productId;
    private Long userId;
}
