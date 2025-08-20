package dev.viniduminsara.pahanaedu.business.bill.mapper;

import dev.viniduminsara.pahanaedu.business.bill.dto.BillInvoiceDTO;
import dev.viniduminsara.pahanaedu.business.bill.dto.BillInvoiceItemDTO;
import dev.viniduminsara.pahanaedu.business.bill.model.BillInvoice;
import dev.viniduminsara.pahanaedu.business.bill.model.BillInvoiceItem;

import java.util.List;
import java.util.stream.Collectors;

public class BillInvoiceMapper {

    public static BillInvoiceDTO toDTO(BillInvoice invoice) {
        if (invoice == null) return null;

        List<BillInvoiceItemDTO> itemDTOs = null;
        if (invoice.getBillItems() != null) {
            itemDTOs = invoice.getBillItems().stream()
                    .map(BillInvoiceMapper::toItemDTO)
                    .collect(Collectors.toList());
        }

        return new BillInvoiceDTO.Builder()
                .orderId(invoice.getBillId())
                .orderItems(itemDTOs)
                .totalAmount(invoice.getTotalAmount())
                .customerId(invoice.getCustomerId())
                .date(invoice.getDate())
                .build();
    }

    public static BillInvoice toEntity(BillInvoiceDTO dto) {
        if (dto == null) return null;

        List<BillInvoiceItem> items = null;
        if (dto.getBillItems() != null) {
            items = dto.getBillItems().stream()
                    .map(BillInvoiceMapper::toItemEntity)
                    .collect(Collectors.toList());
        }

        return new BillInvoice.Builder()
                .orderId(dto.getBillId())
                .orderItems(items)
                .totalAmount(dto.getTotalAmount())
                .customerId(dto.getCustomerId())
                .date(dto.getDate())
                .build();
    }

    public static BillInvoiceItemDTO toItemDTO(BillInvoiceItem item) {
        if (item == null) return null;

        return new BillInvoiceItemDTO.Builder()
                .itemCode(item.getItemCode())
                .itemName(item.getItemName())
                .quantity(item.getQuantity())
                .unitPrice(item.getUnitPrice())
                .build();
    }

    public static BillInvoiceItem toItemEntity(BillInvoiceItemDTO dto) {
        if (dto == null) return null;

        return new BillInvoiceItem.Builder()
                .itemCode(dto.getItemCode())
                .itemName(dto.getItemName())
                .quantity(dto.getQuantity())
                .unitPrice(dto.getUnitPrice())
                .build();
    }
}
