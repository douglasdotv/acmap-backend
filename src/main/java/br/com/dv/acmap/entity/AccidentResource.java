package br.com.dv.acmap.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AccidentResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String resourceUrl;

    private String description;

    @ManyToOne
    @JoinColumn(name = "accident_id", referencedColumnName = "id")
    private Accident accident;

}
