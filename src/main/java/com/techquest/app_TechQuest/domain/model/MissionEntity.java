package com.techquest.app_TechQuest.domain.model;

import com.techquest.app_TechQuest.utils.MissionDifficulty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "missions")
@Builder
public class MissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String title;

    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MissionDifficulty difficulty;

    @OneToMany(mappedBy = "mission")
    private List<MissionSkill> mIssionSkillList;

    @OneToMany(mappedBy = "mission")
    private List<UserMission> userMissions;


}
