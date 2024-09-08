package ru.sbrf.transfer.docker.lab.repository;

import ru.sbrf.transfer.docker.lab.repository.entity.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<ClientEntity> getClients();
    Optional<ClientEntity> getClient(String id);
    String addClient(ClientEntity clientEntity);
    void updateClient(ClientEntity clientEntity);
    void removeClient(String id);
}
