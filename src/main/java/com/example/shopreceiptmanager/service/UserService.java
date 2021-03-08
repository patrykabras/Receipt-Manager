package com.example.shopreceiptmanager.service;

import com.example.shopreceiptmanager.exception.UserNotFoundException;
import com.example.shopreceiptmanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.shopreceiptmanager.repo.IUserRepo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final IUserRepo userRepo;

    @Autowired
    public UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public User findUserById(Long id){
        return userRepo.findUserById(id).orElseThrow(() ->
                new UserNotFoundException( "User by id " + id + " was not found"));
    }

    @Transactional
    public void deleteUser(Long id){
        userRepo.deleteUserById(id);
    }
}
