package com.example.connections;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnotherService {
    private final PersonRepository personRepository;

    public AnotherService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void runsInNewTransaction() {
        System.out.println(personRepository.findAll());
        Sleep.sleep(400);
    }
}
