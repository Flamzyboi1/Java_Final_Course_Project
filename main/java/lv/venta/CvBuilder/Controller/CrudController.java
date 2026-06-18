package lv.venta.CvBuilder.Controller;

import jakarta.validation.Valid;
import lv.venta.CvBuilder.Model.*;
import lv.venta.CvBuilder.Service.ICRUDCVBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cv")
public class CrudController {

    @Autowired
    private ICRUDCVBuilderService cvService;

    @GetMapping("/showAll")
    public String getAllCVs(Model model) {
        try {
            model.addAttribute("cvList", cvService.selectAllCVProfiles());
            return "show-all-cv-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/insert")
    public String getInsertCVForm(Model model) {
        model.addAttribute("cvProfile", new CVProfile());
        return "insert-cv-page";
    }

    @PostMapping("/insert")
    public String postInsertCV(@Valid @ModelAttribute("cvProfile") CVProfile cvProfile, BindingResult result) {
        if (result.hasErrors()) return "insert-cv-page";
        try {
            cvService.insertCVProfile(cvProfile);
            return "redirect:/cv/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/update/{id}")
    public String getUpdateCVForm(@PathVariable("id") int id, Model model) {
        try {
            CVProfile cv = cvService.selectCVProfileById(id);
            model.addAttribute("cvProfile", cv);
            model.addAttribute("education", new Education());
            model.addAttribute("experience", new Experience());
            model.addAttribute("cvSkillLink", new CVSkillLink());
            return "update-cv-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @PostMapping("/update/{id}")
    public String postUpdateCV(@PathVariable("id") int id, @Valid @ModelAttribute("cvProfile") CVProfile cvProfile, BindingResult result, Model model) {
        if (result.hasErrors()) return "update-cv-page";
        try {
            cvService.updateCVProfileById(id, cvProfile);
            return "redirect:/cv/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCV(@PathVariable("id") int id, Model model) {
        try {
            cvService.deleteCVProfileById(id);
            return "redirect:/cv/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/experience/showAll")
    public String getAllExperiences(Model model) {
        try {
            model.addAttribute("experienceList", cvService.selectAllExperiences());
            return "show-all-experience-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/experience/insert")
    public String getInsertExperienceForm(Model model) {
        model.addAttribute("experience", new Experience());
        return "insert-experience-page";
    }

    @PostMapping("/experience/insert")
    public String postInsertExperience(@Valid @ModelAttribute("experience") Experience experience, BindingResult result) {
        if (result.hasErrors()) return "insert-experience-page";
        try {
            cvService.insertExperience(experience);
            return "redirect:/cv/experience/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/experience/update/{id}")
    public String getUpdateExperienceForm(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("experience", cvService.selectExperienceById(id));
            return "update-experience-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @PostMapping("/experience/update/{id}")
    public String postUpdateExperience(@PathVariable("id") int id, @Valid @ModelAttribute("experience") Experience experience, BindingResult result, Model model) {
        if (result.hasErrors()) return "update-experience-page";
        try {
            cvService.updateExperienceById(id, experience);
            return "redirect:/cv/experience/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/experience/delete/{id}")
    public String deleteExperience(@PathVariable("id") int id, Model model) {
        try {
            cvService.deleteExperienceById(id);
            return "redirect:/cv/experience/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/education/showAll")
    public String getAllEducations(Model model) {
        try {
            model.addAttribute("educationList", cvService.selectAllEducations());
            return "show-all-education-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/education/insert")
    public String getInsertEducationForm(Model model) {
        model.addAttribute("education", new Education());
        
        return "insert-education-page";
    }

    @PostMapping("/education/insert")
    public String postInsertEducation(@Valid @ModelAttribute("education") Education education, BindingResult result) {
        if (result.hasErrors()) return "insert-education-page";
        try {
            cvService.insertEducation(education);
            return "redirect:/cv/education/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/education/update/{id}")
    public String getUpdateEducationForm(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("education", cvService.selectEducationById(id));
            return "update-education-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @PostMapping("/education/update/{id}")
    public String postUpdateEducation(@PathVariable("id") int id, @Valid @ModelAttribute("education") Education education, BindingResult result, Model model) {
        if (result.hasErrors()) return "update-education-page";
        try {
            cvService.updateEducationById(id, education);
            return "redirect:/cv/education/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/education/delete/{id}")
    public String deleteEducation(@PathVariable("id") int id, Model model) {
        try {
            cvService.deleteEducationById(id);
            return "redirect:/cv/education/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/skill/showAll")
    public String getAllSkills(Model model) {
        try {
            model.addAttribute("skillList", cvService.selectAllSkills());
            return "show-all-skill-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/skill/insert")
    public String getInsertSkillForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "insert-skill-page";
    }

    @PostMapping("/skill/insert")
    public String postInsertSkill(@Valid @ModelAttribute("skill") Skill skill, BindingResult result) {
        if (result.hasErrors()) return "insert-skill-page";
        try {
            cvService.insertSkill(skill);
            return "redirect:/cv/skill/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/skill/update/{id}")
    public String getUpdateSkillForm(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("skill", cvService.selectSkillById(id));
            return "update-skill-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @PostMapping("/skill/update/{id}")
    public String postUpdateSkill(@PathVariable("id") int id, @Valid @ModelAttribute("skill") Skill skill, BindingResult result, Model model) {
        if (result.hasErrors()) return "update-skill-page";
        try {
            cvService.updateSkillById(id, skill);
            return "redirect:/cv/skill/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/skill/delete/{id}")
    public String deleteSkill(@PathVariable("id") int id, Model model) {
        try {
            cvService.deleteSkillById(id);
            return "redirect:/cv/skill/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/cvskill/showAll")
    public String getAllCvSkillLinks(Model model) {
        try {
            model.addAttribute("linkList", cvService.selectAllCvSkillLinks());
            return "show-all-cvskill-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/cvskill/insert")
    public String getInsertCvSkillLinkForm(Model model) {
        model.addAttribute("cvSkillLink", new CVSkillLink());
        return "insert-cvskill-page";
    }

    @PostMapping("/cvskill/insert")
    public String postInsertCvSkillLink(@Valid @ModelAttribute("cvSkillLink") CVSkillLink cvSkillLink, BindingResult result) {
        if (result.hasErrors()) return "insert-cvskill-page";
        try {
            cvService.insertCvSkillLink(cvSkillLink);
            return "redirect:/cv/cvskill/showAll";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/cvskill/update/{id}")
    public String getUpdateCvSkillLinkForm(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("cvSkillLink", cvService.selectCvSkillLinkById(id));
            return "update-cvskill-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @PostMapping("/cvskill/update/{id}")
    public String postUpdateCvSkillLink(@PathVariable("id") int id, @Valid @ModelAttribute("cvSkillLink") CVSkillLink cvSkillLink, BindingResult result, Model model) {
        if (result.hasErrors()) return "update-cvskill-page";
        try {
            cvService.updateCvSkillLinkById(id, cvSkillLink);
            return "redirect:/cv/cvskill/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/cvskill/delete/{id}")
    public String deleteCvSkillLink(@PathVariable("id") int id, Model model) {
        try {
            cvService.deleteCvSkillLinkById(id);
            return "redirect:/cv/cvskill/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }
}