package br.com.dv.acmap.repository;

import br.com.dv.acmap.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Integer> {

    @Query("SELECT DISTINCT a.operator FROM Accident a ORDER BY a.operator")
    List<String> findDistinctOperators();

    @Query("SELECT DISTINCT a.aircraftType FROM Accident a ORDER BY a.aircraftType")
    List<String> findDistinctAircraftTypes();

    @Query("""
            SELECT a FROM Accident a LEFT JOIN a.categories c WHERE
            (:fatalities IS NULL OR a.fatalities >= :fatalities) AND
            (:operator = '' OR a.operator = :operator) AND
            (:aircraftType = '' OR a.aircraftType LIKE CONCAT('%', :aircraftType, '%')) AND
            (:category = '' OR c.category = :category)
            """)
    List<Accident> findBySearchFilters(@Param("fatalities") Integer fatalities,
                                       @Param("operator") String operator,
                                       @Param("aircraftType") String aircraftType,
                                       @Param("category") String category);

}
