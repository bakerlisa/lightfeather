package com.lightfeather.lightfeather.repositorties.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lightfeather.lightfeather.models.People;
import com.lightfeather.lightfeather.repositorties.PeopleRepository;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    public List<People> allPeople(){
        return peopleRepository.findAll();
    }

    public People createPerson(People person){
        return peopleRepository.save(person);
    }

    public People findPerson(Long id){
        Optional<People> optPerson = peopleRepository.findById(id);
        if(optPerson.isPresent()){
            return optPerson.get();
        }else{
            return null;
        }
    }
}
