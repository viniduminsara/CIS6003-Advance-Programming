package dev.viniduminsara.pahanaedu.business.bill.dto;

import java.time.LocalDate;
import java.util.List;

public class BillDTO {

    private String orderId;
    private List<BillItemDTO> orderItems;
    private Double totalAmount;
    private String customerId;
    private LocalDate date;

    private BillDTO(Builder builder) {
        this.orderId = builder.orderId;
        this.orderItems = builder.orderItems;
        this.totalAmount = builder.totalAmount;
        this.customerId = builder.customerId;
        this.date = builder.date;
    }

    public static class Builder {
        private String orderId;
        private List<BillItemDTO> orderItems;
        private Double totalAmount;
        private String customerId;
        private LocalDate date;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOrderItems(List<BillItemDTO> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Builder setTotalAmount(Double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public BillDTO build() {
            return new BillDTO(this);
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<BillItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<BillItemDTO> orderItems) {
        this.orderItems = orderItems;
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
        return "BillDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderItems=" + orderItems +
                ", totalAmount=" + totalAmount +
                ", customerId='" + customerId + '\'' +
                ", date=" + date +
                '}';
    }
}
