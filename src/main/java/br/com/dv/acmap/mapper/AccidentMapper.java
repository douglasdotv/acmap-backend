package br.com.dv.acmap.mapper;

import br.com.dv.acmap.dto.AccidentDTO;
import br.com.dv.acmap.entity.Accident;
import br.com.dv.acmap.entity.AccidentCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class AccidentMapper {

    @Mapping(target = "categories", expression = "java(mapCategories(accident.getCategories()))")
    public abstract AccidentDTO toAccidentDTO(Accident accident);

    public abstract List<AccidentDTO> toAccidentDTOs(List<Accident> accidents);

    protected List<String> mapCategories(List<AccidentCategory> categories) {
        if (categories == null) {
            return null;
        }

        return categories.stream().map(AccidentCategory::getCategory).collect(Collectors.toList());
    }

}
