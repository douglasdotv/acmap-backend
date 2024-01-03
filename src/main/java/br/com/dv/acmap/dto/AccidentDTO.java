package br.com.dv.acmap.dto;

import java.time.LocalDate;
import java.util.List;

public record AccidentDTO(
        LocalDate date,
        String operator,
        String flightNumber,
        String aircraftModel,
        String aircraftRegistration,
        Integer occupants,
        Integer fatalities,
        String location,
        Double latitude,
        Double longitude,
        String country,
        String departureAirportIcao,
        String departureAirportCity,
        String departureAirportCountry,
        String destinationAirportIcao,
        String destinationAirportCity,
        String destinationAirportCountry,
        String flightPhase,
        String description,
        Boolean disputed,
        List<String> categories
) {
}
