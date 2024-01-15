package br.com.dv.acmap.dto;

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
        AirportDTO departureAirport,
        AirportDTO destinationAirport,
        String flightPhase,
        String description,
        Boolean isDisputed,
        List<String> categories,
        List<ResourceDTO> resources,
        List<StopoverDTO> stopovers
) {
}
