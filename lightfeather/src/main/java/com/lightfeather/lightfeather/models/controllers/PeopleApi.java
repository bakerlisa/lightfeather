package com.lightfeather.lightfeather.models.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lightfeather.lightfeather.models.People;
import com.lightfeather.lightfeather.repositorties.services.PeopleService;
import org.springframework.web.bind.annotation.RequestMethod;


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
    
}
