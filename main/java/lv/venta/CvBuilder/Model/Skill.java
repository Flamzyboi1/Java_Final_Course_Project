package lv.venta.CvBuilder.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "SKILL_TABLE")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Idsk")
    private int idsk;

    @NotNull
    @Size(min = 1, max = 50, message = "Skill name must be between 1 and 50 characters")
    @Column(name = "Name", unique = true)
    private String name;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private Collection<CVSkillLink> cvSkillLinks;

    public Skill() {}

    public Skill(String name) {
        this.name = name;
    }

    public int getIdsk() { return idsk; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Collection<CVSkillLink> getCvSkillLinks() { return cvSkillLinks; }
    public void setCvSkillLinks(Collection<CVSkillLink> cvSkillLinks) { this.cvSkillLinks = cvSkillLinks; }

    @Override
    public String toString() {
        String result = idsk + " " + name;
        return result;
    }
}