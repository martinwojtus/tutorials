package com.frontbackend.springboot.person.service;

import static org.springframework.data.jpa.domain.Specification.where;

import com.frontbackend.springboot.person.controller.model.paging.PageInfo;
import com.frontbackend.springboot.person.dto.PageDto;
import com.frontbackend.springboot.person.dto.PersonDto;
import com.frontbackend.springboot.person.dto.PersonFilter;
import com.frontbackend.springboot.person.exception.PersonNotFoundException;
import com.frontbackend.springboot.person.jpa.model.PersonEntity;
import com.frontbackend.springboot.person.jpa.repository.PersonRepository;
import com.frontbackend.springboot.person.jpa.utils.JpaSpecifications;
import com.frontbackend.springboot.person.jpa.utils.PageInfoMapper;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public UUID save(PersonDto personDto) {
        return personDto.getId() != null ? saveModified(personDto) : saveNew(personDto);
    }

    public PersonDto find(UUID id) {
        return personRepository.findById(id)
                .map(this::toPersonDto)
                .orElseThrow(PersonNotFoundException::new);
    }

    private UUID saveModified(PersonDto personDto) {
        PersonEntity entity = personRepository.findById(personDto.getId())
                .map(ent -> this.fillPersonEntity(personDto, ent))
                .orElseThrow(PersonNotFoundException::new);

        personRepository.save(entity);
        return personDto.getId();
    }

    private UUID saveNew(PersonDto personDto) {
        PersonEntity entity = fillPersonEntity(personDto, new PersonEntity());
        entity.setId(UUID.randomUUID());
        PersonEntity saved = personRepository.save(entity);
        return saved.getId();
    }

    private PersonEntity fillPersonEntity(PersonDto personDto, PersonEntity entity) {
        entity.setFirstName(personDto.getFirstName());
        entity.setLastName(personDto.getLastName());
        entity.setAddress(personDto.getAddress());
        entity.setAge(personDto.getAge());
        return entity;
    }

    public void deletePerson(UUID id) {
        PersonEntity byId = personRepository.findById(id)
                .orElseThrow(PersonNotFoundException::new);
        personRepository.delete(byId);
    }

    public PageDto<PersonDto> filter(PersonFilter filter, PageInfo pageInfo) {
        PageRequest pageRequest = PageInfoMapper.toPageRequest(pageInfo);
        Page<PersonEntity> personEntityPage = personRepository.findAll(applyWhere(filter), pageRequest);

        return PageDto.<PersonDto>builder()
                .rows(personEntityPage.getContent()
                              .stream()
                              .map(this::toPersonDto)
                              .collect(Collectors.toList()))
                .totalElements(personEntityPage.getTotalElements())
                .totalPages(personEntityPage.getTotalPages())
                .build();
    }

    private Specification<PersonEntity> applyWhere(PersonFilter filter) {
        Specification<PersonEntity> firstName = JpaSpecifications.upperLike(filter.getFirstName(), "firstName");
        Specification<PersonEntity> lastName = JpaSpecifications.upperLike(filter.getLastName(), "lastName");
        Specification<PersonEntity> address = JpaSpecifications.upperLike(filter.getAddress(), "address");
        Specification<PersonEntity> age = JpaSpecifications.checkList(filter.getAge(), "age");

        return where(firstName).and(lastName)
                .and(address)
                .and(age);
    }

    private PersonDto toPersonDto(PersonEntity entity) {
        return PersonDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .age(entity.getAge())
                .address(entity.getAddress())
                .build();
    }
}
