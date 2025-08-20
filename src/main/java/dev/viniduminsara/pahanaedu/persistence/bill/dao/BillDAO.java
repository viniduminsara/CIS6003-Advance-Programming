package dev.viniduminsara.pahanaedu.persistence.bill.dao;

import dev.viniduminsara.pahanaedu.business.bill.model.Bill;
import dev.viniduminsara.pahanaedu.business.bill.model.BillInvoice;

import java.util.List;

public interface BillDAO {

    boolean save(Bill bill);

    int getCount();

    List<Bill> findAll();

    BillInvoice findById(String billId);

}
