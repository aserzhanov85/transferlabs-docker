package ru.sbrf.transfer.docker.lab.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class ClientDto implements Serializable {
    private String firstName;
    private String secondName;
    private String lastName;
    private Date birthDate;
}
