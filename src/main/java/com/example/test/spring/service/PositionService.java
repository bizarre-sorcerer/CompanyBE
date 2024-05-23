package com.example.test.spring.service;

import com.example.test.spring.dto.PositionDTO;

import java.util.List;

public interface PositionService {
    List<PositionDTO> getAllPositions();

    PositionDTO getPositionById(Integer positionId);

    PositionDTO addPosition(PositionDTO departmentDTO);

    void deleteAll();

    void deleteById(Integer positionId);
}
