package com.piliugin.tacocloud.service;

import com.piliugin.tacocloud.repository.OrderRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class OrderAdminService {

    private final OrderRepository orderRepository;

    public OrderAdminService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
