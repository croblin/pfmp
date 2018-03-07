package fr.laerce.gestionstages.dao;

import fr.laerce.gestionstages.domain.Division;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Projet gestionstages
 * Pour LAERCE SAS
 * <p>
 * Créé le  05/02/2018.
 *
 * @author fred
 */
public interface DivisionRepository extends JpaRepository<Division, Long>{
    public Division findByCode(String code);
}
