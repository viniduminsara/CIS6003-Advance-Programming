package dev.viniduminsara.pahanaedu.business.bill.service;

import dev.viniduminsara.pahanaedu.business.bill.dto.BillDTO;

import java.util.List;

public interface BillService {

    boolean saveOrder(BillDTO billDTO);

    int getBillCount();

    List<BillDTO> getAllBills();

}
