package br.com.dv.acmap.mapper;

import br.com.dv.acmap.dto.AccidentDTO;
import br.com.dv.acmap.dto.ResourceDTO;
import br.com.dv.acmap.entity.Accident;
import br.com.dv.acmap.entity.AccidentCategory;
import br.com.dv.acmap.entity.AccidentResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class AccidentMapper {

    @Mapping(target = "categories", expression = "java(mapCategories(accident.getCategories()))")
    @Mapping(target = "resources", expression = "java(mapResources(accident.getResources()))")
    @SuppressWarnings("unused")
    public abstract AccidentDTO toAccidentDTO(Accident accident);

    public abstract List<AccidentDTO> toAccidentDTOs(List<Accident> accidents);

    @SuppressWarnings("unused")
    protected List<String> mapCategories(List<AccidentCategory> categories) {
        if (categories == null) {
            return Collections.emptyList();
        }

        return categories.stream().map(AccidentCategory::getCategory).collect(Collectors.toList());
    }

    @SuppressWarnings("unused")
    protected List<ResourceDTO> mapResources(List<AccidentResource> resources) {
        if (resources == null) {
            return Collections.emptyList();
        }

        return resources.stream()
                .map(resource -> new ResourceDTO(resource.getResourceUrl(), resource.getDescription()))
                .collect(Collectors.toList());
    }

}
