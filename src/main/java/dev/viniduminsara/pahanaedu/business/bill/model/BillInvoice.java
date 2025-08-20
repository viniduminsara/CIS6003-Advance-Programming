package dev.viniduminsara.pahanaedu.business.bill.model;

import java.time.LocalDate;
import java.util.List;

public class BillInvoice {

    private String billId;
    private List<BillInvoiceItem> billItems;
    private Double totalAmount;
    private String customerId;
    private LocalDate date;

    private BillInvoice(Builder builder) {
        this.billId = builder.billId;
        this.billItems = builder.billItems;
        this.totalAmount = builder.totalAmount;
        this.customerId = builder.customerId;
        this.date = builder.date;
    }

    public static class Builder {
        private String billId;
        private List<BillInvoiceItem> billItems;
        private Double totalAmount;
        private String customerId;
        private LocalDate date;

        public Builder orderId(String billId) {
            this.billId = billId;
            return this;
        }

        public Builder orderItems(List<BillInvoiceItem> billItems) {
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

        public BillInvoice build() {
            return new BillInvoice(this);
        }
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public List<BillInvoiceItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillInvoiceItem> billItems) {
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
        return "BillInvoice{" +
                "orderId='" + billId + '\'' +
                ", orderItems=" + billItems +
                ", totalAmount=" + totalAmount +
                ", customerId='" + customerId + '\'' +
                ", date=" + date +
                '}';
    }
}
