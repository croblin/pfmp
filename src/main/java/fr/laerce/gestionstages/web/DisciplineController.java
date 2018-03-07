package fr.laerce.gestionstages.web;

import fr.laerce.gestionstages.dao.DisciplineRepository;
import fr.laerce.gestionstages.domain.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class DisciplineController {

    @Autowired
    private DisciplineRepository repoDiscipline;

    @GetMapping("/discipline/liste")
    public String listeDiscipline(Model model) {
        model.addAttribute("disciplines", repoDiscipline.findAll());
        return "listeDiscipline";
    }

    @GetMapping("/discipline/ajout")
    public String ajoutDisciplineGet(Model model) {
        model.addAttribute("discipline", new Discipline());
        return "formulaireDiscipline";
    }

    @PostMapping("/discipline/ajout")
    public String ajoutDisciplinePost(@ModelAttribute Discipline discipline) {
        repoDiscipline.save(discipline);
        return "redirect:/discipline/liste";
    }

    @GetMapping("/discipline/modif/{id}")
    public String modifDiscipline(@PathVariable("id") Long id, Model model) {
        Optional<Discipline> discipline = repoDiscipline.findById(id);
        model.addAttribute("discipline", discipline);
        return "formulaireDiscipline";
    }

    @GetMapping("/discipline/suppr/{id}")
    public String supprDiscipline(@PathVariable("id") Long id) {
        repoDiscipline.deleteById(id);
        return "redirect:/discipline/liste";
    }
}
