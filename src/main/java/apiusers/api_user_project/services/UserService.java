package apiusers.api_user_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiusers.api_user_project.repositories.UserRepository;
import apiusers.api_user_project.models.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getOrCreateUser(String email, String name, String googleId) {
        return userRepository.findByEmail(email).orElseGet(() -> {
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setGoogleId(googleId);
            return userRepository.save(user);
        });
        
    }

}
