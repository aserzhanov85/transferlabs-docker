package ru.sbrf.transfer.docker.lab.service;

import org.springframework.stereotype.Component;
import ru.sbrf.transfer.docker.lab.controller.dto.ClientDto;
import ru.sbrf.transfer.docker.lab.repository.entity.ClientEntity;

@Component
public class ClientMapper {
    public ClientDto map(ClientEntity clientEntity) {
        return ClientDto.builder()
                .firstName(clientEntity.getFirstName())
                .secondName(clientEntity.getSecondName())
                .lastName(clientEntity.getLastName())
                .birthDate(clientEntity.getBirthDate())
                .build();
    }

    public ClientEntity map(ClientDto clientDto) {
        return ClientEntity.builder()
                .firstName(clientDto.getFirstName())
                .secondName(clientDto.getSecondName())
                .lastName(clientDto.getLastName())
                .birthDate(clientDto.getBirthDate())
                .build();
    }
}
