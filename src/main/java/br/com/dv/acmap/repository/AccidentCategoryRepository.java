package br.com.dv.acmap.repository;

import br.com.dv.acmap.entity.AccidentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccidentCategoryRepository extends JpaRepository<AccidentCategory, Integer> {

    @Query("SELECT DISTINCT ac.category FROM AccidentCategory ac ORDER BY ac.category")
    List<String> findDistinctCategories();

}
