package dev.viniduminsara.pahanaedu.business.bill.dto;

import java.time.LocalDate;
import java.util.List;

public class BillDTO {

    private String billId;
    private List<BillItemDTO> billItems;
    private Double totalAmount;
    private String customerId;
    private LocalDate date;

    private BillDTO(Builder builder) {
        this.billId = builder.billId;
        this.billItems = builder.billItems;
        this.totalAmount = builder.totalAmount;
        this.customerId = builder.customerId;
        this.date = builder.date;
    }

    public static class Builder {
        private String billId;
        private List<BillItemDTO> billItems;
        private Double totalAmount;
        private String customerId;
        private LocalDate date;

        public Builder billId(String orderId) {
            this.billId = orderId;
            return this;
        }

        public Builder billItems(List<BillItemDTO> orderItems) {
            this.billItems = orderItems;
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

        public BillDTO build() {
            return new BillDTO(this);
        }
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public List<BillItemDTO> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItemDTO> billItems) {
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
        return "BillDTO{" +
                "orderId='" + billId + '\'' +
                ", orderItems=" + billItems +
                ", totalAmount=" + totalAmount +
                ", customerId='" + customerId + '\'' +
                ", date=" + date +
                '}';
    }
}
