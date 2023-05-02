package ru.beganov.tacos.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.beganov.tacos.db.OrderRepository;

@Service
public class OrderAdminService {

    private OrderRepository repository;

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders() {
        repository.deleteAll();
    }
}
