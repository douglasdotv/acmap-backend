package br.com.dv.acmap.mapper;

import br.com.dv.acmap.dto.AccidentDTO;
import br.com.dv.acmap.dto.AirportDTO;
import br.com.dv.acmap.dto.ResourceDTO;
import br.com.dv.acmap.dto.StopoverDTO;
import br.com.dv.acmap.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class AccidentMapper {

    @Mapping(target = "departureAirport", expression = "java(mapAirport(accident.getDepartureAirport()))")
    @Mapping(target = "destinationAirport", expression = "java(mapAirport(accident.getDestinationAirport()))")
    @Mapping(target = "categories", expression = "java(mapCategories(accident.getCategories()))")
    @Mapping(target = "resources", expression = "java(mapResources(accident.getResources()))")
    @Mapping(target = "stopovers", expression = "java(mapStopovers(accident.getStopovers()))")
    @SuppressWarnings("unused")
    public abstract AccidentDTO toAccidentDTO(Accident accident);

    public abstract List<AccidentDTO> toAccidentDTOs(List<Accident> accidents);

    @SuppressWarnings("unused")
    protected List<String> mapCategories(List<AccidentCategory> categories) {
        if (categories == null) {
            return Collections.emptyList();
        }

        return categories.stream().map(AccidentCategory::getCategory).collect(Collectors.toList());
    }

    @SuppressWarnings("unused")
    protected List<ResourceDTO> mapResources(List<AccidentResource> resources) {
        if (resources == null) {
            return Collections.emptyList();
        }

        return resources.stream()
                .map(resource -> new ResourceDTO(resource.getResourceUrl(), resource.getDescription()))
                .collect(Collectors.toList());
    }

    protected AirportDTO mapAirport(Airport airport) {
        if (airport == null) {
            return null;
        }

        return new AirportDTO(airport.getIcaoCode(), airport.getIataCode(), airport.getName(),
                airport.getCity(), airport.getCountry());
    }

    @SuppressWarnings("unused")
    protected List<StopoverDTO> mapStopovers(List<Stopover> stopovers) {
        if (stopovers == null) {
            return Collections.emptyList();
        }

        return stopovers.stream()
                .map(stopover -> new StopoverDTO(mapAirport(stopover.getAirport()), stopover.getLeg()))
                .collect(Collectors.toList());
    }

}
