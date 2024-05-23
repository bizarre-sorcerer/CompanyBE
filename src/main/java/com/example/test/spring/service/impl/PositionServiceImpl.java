package com.example.test.spring.service.impl;

import com.example.test.spring.dto.PositionDTO;
import com.example.test.spring.entities.Position;
import com.example.test.spring.mappers.PositionsMapper;
import com.example.test.spring.repositories.PositionRepository;
import com.example.test.spring.service.PositionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final PositionsMapper positionsMapper;

    public PositionServiceImpl(PositionRepository positionRepository, PositionsMapper positionsMapper) {
        this.positionRepository = positionRepository;
        this.positionsMapper = positionsMapper;
    }

    @Override
    public List<PositionDTO> getAllPositions() {
        List<Position> positions = positionRepository.findAll();

        return positions.stream()
                .map(positionsMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public PositionDTO getPositionById(Integer positionId) {
        Optional<Position> positionOptional = positionRepository.findById(positionId);

        if (positionOptional.isPresent()) {
            Position position = positionOptional.get();
            return positionsMapper.toDTO(position);
        } else {
            return null;
        }
    }

    @Override
    public PositionDTO addPosition(PositionDTO positionDTO) {
        Position position = positionsMapper.toEntity(positionDTO);
        Position savePosition = positionRepository.save(position);
        return positionsMapper.toDTO(savePosition);
    }

    @Override
    public void deleteAll() {
        positionRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer positionId) {
        positionRepository.deleteById(positionId);
    }
}


