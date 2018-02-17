package fr.java.lab.springdatajpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Locataire")
@EntityListeners(AuditingEntityListener.class)
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Locataire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;

    @Getter
    @Setter
    private String email;

    public Locataire() {//Constructeur vide
    }

    public Locataire(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
}
