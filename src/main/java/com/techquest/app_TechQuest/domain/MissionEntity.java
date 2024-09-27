package com.techquest.app_TechQuest.domain;

import com.techquest.app_TechQuest.utils.MissionDifficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "missions")
public class MissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;

    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MissionDifficulty difficulty;
}
