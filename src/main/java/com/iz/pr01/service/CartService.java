package com.iz.pr01.service;

import com.iz.pr01.model.*;
import com.iz.pr01.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    BooksService booksService;

    public List<CartModel> getAllBooks() {
        List<CartModel> cart = new ArrayList<>();
        cartRepository.findAll().forEach(books1 -> cart.add(books1));
        return cart;
    }

    public CartModel getBooksById(int id) {
//        return cartRepository.findById(id).orElse(null);
        return (CartModel) cartRepository.findById(id).orElse(null);
    }

    public ResponseDTO saveOrUpdate(CartModel cart) {
//        Books books1 = booksService.getBooksById(cart.getBook_id().getBookId());
        Books books1 = booksService.getBooksById(cart.getBookid());
        ResponseDTO responseDTO = new ResponseDTO();
        if (books1 != null) {
            cart.setAmount(cart.getQuantity() * books1.getPrice());
            cart.setPrice(books1.getPrice());
            cartRepository.save(cart);
            responseDTO.setMessage("Cart Created Successfully:");
            responseDTO.setStatus(true);
        } else {

            responseDTO.setMessage("Cart Creation is failed ! bookId is Invalid:");
            responseDTO.setStatus(false);

        }

        return responseDTO;
    }


//        cartLine.setAmount(cartLine.getQuantity().multiply(cartLine.getPrice()));


    public void delete(int id) {
        cartRepository.deleteById(id);
    }

    public void update(CartModel cart, int bookid) {
        cartRepository.save(cart);
    }

    public List<CartModel> userGetServByStatus(String bookname) {
        return cartRepository.getUserByStatus(bookname);
    }

    public List<CartModel> gettingBookId(Integer bookid) {
        return cartRepository.getBookId(bookid);
    }


    public List<CartModel> getAllBooks(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<CartModel> pageResult = cartRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<CartModel>();
        }
    }

}
