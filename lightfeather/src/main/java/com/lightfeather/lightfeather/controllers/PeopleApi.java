package com.lightfeather.lightfeather.controllers;

import java.util.List;

import javax.validation.Valid;

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

    @CrossOrigin(origins = "http://localhost:3000/people")
    @RequestMapping(value="/api/people", method=RequestMethod.GET)
    public List<People> index() {
        return peopleService.allPeople();
    }

    @CrossOrigin(origins = "http://localhost:3000/people")
    @RequestMapping(value="/api/person/{id}")
    public People show(@PathVariable("id") Long id){
        People people = peopleService.findPerson(id);
        return people;
    }

    @CrossOrigin(origins = "http://localhost:3000/people")
    @RequestMapping(value="/api/submit", method=RequestMethod.POST)
    public void addPerson(@Valid @ModelAttribute("person") People person, BindingResult result) {
        peopleService.createPerson(person);
    }

    // @GetMapping("/")
    // public void dashboard(HttpServletRequest response){
    //     response.setHeader("Location", "localhost:3000/");
    //     response.setStatus(302);
    // }
}
