package dev.viniduminsara.pahanaedu.business.bill.service.impl;

import dev.viniduminsara.pahanaedu.business.bill.dto.BillDTO;
import dev.viniduminsara.pahanaedu.business.bill.mapper.BillMapper;
import dev.viniduminsara.pahanaedu.business.bill.service.BillService;
import dev.viniduminsara.pahanaedu.persistence.order.dao.BillDAO;
import dev.viniduminsara.pahanaedu.persistence.order.dao.impl.BillDAOImpl;

import java.time.LocalDate;
import java.util.UUID;

public class BillServiceImpl implements BillService {

    private BillDAO orderDAO = new BillDAOImpl();

    @Override
    public boolean saveOrder(BillDTO billDTO) {
        billDTO.setOrderId(UUID.randomUUID().toString());
        billDTO.setDate(LocalDate.now());
        return orderDAO.save(BillMapper.toEntity(billDTO));
    }

    @Override
    public int getBillCount() {
        return orderDAO.getCount();
    }
}
