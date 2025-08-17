package dev.viniduminsara.pahanaedu.business.bill.mapper;

import dev.viniduminsara.pahanaedu.business.bill.dto.BillDTO;
import dev.viniduminsara.pahanaedu.business.bill.dto.BillItemDTO;
import dev.viniduminsara.pahanaedu.business.bill.model.Bill;
import dev.viniduminsara.pahanaedu.business.bill.model.BillItem;

import java.util.List;
import java.util.stream.Collectors;

public class BillMapper {
    public static BillDTO toDTO(Bill bill) {
        if (bill == null) return null;


        List<BillItemDTO> itemDTOs;
        if (bill.getBillItems() != null) {
            itemDTOs = bill.getBillItems()
                    .stream()
                    .map(BillMapper::toItemDTO)
                    .collect(Collectors.toList());
        } else {
            itemDTOs = null;
        }

        return new BillDTO.Builder()
                .billId(bill.getBillId())
                .customerId(bill.getCustomerId())
                .date(bill.getDate())
                .totalAmount(bill.getTotalAmount())
                .billItems(itemDTOs)
                .build();
    }

    public static Bill toEntity(BillDTO dto) {
        if (dto == null) return null;

        List<BillItem> items;
        if (dto.getBillItems() != null) {
            items = dto.getBillItems()
                    .stream()
                    .map(BillMapper::toItemEntity)
                    .collect(Collectors.toList());
        } else {
            items = null;
        }

        return new Bill.Builder()
                .orderId(dto.getBillId())
                .customerId(dto.getCustomerId())
                .date(dto.getDate())
                .totalAmount(dto.getTotalAmount())
                .orderItems(items)
                .build();
    }

    public static BillItemDTO toItemDTO(BillItem item) {
        if (item == null) return null;

        return new BillItemDTO.Builder()
                .itemCode(item.getItemCode())
                .quantity(item.getQuantity())
                .unitPrice(item.getUnitPrice())
                .build();
    }

    public static BillItem toItemEntity(BillItemDTO dto) {
        if (dto == null) return null;

        return new BillItem.Builder()
                .itemCode(dto.getItemCode())
                .quantity(dto.getQuantity())
                .unitPrice(dto.getUnitPrice())
                .build();
    }
}
