package com.iz.pr01.controller;

import com.iz.pr01.model.CartLine;
import com.iz.pr01.model.CartModel;
import com.iz.pr01.model.PurchaseOrder;
import com.iz.pr01.model.ResponseDTO;
import com.iz.pr01.repository.CartRepository;
import com.iz.pr01.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/cart")
@RestController
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    CartRepository cartRepository;

    @GetMapping("/book/search/{search}")
    public ResponseEntity<List<CartModel>> getUserByStatus(@RequestParam String bookname) {
        return new ResponseEntity<>(cartService.userGetServByStatus(bookname), HttpStatus.OK);
    }

    @GetMapping("/book/search/{bookid}")
    public ResponseEntity<List<CartModel>> getBookId(@RequestParam Integer bookid) {
        return new ResponseEntity<>(cartService.gettingBookId(bookid), HttpStatus.OK);
    }
    @GetMapping(value = "bookspagination")

    public ResponseEntity<List<CartModel>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(defaultValue = "bookid") String sortBy) {
        List<CartModel> list = cartService.getAllBooks(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<CartModel>>(list, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping("/book")
    private List<CartModel> getAllBooks() {
        return cartService.getAllBooks();
    }

    @GetMapping("/book/{bookid}")
    private CartModel getBooks(@PathVariable("bookid") int bookid) {
        return cartService.getBooksById(bookid);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid) {
        cartService.delete(bookid);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private ResponseEntity<ResponseDTO> saveBook(@RequestBody CartModel books) {

        ResponseDTO responseDTO = cartService.saveOrUpdate(books);

        if (responseDTO.getStatus()) {
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }
    }

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private CartModel update(@RequestBody CartModel books) {
        cartService.saveOrUpdate(books);
        return books;
    }




}
