package dev.viniduminsara.pahanaedu.business.order.service;

import dev.viniduminsara.pahanaedu.business.order.dto.OrderDTO;

public interface OrderService {

    boolean saveOrder(OrderDTO orderDTO);

    int getOrderCount();

}
