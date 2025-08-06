package dev.viniduminsara.pahanaedu.persistence.item.dao;

import dev.viniduminsara.pahanaedu.business.item.model.Item;

import java.util.List;

public interface ItemDAO {

    void save(Item item);

    Item findById(String itemCode);

    List<Item> findAll();

    void update(String itemCode, Item item);

    void delete(String itemCode);

}
