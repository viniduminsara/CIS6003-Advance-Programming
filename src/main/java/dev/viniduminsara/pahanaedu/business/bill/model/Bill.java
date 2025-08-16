package dev.viniduminsara.pahanaedu.business.bill.model;

import java.time.LocalDate;
import java.util.List;

public class Bill {

    private String orderId;
    private List<BillItem> billItems;
    private Double totalAmount;
    private String customerId;
    private LocalDate date;

    private Bill(Builder builder) {
        this.orderId = builder.orderId;
        this.billItems = builder.billItems;
        this.totalAmount = builder.totalAmount;
        this.customerId = builder.customerId;
        this.date = builder.date;
    }

    public static class Builder {
        private String orderId;
        private List<BillItem> billItems;
        private Double totalAmount;
        private String customerId;
        private LocalDate date;

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder orderItems(List<BillItem> billItems) {
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

        public Bill build() {
            return new Bill(this);
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<BillItem> getOrderItems() {
        return billItems;
    }

    public void setOrderItems(List<BillItem> billItems) {
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
        return "Bill{" +
                "orderId='" + orderId + '\'' +
                ", orderItems=" + billItems +
                ", totalAmount=" + totalAmount +
                ", customerId='" + customerId + '\'' +
                ", date=" + date +
                '}';
    }
}
