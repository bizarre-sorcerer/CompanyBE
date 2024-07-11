package com.example.test.spring.controllers;

import com.example.test.spring.models.dtos.PositionDTO;
import com.example.test.spring.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
@RequiredArgsConstructor
public class PositionsController {
    private final PositionService positionService;

    @GetMapping
    public List<PositionDTO> getAllPositions(){
        return positionService.getAllPositions();
    }

    @GetMapping("/{positionId}")
    public PositionDTO getPositionById(@PathVariable Integer positionId){
        return positionService.getPositionById(positionId);
    }

    @PostMapping("/add")
    public PositionDTO addPosition(@RequestBody PositionDTO positionDTO) {
        return positionService.addPosition(positionDTO);
    }

    @PutMapping("/{id}")
    public PositionDTO updatePosition(@RequestBody PositionDTO positionDTO, @PathVariable Long id){
        return positionService.updatePosition(positionDTO, id);
    }

    @DeleteMapping("/all")
    public void clearAllEmployees() {
        positionService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deletePositionById(@PathVariable Integer id){
        positionService.deleteById(id);
    }
}
