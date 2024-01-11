package br.com.dv.acmap.repository;

import br.com.dv.acmap.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Integer> {
}
