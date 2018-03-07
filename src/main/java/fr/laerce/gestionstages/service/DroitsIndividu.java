package fr.laerce.gestionstages.service;

import fr.laerce.gestionstages.dao.IndividuRepository;
import fr.laerce.gestionstages.domain.Individu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DroitsIndividu {

    @Autowired
    private IndividuRepository repoIndividu;

    // méthode appelant toutes les autres de cette classe pour affecter des droits d'utilisation à un individu
    public void ajoutDroitsIndividu(Individu individu) {
        individu.setLogin(genererLogin(individu.getPrenom(),individu.getNom()));
        individu.setMdpOrigine(genererMdp());
        individu.setMdp(genererMdpCrypte(individu.getMdpOrigine()));
        individu.setRole("USER");
    }

    // méthode pour générer un login aléatoire via des contraintes précises pour un individu
    public String genererLogin(String prenom, String nom) {
        // on remplace les accents sur chaque voyelles
        prenom = prenom.replaceAll("[éèêë]","e");
        prenom = prenom.replaceAll("[àâ]","a");
        prenom = prenom.replaceAll("[ùû]","u");
        prenom = prenom.replaceAll("[îï]","i");
        // on enlève les caractères spéciaux du prénom, on transforme les caractères en minuscules,
        // et on ne garde que le premier caractère
        prenom = prenom.replaceAll("\\W","").toLowerCase().substring(0,1);
        // on enlève les caractères spéciaux du nom, on transforme les caractères en minuscules,
        // et on ne garde que les 7 premiers caractères si le nom contient au moins 7 caractères, sinon on garde tout les caractères
        nom = nom.replaceAll("\\W","").toLowerCase();
        if(nom.length() > 7) {
            nom = nom.substring(0,7);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(prenom);
        sb.append(nom);
        // on récupère la liste de tous les logins pour vérifier que la chaîne 'sb' ne soit pas déjà existante dans la table Individu
        int nb_doublons = 0;
        List<Individu> list_individus= repoIndividu.findAll();
        for(Individu individu : list_individus) {
            // on vérifie que le login n'est pas null ou qu'il ne contient pas de chaîne vide
            if(individu.getLogin() != null && !individu.getLogin().equals("")) {
                if(sb.toString().contains(individu.getLogin())) {
                    nb_doublons++;
                }
                if(nb_doublons != 0) {
                    sb.append(nb_doublons);
                }
            }
        }
        return sb.toString();
    }

    // méthode pour générer un mot de passe aléatoire via des contraintes précises pour un individu
    public String genererMdp() {
        char voyelles[] = {'a','e','i','o','u','y'};
        char consonnes[] = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
        char chiffres[] = {'0','1','2','3','4','5','6','7','8','9'};
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        // pour les 6 premiers caractères, un coup sur deux, on va tirer une consone aléatoire, puis une voyelle aléatoire
        for(int i=0;i<6;i++) {
            if(i%2 == 0) {
                sb.append(consonnes[rand.nextInt(consonnes.length)]);
            }
            else {
                sb.append(voyelles[rand.nextInt(voyelles.length)]);
            }
        }
        // pour les 4 derniers caractères, on génère aléatoirement 4 chiffres
        for(int j=0;j<4;j++) {
            sb.append(chiffres[rand.nextInt(chiffres.length)]);
        }
        return sb.toString();
    }

    // méthode pour créer un mot de passe crypté depuis le mot de passe en clair d'un individu
    public String genererMdpCrypte(String string) {
        // on remplace tous les caractères alphanumériques par un encryptage via la méthode encode()
        // de l'objet BCryptPasswordEncoder, importé depuis une bibliothèque de Spring Security
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
        return encoder.encode(string);
    }
}
