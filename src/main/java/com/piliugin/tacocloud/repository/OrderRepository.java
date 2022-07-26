package com.piliugin.tacocloud.repository;

import com.piliugin.tacocloud.model.order.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);
}
