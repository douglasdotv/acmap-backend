package br.com.dv.acmap.service;

import br.com.dv.acmap.dto.AccidentDTO;
import br.com.dv.acmap.dto.SearchFormDTO;

import java.util.List;

public interface AccidentService {

    List<AccidentDTO> getAllAccidents();

    List<AccidentDTO> searchAccidents(SearchFormDTO form);

    List<String> getOperators();

    List<String> getAircraftTypes();

    List<String> getCategories();

}
