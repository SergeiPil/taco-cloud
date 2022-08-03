package com.piliugin.tacocloud.repository;

import com.piliugin.tacocloud.model.order.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
    TacoOrder save(TacoOrder tacoOrder);
}
