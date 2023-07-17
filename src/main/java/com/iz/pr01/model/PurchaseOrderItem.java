package com.iz.pr01.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseOrderItem {
    public String supplierCode;
    public String plant;
    public String month;
    public String itemCode;

    public PurchaseOrderItem(String supplierCode, String plant, String month, String itemCode) {
        this.supplierCode = supplierCode;
        this.plant = plant;
        this.itemCode=itemCode;
        this.month=month;
    }
}
