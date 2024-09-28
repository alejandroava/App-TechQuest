package com.techquest.app_TechQuest.application.dto.request;

import com.techquest.app_TechQuest.domain.model.SkillEntity;
import com.techquest.app_TechQuest.domain.model.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssignSkillDTO {

    @NotBlank(message = "required student")
    private String emailStudent;
    @NotBlank(message = "required student")
    private String skillStudent;

}
