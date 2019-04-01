package com.jp.sped.web.application;

import com.jp.sped.data.entity.Person;
import com.jp.sped.data.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/database_ex")
public class DatabaseController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public String getDatabaseEx(Model model) {

        List<Person> personList = this.personRepository.findAll();
        model.addAttribute("personList", personList);

        return "database_ex";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Person> getDataBaseExJson () {
        return this.personRepository.findAll();
    }

    @PostMapping
    public String sendDataBaseEx(@RequestParam String name, Model model) {
        Person person = new Person();
        person.setName(name);
        personRepository.save(person);
        List<Person> newPersonList = this.personRepository.findAll();
        model.addAttribute("personList", newPersonList);
        return "database_ex";
    }

    @GetMapping(path = "/add")
    public @ResponseBody String addNewPerson (@RequestParam String name) {

        Person person = new Person();
        person.setName(name);
        personRepository.save(person);
        return "saved";
    }

}
