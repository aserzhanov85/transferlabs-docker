package ru.sbrf.transfer.docker.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbrf.transfer.docker.lab.controller.dto.ClientDto;
import ru.sbrf.transfer.docker.lab.repository.ClientRepository;
import ru.sbrf.transfer.docker.lab.repository.entity.ClientEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<ClientDto> getClients() {
        return clientRepository.getClients().stream()
                .map(clientMapper::map)
                .collect(Collectors.toList());
    }

    public ClientDto getClient(String id) {
        return clientRepository.getClient(id)
                .map(clientMapper::map)
                .orElseThrow();
    }

    public void addClient(ClientDto client) {
        ClientEntity clientEntity = clientMapper.map(client);
        clientRepository.addClient(clientEntity);
    }

    public void updateClient(String id, ClientDto client) {
        ClientEntity clientEntity = clientMapper.map(client);
        clientEntity.setId(id);
        clientRepository.updateClient(clientEntity);
    }

    public void deleteClient(String id) {
        clientRepository.removeClient(id);
    }
}
