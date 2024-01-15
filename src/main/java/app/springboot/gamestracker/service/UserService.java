package app.springboot.gamestracker.service;

import app.springboot.gamestracker.dto.UserDto;
import app.springboot.gamestracker.entity.User;

import java.util.List;


public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}