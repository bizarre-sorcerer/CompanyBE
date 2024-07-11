package com.example.test.spring.mappers;

import com.example.test.spring.models.dtos.PositionDTO;
import com.example.test.spring.models.entities.Position;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionsMapper {

    Position toEntity(PositionDTO positionDTO);

    PositionDTO toDTO(Position position);
}
