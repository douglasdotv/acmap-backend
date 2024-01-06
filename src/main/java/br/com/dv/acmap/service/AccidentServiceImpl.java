package br.com.dv.acmap.service;

import br.com.dv.acmap.dto.AccidentDTO;
import br.com.dv.acmap.dto.SearchFormDTO;
import br.com.dv.acmap.entity.Accident;
import br.com.dv.acmap.mapper.AccidentMapper;
import br.com.dv.acmap.repository.AccidentCategoryRepository;
import br.com.dv.acmap.repository.AccidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentServiceImpl implements AccidentService {

    private final AccidentRepository accidentRepository;
    private final AccidentMapper accidentMapper;
    private final AccidentCategoryRepository accidentCategoryRepository;

    public AccidentServiceImpl(AccidentRepository accidentRepository,
                               AccidentMapper accidentMapper,
                               AccidentCategoryRepository accidentCategoryRepository) {
        this.accidentRepository = accidentRepository;
        this.accidentMapper = accidentMapper;
        this.accidentCategoryRepository = accidentCategoryRepository;
    }

    @Override
    public List<AccidentDTO> getAllAccidents() {
        List<Accident> accidents = accidentRepository.findAll();
        return accidentMapper.toAccidentDTOs(accidents);
    }

    public List<AccidentDTO> searchAccidents(SearchFormDTO form) {
        List<Accident> accidents = accidentRepository.findBySearchFilters(
                form.fatalities(),
                form.operator(),
                form.aircraftType(),
                form.accidentCategory()
        );
        return accidentMapper.toAccidentDTOs(accidents);
    }

    public List<String> getOperators() {
        return accidentRepository.findDistinctOperators();
    }

    public List<String> getAircraftTypes() {
        return accidentRepository.findDistinctAircraftTypes();
    }

    public List<String> getCategories() {
        return accidentCategoryRepository.findDistinctCategories();
    }

}
