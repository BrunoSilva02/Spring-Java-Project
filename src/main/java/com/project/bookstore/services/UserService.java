package com.project.bookstore.services;

import com.project.bookstore.models.User;
import com.project.bookstore.repositories.UserRepository;
import com.project.bookstore.services.response.ResponseMessage;
import com.project.bookstore.services.response.ResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ResponseService responseService;

    public UserService(UserRepository userRepository, ResponseService responseService){
        this.userRepository = userRepository;
        this.responseService = responseService;
    }

    public ResponseEntity<Object> getUsers(){
        List<User> users = (List<User>) userRepository.findAll();

        if(users.isEmpty()){
            return responseService.localizedResponse(ResponseMessage.DEFAULT, null, HttpStatus.NOT_FOUND);
        }

        return responseService.localizedResponse(ResponseMessage.DEFAULT, users, HttpStatus.OK);
    }

    public ResponseEntity<Object> addUser(User user){
            return null;
    }

    public void test(){
        userRepository.save(new User(UUID.randomUUID(),"test-name","email@example.com","password"));
    }
}
