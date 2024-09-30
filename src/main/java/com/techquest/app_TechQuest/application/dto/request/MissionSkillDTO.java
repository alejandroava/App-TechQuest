package com.techquest.app_TechQuest.application.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MissionSkillDTO {

    @NotBlank(message = "required name mission")
    private String mission;
    @NotBlank(message = "required name skill")
    private String Skill;

}
