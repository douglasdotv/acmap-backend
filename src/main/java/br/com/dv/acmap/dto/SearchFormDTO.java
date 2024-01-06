package br.com.dv.acmap.dto;

public record SearchFormDTO(
        Integer fatalities,
        String operator,
        String aircraftType,
        String accidentCategory
) {
}
