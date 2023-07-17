package com.iz.pr01.controller;

import com.iz.pr01.model.PurchaseOrder;
import com.iz.pr01.model.ResponseDTO;
import com.iz.pr01.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/purchaseOrder")
@RestController
public class PurchaseOrderController {
    @Autowired
    PurchaseOrderService purchaseOrderService;


    @GetMapping("/purchase")
    private List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getAllOrders();
    }

    @GetMapping("/purchase/{purchase_Id}")
    private PurchaseOrder getPurchaseOrder(@PathVariable("purchase_Id") String id) {
        return purchaseOrderService.getPurchaseById(id);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/purchase/{purchase_Id}")
    private void deleteBook(@PathVariable("purchase_Id") String itemid) {
        purchaseOrderService.delete(itemid);
    }
    //Cart_line postmapping url:
    @PostMapping("/purchaseorder")
    private ResponseEntity<ResponseDTO> savePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {

        ResponseDTO responseDTO = purchaseOrderService.createPurchaseOrder(purchaseOrder);;

        if (responseDTO.getStatus()) {
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }
    }
}
