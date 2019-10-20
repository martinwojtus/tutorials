package com.frontbackend.thymeleaf.service;

import com.frontbackend.thymeleaf.model.Contact;
import com.frontbackend.thymeleaf.model.ContactType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ContactService {

    public List<Contact> getContactList() {
        return Arrays.asList(Contact.builder()
                                    .name("John Doe")
                                    .email("john.doe@frontbackend.com")
                                    .type(ContactType.INDIVIDUAL)
                                    .build(),
                Contact.builder()
                       .name("Ilysa Kelledy")
                       .email("ilysa.kelledy@frontbackend.com")
                       .type(ContactType.INDIVIDUAL)
                       .build(),
                Contact.builder()
                       .email("group@frontbackend.com")
                       .name("FrontBackend Group")
                       .type(ContactType.GROUP)
                       .members(Arrays.asList(Contact.builder()
                                                     .name("Lawrence Mortel")
                                                     .email("lawrence.mortel@frontbackend.com")
                                                     .type(ContactType.INDIVIDUAL)
                                                     .build(),
                               Contact.builder()
                                      .name("Trev Dunderdale")
                                      .email("trev.dunderdale@frontbackend.com")
                                      .type(ContactType.INDIVIDUAL)
                                      .build()))
                       .build()

        );
    }
}
