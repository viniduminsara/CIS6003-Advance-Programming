package dev.viniduminsara.pahanaedu.business.bill.service;

import dev.viniduminsara.pahanaedu.business.bill.dto.BillDTO;
import dev.viniduminsara.pahanaedu.business.bill.dto.BillInvoiceDTO;

import java.util.List;

public interface BillService {

    boolean saveOrder(BillDTO billDTO);

    int getBillCount();

    List<BillDTO> getAllBills();

    BillInvoiceDTO findBillById(String billId);

}
