package dev.viniduminsara.pahanaedu.persistence.order.dao;

import dev.viniduminsara.pahanaedu.business.bill.model.Bill;

import java.util.List;

public interface BillDAO {

    boolean save(Bill bill);

    int getCount();

    List<Bill> findAll();

}
