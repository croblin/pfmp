package fr.laerce.gestionstages.web;

import fr.laerce.gestionstages.dao.DivisionRepository;
import fr.laerce.gestionstages.domain.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class DivisionController {

    @Autowired
    private DivisionRepository repoDivision;

    @GetMapping("/division/liste")
    public String listeDivision(Model model) {
        model.addAttribute("divisions", repoDivision.findAll());
        return "listeDivision";
    }

    @GetMapping("/division/ajout")
    public String ajoutDivisionGet(Model model) {
        model.addAttribute("division", new Division());
        return "formulaireDivision";
    }

    @PostMapping("/division/ajout")
    public String ajoutDivisionPost(@ModelAttribute Division division) {
        repoDivision.save(division);
        return "redirect:/division/liste";
    }

    @GetMapping("/division/modif/{id}")
    public String modifDivision(@PathVariable("id") Long id, Model model) {
        //
        Optional<Division> division = repoDivision.findById(id);
        model.addAttribute("division", division);
        return "formulaireDivision";
    }

    @GetMapping("/division/suppr/{id}")
    public String supprDivision(@PathVariable("id") Long id) {
        repoDivision.deleteById(id);
        return "redirect:/division/liste";
    }
}
