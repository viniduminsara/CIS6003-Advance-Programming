package dev.viniduminsara.pahanaedu.business.order.service.impl;

import dev.viniduminsara.pahanaedu.business.order.dto.OrderDTO;
import dev.viniduminsara.pahanaedu.business.order.mapper.OrderMapper;
import dev.viniduminsara.pahanaedu.business.order.service.OrderService;
import dev.viniduminsara.pahanaedu.persistence.order.dao.OrderDAO;
import dev.viniduminsara.pahanaedu.persistence.order.dao.impl.OrderDAOImpl;

import java.time.LocalDate;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public boolean saveOrder(OrderDTO orderDTO) {
        orderDTO.setOrderId(UUID.randomUUID().toString());
        orderDTO.setDate(LocalDate.now());
        return orderDAO.save(OrderMapper.toEntity(orderDTO));
    }

    @Override
    public int getOrderCount() {
        return orderDAO.getCount();
    }
}
