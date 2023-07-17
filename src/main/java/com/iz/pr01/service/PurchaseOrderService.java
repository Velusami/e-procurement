package com.iz.pr01.service;

import com.iz.pr01.model.*;
import com.iz.pr01.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    ItemService itemService;


    //PurchaseOrder service method:
    public ResponseDTO createPurchaseOrder(PurchaseOrder purchaseOrder) {

//        BigDecimal sum = BigDecimal.ZERO;
        ResponseDTO responseDTO = new ResponseDTO();
        if (purchaseOrder != null) {
            purchaseOrder.getCartLines().forEach(res -> {
                Item items = itemService.getItemById(res.getItemCode().getItemCode());
                res.setAmount(BigDecimal.valueOf(items.getPrice() * res.getQuantity()));

//                sum=sum.add(res.getAmount());
                res.setPrice(items.getPrice());
                res.setOrderId(purchaseOrder.getOrderId());


            });


            purchaseOrder.setSubTotal(purchaseOrder.getCartLines().stream().map(x -> BigDecimal.valueOf(x.getPrice() * x.getQuantity()))
                    .reduce(BigDecimal.ZERO, BigDecimal::add));


            purchaseOrder.setTaxAmount(purchaseOrder.getCartLines().stream().map(x -> BigDecimal.valueOf(x.getQuantity() * x.getPrice() * x.getTaxPercentage()).divide(BigDecimal.valueOf(100)))
                    .reduce(BigDecimal.ZERO, BigDecimal::add));

            purchaseOrder.setGrandTotal((purchaseOrder.getSubTotal().add(purchaseOrder.getTaxAmount())));
            purchaseOrder.setGrandTotal(purchaseOrder.getGrandTotal());


            purchaseOrderRepository.save(purchaseOrder);
            responseDTO.setMessage("Cart Created Successfully:");
            responseDTO.setStatus(true);
        } else {
            responseDTO.setMessage("Cart Creation is failed ! ItemId is Invalid:");
            responseDTO.setStatus(false);
        }

        return responseDTO;
    }


    public List<PurchaseOrder> getAllOrders() {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        purchaseOrderRepository.findAll().forEach(purchaseOrder -> purchaseOrders.add(purchaseOrder));
        return purchaseOrders;
    }

    public PurchaseOrder getPurchaseById(String id) {
//        return cartRepository.findById(id).orElse(null);
        return (PurchaseOrder) purchaseOrderRepository.findById(id).orElse(null);
    }

    public void delete(String id) {
        purchaseOrderRepository.deleteById(id);
    }


}
