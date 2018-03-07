package fr.laerce.gestionstages.dao;

import fr.laerce.gestionstages.domain.Formateur;
import fr.laerce.gestionstages.domain.Individu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Projet gestionstages
 * Pour LAERCE SAS
 * <p>
 * Créé le  05/02/2018.
 *
 * @author fred
 */
public interface FormateurRepository extends JpaRepository<Formateur, Long>{
    public Formateur findByCodeSynchro(String code);
}
