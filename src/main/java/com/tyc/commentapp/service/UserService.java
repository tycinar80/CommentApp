package com.tyc.commentapp.service;

import com.tyc.commentapp.repository.IUserRepository;
import com.tyc.commentapp.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public User save(User user) {
       return userRepository.save(user);
    }

//    public User update(User user) {
//       return userRepository.save(user);
//    }
//
//    public void delete(User user) {
//        userRepository.delete(user);
//    }
//
    public List<User> findAll() {
        return userRepository.findAll();
    }
//
//    public Optional<User> findById(Long id) {
//        return userRepository.findById(id);
//    }
}
