package fr.java.lab.springdatajpa.repository;

import fr.java.lab.springdatajpa.domain.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "locataire", path = "locataire")
public interface LocataireRepository extends JpaRepository<Locataire, Long>, PagingAndSortingRepository<Locataire, Long>{
}
