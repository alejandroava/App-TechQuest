package com.techquest.app_TechQuest.application.dto.request;

import com.techquest.app_TechQuest.utils.MissionDifficulty;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMissionDTO {

    @NotBlank(message = "required title")
    private String title;
    @NotBlank(message = "required description")
    private String description;
    @NotBlank(message = "required difficulty")
    private String difficulty;
}
