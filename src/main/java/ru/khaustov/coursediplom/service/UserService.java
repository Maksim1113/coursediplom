package ru.khaustov.coursediplom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.khaustov.coursediplom.entity.User;
import ru.khaustov.coursediplom.entity.Role;
import ru.khaustov.coursediplom.repository.UserRepository;
import ru.khaustov.coursediplom.repository.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
}
