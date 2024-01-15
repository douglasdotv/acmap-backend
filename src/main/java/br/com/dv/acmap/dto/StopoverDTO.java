package br.com.dv.acmap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StopoverDTO(AirportDTO airport, @JsonProperty("sequence") byte leg) {
}
