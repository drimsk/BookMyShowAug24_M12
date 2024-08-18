package com.scalar.vivek.bookmyshowaug24_m12.services;

import com.scalar.vivek.bookmyshowaug24_m12.models.User;
import com.scalar.vivek.bookmyshowaug24_m12.repositories.UserRepository;

import java.util.Optional;

public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void SingIn(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()){
            //Redirect to SignUp.

        }
        User user = optionalUser.get();

    }
}
