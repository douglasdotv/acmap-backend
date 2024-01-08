package br.com.dv.acmap.dto;

import jakarta.validation.constraints.Min;

public record SearchFormDTO(
        @Min(0)
        Integer fatalities,
        String operator,
        String aircraftType,
        String accidentCategory
) {
}