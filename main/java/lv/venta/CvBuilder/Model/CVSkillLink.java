package lv.venta.CvBuilder.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CV_SKILL_LINK_TABLE")
public class CVSkillLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Idsl")
    private int idsl;

    @NotNull
    @Size(min = 2, max = 20, message = "Level must be specified (e.g., Beginner, Expert)")
    @Column(name = "Proficiency_Level")
    private String proficiencyLevel;

    @ManyToOne
    @JoinColumn(name = "Idcp")
    private CVProfile cvProfile;

    @ManyToOne
    @JoinColumn(name = "Idsk")
    private Skill skill;

    public CVSkillLink() {}

    public CVSkillLink(String proficiencyLevel, CVProfile cvProfile, Skill skill) {
        this.proficiencyLevel = proficiencyLevel;
        this.cvProfile = cvProfile;
        this.skill = skill;
    }

    public int getIdsl() { return idsl; }
    public String getProficiencyLevel() { return proficiencyLevel; }
    public void setProficiencyLevel(String proficiencyLevel) { this.proficiencyLevel = proficiencyLevel; }
    public CVProfile getCvProfile() { return cvProfile; }
    public void setCvProfile(CVProfile cvProfile) { this.cvProfile = cvProfile; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }

    @Override
    public String toString() {
        return idsl + " " + proficiencyLevel;
    }
}