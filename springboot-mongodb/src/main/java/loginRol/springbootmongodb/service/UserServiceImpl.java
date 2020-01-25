package loginRol.springbootmongodb.service;

import loginRol.springbootmongodb.entity.User;
import loginRol.springbootmongodb.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public String createUser(User user) {
        if (!findByEmail(user.getEmail()).isPresent()) {
            return "ok";
        }else {
            return "existe usuario";
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }



    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
