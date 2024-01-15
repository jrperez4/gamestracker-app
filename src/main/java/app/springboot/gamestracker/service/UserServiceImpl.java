package app.springboot.gamestracker.service;

import app.springboot.gamestracker.repository.RoleRepository;
import app.springboot.gamestracker.repository.UserRepository;
import app.springboot.gamestracker.dto.UserDto;
import app.springboot.gamestracker.entity.Role;
import app.springboot.gamestracker.entity.User;
import io.micrometer.common.util.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        //encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        user.setRoles(List.of(role));
        userRepository.save(user);
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();

        if (StringUtils.isNotBlank(user.getName())) {
            String[] name = user.getName().split(" ");
            userDto.setFirstName(name.length > 0 ? name[0] : "");
            userDto.setLastName(name.length > 1 ? name[1] : "");
        } else {
            // Handle the situation where the name is null or empty
            // You can assign default values or take some other action.
            userDto.setFirstName("");
            userDto.setLastName("");
        }

        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
