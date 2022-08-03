package com.piliugin.tacocloud.repository;

import com.piliugin.tacocloud.model.order.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    TacoOrder save(TacoOrder tacoOrder);
}
