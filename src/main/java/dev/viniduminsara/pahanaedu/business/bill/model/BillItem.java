package dev.viniduminsara.pahanaedu.business.bill.model;


public class BillItem {
    private String itemCode;
    private Integer quantity;
    private Double unitPrice;

    private BillItem(Builder builder) {
        this.itemCode = builder.itemCode;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
    }

    public static class Builder {
        private String itemCode;
        private Integer quantity;
        private Double unitPrice;

        public Builder itemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder unitPrice(Double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public BillItem build() {
            return new BillItem(this);
        }
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "itemCode='" + itemCode + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
