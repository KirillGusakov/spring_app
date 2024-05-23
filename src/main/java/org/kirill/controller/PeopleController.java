package org.kirill.controller;

import jakarta.validation.Valid;
import org.kirill.entity.Person;
import org.kirill.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping()
    public String getPeople(Model model) {
        List<Person> people = personService.getAll();
        model.addAttribute("people", people);
        return "people/allPersons";
    }

    @GetMapping("/{id}")
    public String getPersonById(Model model,
                                @PathVariable("id") int id) {
        Person person = personService.getById(id);
        System.out.println(person.getBookList());
        model.addAttribute("person", person);
        return "people/showById";
    }

    @GetMapping("/new")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/newPerson";
    }

    @GetMapping("{id}/edit")
    public String editPerson(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personService.getById(id));
        return "people/editPerson";
    }

    @PostMapping()
    public String addPerson(@ModelAttribute("person") @Valid Person person,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/newPerson";
        }
        personService.save(person);
        return "redirect:/people";
    }

    @PatchMapping("/{id}")
    public String editPerson(@ModelAttribute("person") @Valid Person person,
                             BindingResult bindingResult,
                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "people/editPerson";
        }
        personService.update(person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
        return "redirect:/people";
    }
}
