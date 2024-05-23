package com.example.test.spring.mappers;

import com.example.test.spring.dto.QualificationDTO;
import com.example.test.spring.entities.Qualification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QualificationMapper {
    Qualification toEntity(QualificationDTO qualificationDTO);

    QualificationDTO toDTO(Qualification qualification);
}
