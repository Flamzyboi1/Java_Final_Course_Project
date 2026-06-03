package lv.venta.CvBuilder.Controller;

import jakarta.validation.Valid;
import lv.venta.CvBuilder.Model.CVProfile;
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

    
    
    //localhost:8080/cv/showAll
    @GetMapping("/showAll")
    public String getAllCVs(Model model) {
        model.addAttribute("cvList", cvService.selectAllCVProfiles());
        return "show-all-cv-page";
    }

    // CREATE 
    //localhost:8080/cv/insert
    @GetMapping("/insert")
    public String getInsertCVForm(Model model) {
        model.addAttribute("cvProfile", new CVProfile());
        return "insert-cv-page";
    }

    @PostMapping("/insert")
    public String postInsertCV(@Valid @ModelAttribute("cvProfile") CVProfile cvProfile, BindingResult result) {
        if (result.hasErrors()) {
            return "insert-cv-page";
        }
        cvService.insertCVProfile(cvProfile);
        return "redirect:/cv/showAll";
    }

    // UPDATE
    //localhost:8080/cv/update/{id} (e.g., http://localhost:8080/cv/update/1)
    @GetMapping("/update/{id}")
    public String getUpdateCVForm(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("cvProfile", cvService.selectCVProfileById(id));
            return "update-cv-page";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }
    @PostMapping("/update/{id}")
    public String postUpdateCV(@PathVariable("id") int id, @Valid @ModelAttribute("cvProfile") CVProfile cvProfile, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-cv-page";
        }
        try {
            cvService.updateCVProfileById(id, cvProfile);
            return "redirect:/cv/showAll";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "error-page";
        }
    }

    // DELETE 
    //localhost:8080/cv/delete/{id} (e.g., http://localhost:8080/cv/delete/1)
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
}