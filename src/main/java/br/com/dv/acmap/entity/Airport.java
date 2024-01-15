package br.com.dv.acmap.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String icaoCode;

    private String iataCode;

    private String name;

    private String city;

    private String country;

    private Double latitude;

    private Double longitude;

    @OneToMany(mappedBy = "departureAirport")
    private List<Accident> departureAccidents;

    @OneToMany(mappedBy = "destinationAirport")
    private List<Accident> destinationAccidents;

    @OneToMany(mappedBy = "airport")
    private List<Stopover> stopovers;

}
