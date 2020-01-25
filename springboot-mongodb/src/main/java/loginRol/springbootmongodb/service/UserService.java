package loginRol.springbootmongodb.service;


import loginRol.springbootmongodb.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    String createUser(User user);
    Optional<User> findByEmail(String email);

    List<User> findAll();
}

