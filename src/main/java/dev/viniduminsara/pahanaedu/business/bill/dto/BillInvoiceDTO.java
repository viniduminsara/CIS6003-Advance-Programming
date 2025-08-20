package dev.viniduminsara.pahanaedu.business.bill.dto;

import java.time.LocalDate;
import java.util.List;

public class BillInvoiceDTO {

    private String billId;
    private List<BillInvoiceItemDTO> billItems;
    private Double totalAmount;
    private String customerId;
    private LocalDate date;

    private BillInvoiceDTO(Builder builder) {
        this.billId = builder.billId;
        this.billItems = builder.billItems;
        this.totalAmount = builder.totalAmount;
        this.customerId = builder.customerId;
        this.date = builder.date;
    }

    public static class Builder {
        private String billId;
        private List<BillInvoiceItemDTO> billItems;
        private Double totalAmount;
        private String customerId;
        private LocalDate date;

        public Builder orderId(String billId) {
            this.billId = billId;
            return this;
        }

        public Builder orderItems(List<BillInvoiceItemDTO> billItems) {
            this.billItems = billItems;
            return this;
        }

        public Builder totalAmount(Double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public BillInvoiceDTO build() {
            return new BillInvoiceDTO(this);
        }
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public List<BillInvoiceItemDTO> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillInvoiceItemDTO> billItems) {
        this.billItems = billItems;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BillInvoiceDTO{" +
                "orderId='" + billId + '\'' +
                ", orderItems=" + billItems +
                ", totalAmount=" + totalAmount +
                ", customerId='" + customerId + '\'' +
                ", date=" + date +
                '}';
    }
}
