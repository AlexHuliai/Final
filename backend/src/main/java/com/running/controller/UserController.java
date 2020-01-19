package com.running.controller;

import com.running.entity.User;
import com.running.repository.UserRepository;
import com.running.service.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/submitUserDetails", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void submitUserDetails(@RequestBody User user) {

        this.userRepository.save(user);
        sendMail.sendEmail(user.getEmail(),"Thank You!", "Thanks a lot for signing in on my application.Happy exercisizing!");






    }


    @Autowired
    private SendMail sendMail;
    @RequestMapping(value="/findUserByEmail",produces=MediaType.APPLICATION_JSON_VALUE,method= RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Optional<User>> findUserByEmail( String email){
        Optional<User> user = this.userRepository.findById(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @RequestMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
    private ResponseEntity<Optional<User>> login(@RequestBody User user) {

        Optional<User> user1 = userRepository.findById(user.getEmail());
        if(user1.isPresent()) {
            if(user1.get().getPassword().equals(user.getPassword())) {
                return new ResponseEntity<>(user1, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }
        else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }
    @RequestMapping(value="/printAll", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity< List<User>> printAll(){

        List<User> users = this.userRepository.findAll();
        return new ResponseEntity<List<User>> (users,HttpStatus.OK);
    }




}
