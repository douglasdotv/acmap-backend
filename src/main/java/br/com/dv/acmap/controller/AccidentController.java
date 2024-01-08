package br.com.dv.acmap.controller;

import br.com.dv.acmap.dto.AccidentDTO;
import br.com.dv.acmap.dto.SearchFormDTO;
import br.com.dv.acmap.service.AccidentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/accidents")
public class AccidentController {

    private final AccidentService accidentService;

    public AccidentController(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping
    public ResponseEntity<List<AccidentDTO>> getAllAccidents() {
        List<AccidentDTO> accidents = accidentService.getAllAccidents();
        return ResponseEntity.ok(accidents);
    }

    @PostMapping("/search")
    public ResponseEntity<List<AccidentDTO>> searchAccidents(@Valid @RequestBody SearchFormDTO form) {
        List<AccidentDTO> accidents = accidentService.searchAccidents(form);
        return ResponseEntity.ok(accidents);
    }

    @GetMapping("/operators")
    public ResponseEntity<List<String>> getOperators() {
        List<String> operators = accidentService.getOperators();
        return ResponseEntity.ok(operators);
    }

    @GetMapping("/aircraft-types")
    public ResponseEntity<List<String>> getAircraftModels() {
        List<String> aircraftTypes = accidentService.getAircraftTypes();
        return ResponseEntity.ok(aircraftTypes);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getCategories() {
        List<String> categories = accidentService.getCategories();
        return ResponseEntity.ok(categories);
    }

}
