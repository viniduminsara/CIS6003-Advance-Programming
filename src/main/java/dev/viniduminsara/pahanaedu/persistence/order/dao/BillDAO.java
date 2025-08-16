package dev.viniduminsara.pahanaedu.persistence.order.dao;

import dev.viniduminsara.pahanaedu.business.bill.model.Bill;

public interface BillDAO {

    boolean save(Bill bill);

    int getCount();

}
