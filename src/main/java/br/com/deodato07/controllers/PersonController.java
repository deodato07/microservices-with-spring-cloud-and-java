package br.com.deodato07.controllers;

import br.com.deodato07.model.Person;
import br.com.deodato07.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @RequestMapping(value = "/{id}",
    method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public Person findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
}
