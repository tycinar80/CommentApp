package com.tyc.commentapp.controller;

import com.tyc.commentapp.repository.entity.User;
import com.tyc.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @GetMapping("/save")
    public ResponseEntity<User> save(String name, String surname,
                 String email, String telephone, String password) {
        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .telephone(telephone)
                .password(password)
                .build();
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

//    public ResponseEntity<Void> update(Long id, String ad, String soyad, String email, String telefon, String sifre) {
//        User user = User.builder()
//                .id(id)
//                .ad(ad)
//                .soyad(soyad)
//                .email(email)
//                .telefon(telefon)
//                .sifre(sifre)
//                .build();
//        return ResponseEntity.ok().build();
//    }
//
//    public ResponseEntity<User> delete(Long id) {
//        User user = userService.findById(id).get();
//
//        return ResponseEntity.ok(userService.delete(user));
//    }

}
