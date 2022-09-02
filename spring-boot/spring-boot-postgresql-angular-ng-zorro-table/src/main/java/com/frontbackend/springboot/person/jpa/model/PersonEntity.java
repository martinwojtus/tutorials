package com.frontbackend.springboot.person.jpa.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity(name = "tbl_person")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PersonEntity {

    @Id
    @Type(type = "pg-uuid")
    private UUID id;

    private String firstName;
    private String lastName;
    private int age;
    private String address;
}
