package br.com.dv.acmap.repository;

import br.com.dv.acmap.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Integer> {

    @Query("SELECT DISTINCT a.operator FROM Accident a ORDER BY a.operator")
    List<String> findDistinctOperators();

    @Query("SELECT DISTINCT a.aircraftType FROM Accident a ORDER BY a.aircraftType")
    List<String> findDistinctAircraftTypes();

}
