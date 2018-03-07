package fr.laerce.gestionstages.web;

import fr.laerce.gestionstages.dao.IndividuRepository;
import fr.laerce.gestionstages.domain.Individu;
import fr.laerce.gestionstages.service.DroitsIndividu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

// cette classe contient des mapping vers des pages webs, et on le spécifit avec
// l'annotation @Controller
@Controller
public class IndividuController {

    // on demande à Spring Boot de créer IndividuRepository dans la classe IndividuController
    // et cet objet IndividuRepository contiendra toutes les méthodes pour interroger la
    // table "individu". Cet objet IndividuRepository sera injecté dans notre application
    @Autowired
    private IndividuRepository repoIndividu;

    // on instancie pas directement l'objet DroitsIndividu nous-même, on laisse Spring l'auto-pluger lui-même
    // avec un @Autowired, ce qui nous permettra ensuite, dans les méthodes de DroitsIndividu, de pouvoir interroger
    // la table Individu avec le Repository d'Individu pour récupérer ce dont on aura besoin (un Individu ou une liste
    // d'Individu) pour générer un login et un mot de passe
    @Autowired
    private DroitsIndividu droits_individu;

    // l'objet Model correspond aux données qu'on va envoyer aux templates
    @GetMapping("/individu/liste")
    public String listeIndividu(Model model) {
        model.addAttribute("individus", repoIndividu.findAll());
        return "listeIndividu";
    }

    @GetMapping("/individu/ajout")
    public String ajoutIndividuGet(Model model) {
        model.addAttribute("individu", new Individu());
        return "formulaireIndividu";
    }

    @PostMapping("/individu/ajout")
    public String ajoutIndividuPost(@ModelAttribute Individu individu) {
        repoIndividu.save(individu);
        return "redirect:/individu/liste";
    }

    @GetMapping("/individu/modif/{id}")
    public String modifIndividu(@PathVariable("id") Long id, Model model) {
        //
        Optional<Individu> individu = repoIndividu.findById(id);
        model.addAttribute("individu", individu);
        return "formulaireIndividu";
    }

    @GetMapping("/individu/suppr/{id}")
    public String supprIndividu(@PathVariable("id") Long id) {
        repoIndividu.deleteById(id);
        return "redirect:/individu/liste";
    }

    @GetMapping("/individu/droitUtilisateur/{id}")
    public String ajoutDroitUtilisateur(@PathVariable("id") Long id) {
        Optional<Individu> individu = repoIndividu.findById(id);
        droits_individu.ajoutDroitsIndividu(individu.get());
        repoIndividu.save(individu.get());
        return "redirect:/individu/liste";
    }

    @GetMapping("/individu/afficherDroitsIndividu/{id}")
    public String afficherDroitsUtilisateur(@PathVariable("id") Long id, Model model) {
        Optional<Individu> individu = repoIndividu.findById(id);
        model.addAttribute("individu", individu.get());
        return "listeDroitsIndividu";
    }
}
