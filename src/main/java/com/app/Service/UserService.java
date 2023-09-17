package com.app.Service;


import com.app.entity.User;

import java.util.List;

public interface UserService {
    User savePost(User user);
    List<User> getall();
    User findbyId(Long id);
    User updateuser(User user ,Long id);


}


