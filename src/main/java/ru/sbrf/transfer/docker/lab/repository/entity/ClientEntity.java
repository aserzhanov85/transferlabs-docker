package ru.sbrf.transfer.docker.lab.repository.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ClientEntity {
    private String id;
    private String firstName;
    private String secondName;
    private String lastName;
    private Date birthDate;
}
