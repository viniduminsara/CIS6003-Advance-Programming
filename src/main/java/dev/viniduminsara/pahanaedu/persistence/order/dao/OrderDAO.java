package dev.viniduminsara.pahanaedu.persistence.order.dao;

import dev.viniduminsara.pahanaedu.business.order.model.Order;

public interface OrderDAO {

    boolean save(Order order);

}
