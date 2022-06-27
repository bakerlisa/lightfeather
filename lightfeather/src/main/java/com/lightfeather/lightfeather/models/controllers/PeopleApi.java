package com.lightfeather.lightfeather.models.controllers;

import java.util.List;

import javax.xml.ws.RequestWrapper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lightfeather.lightfeather.models.People;
import com.lightfeather.lightfeather.repositorties.services.PeopleService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class PeopleApi {
    private final PeopleService peopleService;

    public PeopleApi(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @RequestMapping(value="/api/people", method=RequestMethod.GET)
    public List<People> index() {
        return peopleService.allPeople();
    }

    @RequestMapping(value="/api/person/{id}")
    public People show(@PathVariable("id") Long id){
        People people = peopleService.findPerson(id);
        return people;
    }

    // @RequestMapping(value="/api/create/person", method=RequestMethod.GET)
    // public SomeData requestMethodName(@RequestParam String param) {
    //     return new SomeData();
    // }
    
    
}
