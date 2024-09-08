package ru.sbrf.transfer.docker.lab.repository;

import org.springframework.stereotype.Component;
import ru.sbrf.transfer.docker.lab.repository.entity.ClientEntity;

import java.util.*;

@Component
public class InMemoryClientRepository implements ClientRepository {

    private final Map<String, ClientEntity> clientEntityMap = new HashMap<>();

    public InMemoryClientRepository() {
        clientEntityMap.put("1",
                ClientEntity.builder()
                        .id("1")
                        .firstName("Иван")
                        .secondName("Иванович")
                        .lastName("Иванов")
                        .birthDate(new Date(2005, Calendar.MAY, 7))
                        .build()
        );
        clientEntityMap.put("2",
                ClientEntity.builder()
                        .id("2")
                        .firstName("Петр")
                        .secondName("Петрович")
                        .lastName("Петров")
                        .birthDate(new Date(1995, Calendar.AUGUST, 10))
                        .build()
        );
        clientEntityMap.put("3",
                ClientEntity.builder()
                        .id("3")
                        .firstName("Сидр")
                        .secondName("Сидорович")
                        .lastName("Сидоров")
                        .birthDate(new Date(1985, Calendar.JANUARY, 1))
                        .build()
        );

    }

    @Override
    public List<ClientEntity> getClients() {
        return new ArrayList<>(clientEntityMap.values());
    }

    @Override
    public Optional<ClientEntity> getClient(String id) {
        return Optional.ofNullable(clientEntityMap.get(id));
    }

    @Override
    public String addClient(ClientEntity clientEntity) {
        int clientsCount = clientEntityMap.size();
        String newClientId = String.valueOf(clientsCount + 1);
        clientEntity.setId(newClientId);
        clientEntityMap.put(newClientId, clientEntity);
        return newClientId;
    }

    @Override
    public void updateClient(ClientEntity clientEntity) {
        clientEntityMap.put(clientEntity.getId(), clientEntity);
    }

    @Override
    public void removeClient(String id) {
        clientEntityMap.remove(id);
    }
}
