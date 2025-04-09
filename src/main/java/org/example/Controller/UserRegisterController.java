package org.example.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.Entity.UserDetails;
import org.example.Repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@RestController
public class UserRegisterController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @GetMapping(value = "/get-user-details")
    public List<UserDetails> getAllUsers() {
        return userDetailsRepository.findAll();
    }

}
