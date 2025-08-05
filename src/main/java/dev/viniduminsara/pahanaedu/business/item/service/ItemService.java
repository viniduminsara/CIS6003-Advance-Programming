package dev.viniduminsara.pahanaedu.business.item.service;

import dev.viniduminsara.pahanaedu.business.item.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    void saveItem(ItemDTO item);

    ItemDTO getItemByCode(String itemCode);

    List<ItemDTO> getAllItems();

    void updateItem(String itemCode, ItemDTO itemDTO);

    void deleteItem(String itemCode);
}
