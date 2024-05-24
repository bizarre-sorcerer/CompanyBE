package com.example.test.spring.controllers;

import com.example.test.spring.dto.PositionDTO;
import com.example.test.spring.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
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

    @DeleteMapping("/all")
    public void clearAllEmployees() {
        positionService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deletePositionById(@PathVariable Integer id){
        positionService.deleteById(id);
    }
}
