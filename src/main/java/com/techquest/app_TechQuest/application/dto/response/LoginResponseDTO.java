package com.techquest.app_TechQuest.application.dto.response;

import com.techquest.app_TechQuest.utils.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDTO {


    private Long id ;

    private Role role;

    private String token;
}
