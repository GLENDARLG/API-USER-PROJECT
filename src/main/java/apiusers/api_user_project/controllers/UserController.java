package apiusers.api_user_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

import apiusers.api_user_project.models.User;
import apiusers.api_user_project.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public User handleGoogleLogin(OAuth2AuthenticationToken authentication) {
       String email = authentication.getPrincipal().getAttributes().get("email").toString();
       String name = authentication.getPrincipal().getAttributes().get("name").toString();
       String googleId = authentication.getPrincipal().getAttributes().get("sub").toString();
              
        return userService.getOrCreateUser(email, name, googleId);
    }
    
}
