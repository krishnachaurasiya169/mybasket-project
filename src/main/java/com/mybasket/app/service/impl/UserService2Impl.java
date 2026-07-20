package com.mybasket.app.service.impl;

import com.mybasket.app.dto.UserDto;
import com.mybasket.app.entity.User;
import com.mybasket.app.exception.ResourceNotFoundException;
import com.mybasket.app.repository.UserRepository;
import com.mybasket.app.service.UserService2;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService2Impl implements UserService2 {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


@Override
public UserDto updateUser(Integer userId, UserDto userDto) {
    // 1. Fetch the existing user entity or throw an exception if not found
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with Id " + userId)); // Added missing ')'

    // 2. Update the entity properties with data from the DTO
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    // user.setUserImageUrl(userDto.getUserImageUrl());

    // 3. Save the updated entity back to the database
    User updatedUser = userRepository.save(user);

    // 4. Convert the updated entity back to a DTO and return it
    return modelMapper.map(updatedUser, UserDto.class);
}

    public void deleteUser(Integer userId){
    User user = userRepository.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User not found with id: " +userId ));
    userRepository.delete(user);

}



}
