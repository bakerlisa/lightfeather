package com.lightfeather.lightfeather.repositorties;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lightfeather.lightfeather.models.Position;

public interface PositionRepository extends CrudRepository<Position, Long> {
    List<Position> findAll();
    
}
