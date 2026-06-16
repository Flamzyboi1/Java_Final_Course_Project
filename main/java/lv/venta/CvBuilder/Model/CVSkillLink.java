package lv.venta.CvBuilder.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "CV_SKILL_LINK_TABLE")
public class CVSkillLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Idsl")
    private int idsl;

    @NotNull(message = "Proficiency level must be selected")
    @Enumerated(EnumType.STRING)
    @Column(name = "Proficiency_Level")
    private CEFRProficiency proficiencyLevel;

    @ManyToOne
    @JoinColumn(name = "Idcp")
    private CVProfile cvProfile;

    @ManyToOne
    @JoinColumn(name = "Idsk")
    private Skill skill;

    public CVSkillLink() {}

    public CVSkillLink(int idsl, CEFRProficiency proficiencyLevel, CVProfile cvProfile, Skill skill) {
        setIdsl(idsl);
        setProficiencyLevel(proficiencyLevel);
        setCvProfile(cvProfile);
        setSkill(skill);
    }

    public CVSkillLink(CEFRProficiency proficiencyLevel, CVProfile cvProfile, Skill skill) {
        setProficiencyLevel(proficiencyLevel);
        setCvProfile(cvProfile);
        setSkill(skill);
    }

    public int getIdsl() { 
        return idsl; 
    }

    public void setIdsl(int idsl) {
        this.idsl = idsl;
    }
    
    public CEFRProficiency getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(CEFRProficiency proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }
    
    public CVProfile getCvProfile() { 
        return cvProfile; 
    }
    
    public void setCvProfile(CVProfile cvProfile) { 
        this.cvProfile = cvProfile; 
    }
    
    public Skill getSkill() { 
        return skill; 
    }
    
    public void setSkill(Skill skill) { 
        this.skill = skill; 
    }

    public void setSkillName(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        String skillTitle = (skill != null) ? skill.getTitle() : "No Skill Assigned";
        return idsl + " - " + skillTitle + " (" + proficiencyLevel + ")";
    }
}