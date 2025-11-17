package br.com.deodato07.services;

import br.com.deodato07.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Deodato");
        person.setLastName("Moreira");
        person.setAddress("São Jose dos Campos - SP - Brasil");

        person.setGender("Male");
        return person;
    }
}
