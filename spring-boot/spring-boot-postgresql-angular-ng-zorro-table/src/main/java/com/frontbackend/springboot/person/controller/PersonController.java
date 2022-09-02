package com.frontbackend.springboot.person.controller;

import com.frontbackend.springboot.person.controller.model.request.CreatePersonRequest;
import com.frontbackend.springboot.person.controller.model.request.PersonFilterRequest;
import com.frontbackend.springboot.person.dto.PageDto;
import com.frontbackend.springboot.person.dto.PersonDto;
import com.frontbackend.springboot.person.service.PersonService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public UUID create(@RequestBody CreatePersonRequest createPersonRequest) {
        return personService.save(PersonDto.builder()
                                          .firstName(createPersonRequest.getFirstName())
                                          .lastName(createPersonRequest.getLastName())
                                          .age(createPersonRequest.getAge())
                                          .address(createPersonRequest.getAddress())
                                          .build());
    }

    @GetMapping("/{id}")
    public PersonDto find(@PathVariable("id") UUID id) {
        return personService.find(id);
    }

    @PutMapping("/{id}")
    public UUID save(@PathVariable UUID id, @RequestBody CreatePersonRequest createPersonRequest) {
        return personService.save(PersonDto.builder()
                                          .id(id)
                                          .firstName(createPersonRequest.getFirstName())
                                          .lastName(createPersonRequest.getLastName())
                                          .age(createPersonRequest.getAge())
                                          .address(createPersonRequest.getAddress())
                                          .build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        personService.deletePerson(id);
    }

    @PostMapping("/search")
    public PageDto<PersonDto> list(@RequestBody PersonFilterRequest request) {
        return personService.filter(request.getFilter(), request.getPageInfo());
    }
}
