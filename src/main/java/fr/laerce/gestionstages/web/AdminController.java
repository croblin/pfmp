package fr.laerce.gestionstages.web;

import fr.laerce.gestionstages.dao.*;
import fr.laerce.gestionstages.service.ImportFromSTS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private ImportFromSTS importFromSTS;

    @Autowired
    private DisciplineRepository repoDiscipline;

    @Autowired
    private DivisionRepository repoDivision;

    @Autowired
    private IndividuRepository repoIndividu;

    @Autowired
    private NiveauRepository repoNiveau;

    @Value("${gestionstages.sts.file}")
    private String stsFileName;

    // on affiche le nombre de tuples dans chaque entité, sans remettre à jour la base de données
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("niveaux", repoNiveau.count());
        model.addAttribute("disciplines", repoDiscipline.count());
        model.addAttribute("divisions", repoDivision.count());
        model.addAttribute("individus", repoIndividu.count());
        return "index";
    }

    @GetMapping("/index/update")
    public String populate(Model model) {
        // on met à jour la base de données PFMP avec le fichier XML 'sts_emp_0940321S_2017.xml'
        importFromSTS.parseAndImport(stsFileName);

        model.addAttribute("niveaux", importFromSTS.getDicoNiveaux().size());
        model.addAttribute("disciplines", importFromSTS.getDicoDisciplines().size());
        model.addAttribute("divisions", importFromSTS.getDicoDivisions().size());
        model.addAttribute("individus", importFromSTS.getDicoFormateurs().size());
        return "index";
    }

    // méthode appelée pour contrôler ce qui est envoyé sur la page de login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // méthode appelée pour contrôler ce qui est envoyé sur la page d'erreur d'authentification
    @GetMapping("/login-error")
    public String loginError() {
        return "login-error";
    }

    // méthode appelée pour contrôler ce qui est envoyé sur la page de non autorisation d'accès
    @GetMapping("/error")
    public String loginUnauthorized() {
        return "login-unauthorized";
    }
}
