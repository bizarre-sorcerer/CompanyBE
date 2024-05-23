package com.example.test.spring.controllers;

import com.example.test.spring.dto.EmployeeDTO;
import com.example.test.spring.dto.PositionDTO;
import com.example.test.spring.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions/")
@RequiredArgsConstructor
public class PositionsController {
    private final PositionService positionService;

    @GetMapping("/get-all")
    public List<PositionDTO> getAllPositions(){
        return positionService.getAllPositions();
    }

    @GetMapping("/get-byId/{positionId}")
    public PositionDTO getPositionById(@PathVariable Integer positionId, PositionDTO positionDTO){
        return positionService.getPositionById(positionId);
    }

    @PostMapping("/add")
    public PositionDTO addPosition(@RequestBody PositionDTO positionDTO) {
        return positionService.addPosition(positionDTO);
    }

    @DeleteMapping("/delete-all")
    public void clearAllEmployees() {
        positionService.deleteAll();
    }

    @DeleteMapping("/delete-byId/{positionId}")
    public void deletePositionById(@PathVariable Integer positionId){
        positionService.deleteById(positionId);
    }
}
