package br.com.dv.acmap.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    private String operator;

    private String flightNumber;

    private String aircraftType;

    private String aircraftRegistration;

    private Integer occupants;

    private Integer fatalities;

    private String location;

    private Double latitude;

    private Double longitude;

    private String country;

    private String departureAirportIcao;

    private String departureAirportCity;

    private String departureAirportCountry;

    private String destinationAirportIcao;

    private String destinationAirportCity;

    private String destinationAirportCountry;

    private String flightPhase;

    private String description;

    private Boolean isDisputed;

    @OneToMany(mappedBy = "accident")
    private List<AccidentCategory> categories;

    @OneToMany(mappedBy = "accident")
    private List<AccidentResource> resources;

}