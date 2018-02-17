package fr.java.lab.springdatajpa.controller;

import fr.java.lab.springdatajpa.domain.Locataire;
import fr.java.lab.springdatajpa.repository.LocataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LocataireController {

    @Autowired
    LocataireRepository locataireRepository;

    @GetMapping("/locataires")
    public List<Locataire> getAllLocataires(){
        return locataireRepository.findAll();
    }

    @PostMapping("/locataires")
    public Locataire createLocataire (@Valid @RequestBody Locataire locataire){
        return locataireRepository.save(locataire);
    }

    @GetMapping("/locataires/{id}")
    public ResponseEntity<Locataire> getLocataireById(@PathVariable(value = "id") Long locataireId) {
        Locataire locataire = (Locataire) locataireRepository.getOne(locataireId);
        if(locataire == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(locataire);
    }

    @PutMapping("/locataires/{id}")
    public ResponseEntity<Locataire> updateLocataire(@PathVariable(value = "id") Long locataireId,
                                           @Valid @RequestBody Locataire locataireDetails) {
        Locataire locataire = locataireRepository.getOne(locataireId);
        if(locataire == null) {
            return ResponseEntity.notFound().build();
        }
        locataire.setNom(locataireDetails.getNom());
        locataire.setPrenom(locataireDetails.getPrenom());
        locataire.setEmail(locataireDetails.getEmail());

        Locataire updatedNote = locataireRepository.save(locataire);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/locataires/{id}")
    public ResponseEntity<Locataire> deleteNote(@PathVariable(value = "id") Long locataireId) {
        Locataire locataire = locataireRepository.getOne(locataireId);
        if(locataire == null) {
            return ResponseEntity.notFound().build();
        }

        locataireRepository.delete(locataire);
        return ResponseEntity.ok().build();
    }
}
