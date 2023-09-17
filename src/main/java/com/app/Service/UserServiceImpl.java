package com.app.Service;

import com.app.Repository.UserRepo;

import com.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public User savePost(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getall() {
        List<User> user=userRepo.findAll();
        return user;
    }

    @Override
    public User findbyId(Long id) {
        Optional<User>user1=userRepo.findById(id);
        return user1.get();
    }

    @Override
    public User updateuser(User user ,Long id) {
        User user2 = userRepo.findById(id).orElseThrow(() -> new RuntimeException("user"));

        user2.setUsername(user2.getUsername());
        User save = userRepo.save(user2);
        return save;
    }
}






