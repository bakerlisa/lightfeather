package com.lightfeather.lightfeather.repositorties.services;

import java.util.List;
import java.util.Optional;

import com.lightfeather.lightfeather.models.Position;
import com.lightfeather.lightfeather.repositorties.PositionRepository;

public class PositionService {
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository){
        this.positionRepository  = positionRepository;
    }

    public List<Position> allPositions(){
        return positionRepository.findAll();
    }

    public Position createPosition(Position position){
        return positionRepository.save(position);
    }

    public Position findPosition(Long id){
        Optional<Position> optPos = positionRepository.findById(id);
        if(optPos.isPresent()){
            return optPos.get();
        }else{
            return null;
        }
    }
}
