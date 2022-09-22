package com.tyc.commentapp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tblkullanici")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Kullanici {
    private Long id;
    private String ad;
    private String soyad;
    private String email;
    private String telefon;
    private String sifre;
}
