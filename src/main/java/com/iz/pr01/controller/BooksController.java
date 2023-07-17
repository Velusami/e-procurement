package com.iz.pr01.controller;

import java.util.List;

import com.iz.pr01.model.CartModel;
import com.iz.pr01.model.ResponseDTO;
import com.iz.pr01.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;

import com.iz.pr01.model.Books;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/book")
    private List<Books> getAllBooks(Books books) {
        return booksService.getAllBooks();
    }

    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid) {
        return booksService.getBooksById(bookid);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid) {
        booksService.delete(bookid);
    }

    //creating post mapping that post the book detail in the database
//    @PostMapping("/books")
//    private ResponseEntity<ResponseDTO> saveBook(@RequestBody Books books) {
//
//        ResponseDTO responseDTO = booksService.saveOrUpdate(books);
//
//        if (responseDTO.getStatus()) {
//            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/books")
    private int saveBook(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books.getBookId();
    }
    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books;
    }


}
