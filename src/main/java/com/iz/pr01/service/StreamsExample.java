package com.iz.pr01.service;

import com.iz.pr01.model.PurchaseOrder;
import com.iz.pr01.model.PurchaseOrderItem;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        PurchaseOrderItem item1 = new PurchaseOrderItem("SUP001","MG02","Jan","Item2");
        PurchaseOrderItem item2 = new PurchaseOrderItem("SUP001","MG02","Jan","Item2");
        PurchaseOrderItem item3 = new PurchaseOrderItem("SUP003","MG03","February","Item3");
        PurchaseOrderItem item4 = new PurchaseOrderItem("SUP004","MG04","March","Item4");
        PurchaseOrderItem item5 = new PurchaseOrderItem("SUP004","MG04","March","Item4");
        List<PurchaseOrderItem> poItem = new ArrayList<>();
        poItem.add(item1);
        poItem.add(item2);
        poItem.add(item3);
        poItem.add(item4);
        poItem.add(item5);
        Map<String,List<PurchaseOrderItem>> supplierBase = poItem.stream()
                .collect(Collectors.groupingBy(item->item.getSupplierCode()+item.getPlant()+item.getMonth()));

        Map<String,List<PurchaseOrderItem>> plantBase = poItem.stream()
                .collect(Collectors.groupingBy(item->item.getPlant()));

        Map<String,List<PurchaseOrderItem>> monthBase = poItem.stream()
                .collect(Collectors.groupingBy(item->item.getMonth()));

        System.out.println("-----------SupplierBase------------");
        System.out.println(supplierBase);
        System.out.println("-----------PlantBase------------");
        System.out.println(plantBase);
        System.out.println("----------Month--------");
        System.out.println(monthBase);

        List<PurchaseOrder> poDetails = new ArrayList<>();
        supplierBase.forEach((key,poItems)->{
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setOrderId("fdf");
            purchaseOrder.setPurchaseOrderItems(poItems);
            poDetails.add(purchaseOrder);
        });
        List<PurchaseOrder> finalPo = poDetails;


    }




}
