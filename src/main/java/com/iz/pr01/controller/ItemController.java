package com.iz.pr01.controller;

import com.iz.pr01.model.CartModel;
import com.iz.pr01.model.Item;
import com.iz.pr01.model.ResponseDTO;
import com.iz.pr01.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Item")
@RestController
public class ItemController {
    @Autowired
    ItemService itemService;
    @GetMapping("/item")
    private List<Item> getAllItem() {
        return itemService.getAllItem();
    }

    @GetMapping("/item/{itemid}")
    private Item getItemById(@PathVariable("itemid") String itemid) {
        return itemService.getItemById(itemid);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/item/{itemid}")
    private void deleteBook(@PathVariable("itemid") String itemid) {
        itemService.delete(itemid);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/items")
    private ResponseEntity<ResponseDTO> saveItem(@RequestBody Item items) {

        ResponseDTO responseDTO = itemService.saveOrUpdate(items);

        if (responseDTO.getStatus()) {
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }
    }

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Item update(@RequestBody Item Items) {
        itemService.saveOrUpdate(Items);
        return Items;
    }



}
