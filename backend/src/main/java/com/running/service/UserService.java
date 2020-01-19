package com.running.service;

import com.running.entity.User;
import com.running.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        this.userRepository.save(user);
        sendMail.sendEmail(user.getEmail(),"Whatever", "Whatever");

    }
    @Autowired
    private SendMail sendMail;

}
