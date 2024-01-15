package br.com.dv.acmap.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stopover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "accident_id", referencedColumnName = "id")
    private Accident accident;

    private byte leg;

    @ManyToOne
    @JoinColumn(name = "airport_id", referencedColumnName = "id")
    private Airport airport;

}
