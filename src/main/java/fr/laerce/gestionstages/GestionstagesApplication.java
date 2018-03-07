package fr.laerce.gestionstages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// l'instruction '(exclude = {SecurityAutoConfiguration.class })' permet d'éviter de se logger dans
// l'application avec le nom 'user' et un mot de passe généré aléatoirement dans la console quand
// on a téléchargé la dépendance Spring Security sans avoir paramétré les droits d'accès à l'application
// dans IntelliJ
// @SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication
public class GestionstagesApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestionstagesApplication.class, args);
    }
}
