package br.com.dv.acmap.service;

import br.com.dv.acmap.dto.AccidentDTO;
import br.com.dv.acmap.entity.Accident;
import br.com.dv.acmap.mapper.AccidentMapper;
import br.com.dv.acmap.repository.AccidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentServiceImpl implements AccidentService {

    private final AccidentRepository accidentRepository;
    private final AccidentMapper accidentMapper;

    public AccidentServiceImpl(AccidentRepository accidentRepository,
                               AccidentMapper accidentMapper) {
        this.accidentRepository = accidentRepository;
        this.accidentMapper = accidentMapper;
    }

    @Override
    public List<AccidentDTO> getAllAccidents() {
        List<Accident> accidents = accidentRepository.findAll();
        return accidentMapper.toAccidentDTOs(accidents);
    }

}
