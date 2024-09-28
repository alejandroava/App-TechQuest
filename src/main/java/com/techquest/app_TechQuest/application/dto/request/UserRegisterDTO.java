package com.techquest.app_TechQuest.application.dto.request;


import com.techquest.app_TechQuest.utils.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    @NotBlank(message = "required name")
    private String name;

    @Email(message = "required email")
    private String email;

    @NotBlank(message = "required password")
    private String password;

    @NotBlank(message = "required role")
    private Role role;

}
