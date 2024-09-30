package com.techquest.app_TechQuest.domain.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class MissionSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_mission")
    private MissionEntity mission;

    @ManyToOne
    @JoinColumn(name = "id_skill")
    private SkillEntity skill;

}
