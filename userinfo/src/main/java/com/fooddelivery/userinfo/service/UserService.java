package com.fooddelivery.userinfo.service;

import com.fooddelivery.userinfo.dto.UserDTO;
import com.fooddelivery.userinfo.entity.User;
import com.fooddelivery.userinfo.mapper.UserMapper;
import com.fooddelivery.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO addUser(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User savedUser = userRepository.save(UserMapper.INSTANCE.mapUserDtoToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDto(savedUser);
    }

    public ResponseEntity<UserDTO> findUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDto(user.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
