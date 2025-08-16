package dev.viniduminsara.pahanaedu.business.bill.service.impl;

import dev.viniduminsara.pahanaedu.business.bill.dto.BillDTO;
import dev.viniduminsara.pahanaedu.business.bill.mapper.BillMapper;
import dev.viniduminsara.pahanaedu.business.bill.model.Bill;
import dev.viniduminsara.pahanaedu.business.bill.service.BillService;
import dev.viniduminsara.pahanaedu.persistence.order.dao.BillDAO;
import dev.viniduminsara.pahanaedu.persistence.order.dao.impl.BillDAOImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BillServiceImpl implements BillService {

    private BillDAO billDAO = new BillDAOImpl();

    @Override
    public boolean saveOrder(BillDTO billDTO) {
        billDTO.setOrderId(UUID.randomUUID().toString());
        billDTO.setDate(LocalDate.now());
        return billDAO.save(BillMapper.toEntity(billDTO));
    }

    @Override
    public int getBillCount() {
        return billDAO.getCount();
    }

    @Override
    public List<BillDTO> getAllBills() {
        List<BillDTO> billDTOS = new ArrayList<>();
        List<Bill> bills = billDAO.findAll();
        for (Bill bill : bills) {
            billDTOS.add(BillMapper.toDTO(bill));
        }
        return billDTOS;
    }
}
