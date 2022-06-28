package com.lightfeather.lightfeather.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
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

    @RequestMapping(value="/api/people", method=RequestMethod.GET)
    public List<People> index() {
        return peopleService.allPeople();
    }

    // @RequestMapping(value="/api/person/{id}")
    // public People show(@PathVariable("id") Long id){
    //     People people = peopleService.findPerson(id);
    //     return people;
    // }

    // @GetMapping('/people/new')
    // public String newPerson(@ModelAttribute("person") People person){
    //     return "addPerson.jsp"
    // }

    // @RequestMapping(value="/api/submit", method=RequestMethod.POST)
    // public People addPerson(@Valid @ModelAttribute("person") People person, BindingResult result) {
    //     peopleService.createPerson(person);
    //     return "redirect:/";
    // }

    // @GetMapping("/")
    // public void dashboard(HttpServletRequest response){
    //     response.setHeader("Location", "localhost:3000/");
    //     response.setStatus(302);
    // }
}
