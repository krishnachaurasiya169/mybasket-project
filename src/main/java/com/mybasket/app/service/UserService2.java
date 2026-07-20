package com.mybasket.app.service;

import com.mybasket.app.dto.UserDto;

public interface UserService2 {



//List<UserDto> getAllUsers();

// UserDto getUser(Integer userId);

//    UserDto createUser(UserDto userDto);

    public UserDto updateUser( Integer userId, UserDto userDto);

    public void deleteUser(Integer userId);

}
