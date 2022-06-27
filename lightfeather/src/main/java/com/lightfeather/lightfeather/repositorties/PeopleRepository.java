package com.lightfeather.lightfeather.repositorties;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lightfeather.lightfeather.models.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, Long>{
    List<People> findAll();

}
