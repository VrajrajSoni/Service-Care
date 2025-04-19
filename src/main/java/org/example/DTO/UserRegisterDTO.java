package org.example.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserRegisterDTO {

    private String username;
    private String email;
    private Integer userType;
    private String phone;
    private String password;
}
