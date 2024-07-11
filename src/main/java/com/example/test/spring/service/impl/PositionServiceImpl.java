package com.example.test.spring.service.impl;

import com.example.test.spring.models.dtos.PositionDTO;
import com.example.test.spring.models.entities.Position;
import com.example.test.spring.mappers.PositionsMapper;
import com.example.test.spring.repositories.PositionRepository;
import com.example.test.spring.service.PositionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final PositionsMapper positionsMapper;

    @Override
    public List<PositionDTO> getAllPositions() {
        List<Position> positions = positionRepository.findAll();

        return positions.stream()
                .map(positionsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PositionDTO getPositionById(Integer id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Position not found with id: " + id));
        return positionsMapper.toDTO(position);
    }

    @Override
    public PositionDTO addPosition(PositionDTO positionDTO) {
        Position position = positionsMapper.toEntity(positionDTO);
        Position savePosition = positionRepository.save(position);
        return positionsMapper.toDTO(savePosition);
    }

    @Override
    public PositionDTO updatePosition(PositionDTO positionDTO, Long id){
        positionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
        Position updatedPosition = positionsMapper.toEntity(positionDTO);
        Position savedPosition = positionRepository.save(updatedPosition);
        return positionsMapper.toDTO(savedPosition);
    }

    @Override
    public void deleteAll() {
        positionRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        positionRepository.deleteById(id);
    }
}


