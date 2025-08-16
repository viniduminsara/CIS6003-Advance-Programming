package dev.viniduminsara.pahanaedu.business.bill.service;

import dev.viniduminsara.pahanaedu.business.bill.dto.BillDTO;

public interface BillService {

    boolean saveOrder(BillDTO billDTO);

    int getBillCount();

}
