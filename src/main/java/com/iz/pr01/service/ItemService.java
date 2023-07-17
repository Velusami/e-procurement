package com.iz.pr01.service;

import com.iz.pr01.model.Item;
import com.iz.pr01.model.ResponseDTO;
import com.iz.pr01.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {


    @Autowired
    ItemRepository itemRepository;
    //getting all books record by using the method findaAll() of CrudRepository
    public List<Item> getAllItem() {
        List<Item> items = new ArrayList<Item>();
        itemRepository.findAll().forEach(item1 -> items.add(item1));
        return items;
    }


    public Item getItemById(String id){
//        Optional<Item> item=itemRepository.findById(id);
//        if (item.isPresent()){
//            return item.get();
//        }else {
//            return null;
//        }

        return (Item) itemRepository.findById(id).orElse(null);
    }

    //saving a specific record by using the method save() of CrudRepository
    public ResponseDTO saveOrUpdate(Item item) {
        ResponseDTO responseDTO = new ResponseDTO();

        if (item != null) {
//                  cartLine.setAmount(cartLine.getQuantity().multiply(cartLine.getPrice()));



            itemRepository.save(item);
            responseDTO.setMessage("Cart Created Successfully:");
            responseDTO.setStatus(true);
        } else {
            responseDTO.setMessage("Cart Creation is failed ! bookId is Invalid:");
            responseDTO.setStatus(false);
        }

//        return ResponseDTO;
        return responseDTO;
    }


    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(String id) {
        itemRepository.deleteById(id);
    }

    //updating a record
    public void update(Item item, int itemid) {
        itemRepository.save(item);
    }

}
