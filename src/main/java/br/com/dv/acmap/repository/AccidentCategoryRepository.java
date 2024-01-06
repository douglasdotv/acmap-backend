package br.com.dv.acmap.repository;

import br.com.dv.acmap.entity.AccidentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentCategoryRepository extends JpaRepository<AccidentCategory, Integer> {
}
