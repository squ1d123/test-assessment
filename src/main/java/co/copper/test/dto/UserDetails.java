package co.copper.test.dto;

import lombok.Data;

@Data
public class UserDetails {
    private String gender;
    private UserName name;
    private String email;
    private UserLogin login;
}
