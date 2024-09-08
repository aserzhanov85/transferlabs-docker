package ru.sbrf.transfer.docker.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.transfer.docker.lab.controller.dto.ClientDto;
import ru.sbrf.transfer.docker.lab.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientDto> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable String id) {
        return clientService.getClient(id);
    }

    @PostMapping
    public void addClient(@RequestBody ClientDto client) {
        clientService.addClient(client);
    }

    @PostMapping("/{id}")
    public void updateClient(@PathVariable String id, @RequestBody ClientDto client) {
        clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
}
