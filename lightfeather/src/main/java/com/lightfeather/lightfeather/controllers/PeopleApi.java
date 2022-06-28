package com.lightfeather.lightfeather.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lightfeather.lightfeather.models.People;
import com.lightfeather.lightfeather.services.PeopleService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PeopleApi {
    private final PeopleService peopleService;

    public PeopleApi(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    // All the people in the database
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/api/people", method=RequestMethod.GET)
    public List<People> index() {
        return peopleService.allPeople();
    }
    
    // Single person in the database
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/api/person/{id}")
    public People show(@PathVariable("id") Long id){
        People people = peopleService.findPerson(id);
        return people;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/api/submit/{form}", method=RequestMethod.POST)
    public void addPerson(@PathVariable("form") People form) {
        peopleService.createPerson(form);
    }

}
