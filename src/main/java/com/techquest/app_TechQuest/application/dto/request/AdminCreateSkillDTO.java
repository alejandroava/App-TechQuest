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
public class AdminCreateSkillDTO {
    @NotBlank(message = "required title")
    private String title;
    @NotBlank(message = "required description")
    private String description;
}
