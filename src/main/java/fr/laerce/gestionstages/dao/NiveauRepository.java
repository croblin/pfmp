package fr.laerce.gestionstages.dao;

import fr.laerce.gestionstages.domain.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Projet gestionstages
 * Pour LAERCE SAS
 * <p>
 * Créé le  05/02/2018.
 *
 * @author fred
 */
public interface NiveauRepository extends JpaRepository<Niveau, Long> {
    public Niveau findByCode(String code);
}
