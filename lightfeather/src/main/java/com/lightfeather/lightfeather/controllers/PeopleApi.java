package com.lightfeather.lightfeather.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lightfeather.lightfeather.models.People;
import com.lightfeather.lightfeather.services.PeopleService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PeopleApi {
    private final PeopleService peopleService;

    public PeopleApi(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    // All the people in the database
    @RequestMapping(value="/api/people", method=RequestMethod.GET)
    public List<People> index() {
        return peopleService.allPeople();
    }
    
    // Single person in the database
    @RequestMapping(value="/api/person/{id}")
    public People show(@PathVariable("id") Long id){
        People people = peopleService.findPerson(id);
        return people;
    }

    @RequestMapping(value="/api/submit/{form}", method=RequestMethod.POST)
    public void addPerson(@PathVariable("form") Optional<People> form) {
            // People person = new People(form);
            // System.out.println(form);        
            // peopleService.createPerson(form);
    }

}
