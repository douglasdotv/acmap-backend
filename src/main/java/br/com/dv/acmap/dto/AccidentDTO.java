package br.com.dv.acmap.dto;

import br.com.dv.acmap.entity.Airport;

import java.time.LocalDate;
import java.util.List;

public record AccidentDTO(
        LocalDate date,
        String operator,
        String flightNumber,
        String aircraftType,
        String aircraftRegistration,
        Integer occupants,
        Integer fatalities,
        String location,
        Double latitude,
        Double longitude,
        String country,
        Airport departureAirport,
        Airport destinationAirport,
        String flightPhase,
        String description,
        Boolean isDisputed,
        List<String> categories,
        List<ResourceDTO> resources,
        List<StopoverDTO> stopovers
) {
}
