package br.com.dv.acmap.controller;

import br.com.dv.acmap.dto.AccidentDTO;
import br.com.dv.acmap.service.AccidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
