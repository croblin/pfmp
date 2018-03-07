package fr.laerce.gestionstages.web;

import fr.laerce.gestionstages.dao.NiveauRepository;
import fr.laerce.gestionstages.domain.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class NiveauController {

    @Autowired
    private NiveauRepository repoNiveau;

    @GetMapping("/niveau/liste")
    public String listeNiveau(Model model) {
        model.addAttribute("niveaux", repoNiveau.findAll());
        return "listeNiveau";
    }

    @GetMapping("/niveau/ajout")
    public String ajoutNiveauGet(Model model) {
        model.addAttribute("niveau", new Niveau());
        return "formulaireNiveau";
    }

    @PostMapping("/niveau/ajout")
    public String ajoutNiveauPost(@ModelAttribute Niveau niveau) {
        repoNiveau.save(niveau);
        return "redirect:/niveau/liste";
    }

    @GetMapping("/niveau/modif/{id}")
    public String modifNiveau(@PathVariable("id") Long id, Model model) {
        //
        Optional<Niveau> niveau = repoNiveau.findById(id);
        model.addAttribute("niveau", niveau);
        return "formulaireNiveau";
    }

    @GetMapping("/niveau/suppr/{id}")
    public String supprNiveau(@PathVariable("id") Long id) {
        repoNiveau.deleteById(id);
        return "redirect:/niveau/liste";
    }
}
