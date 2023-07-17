package com.iz.pr01.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.iz.pr01.model.ResponseDTO;
import com.iz.pr01.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iz.pr01.model.Books;

@Service
public class BooksService {

    //defining the business logic


        @Autowired
        BooksRepository booksRepository;

        //getting all books record by using the method findaAll() of CrudRepository
        public List<Books> getAllBooks() {
            List<Books> books = new ArrayList<Books>();
            booksRepository.findAll().forEach(books1 -> books.add(books1));
            return books;
        }


        public Books getBooksById(int id){
            Optional<Books> books=booksRepository.findById(id);
            if (books.isPresent()){
                return books.get();
            }else {
                return null;
            }
        }

        //saving a specific record by using the method save() of CrudRepository
        public void saveOrUpdate(Books books) {

            booksRepository.save(books);

        }

        //deleting a specific record by using the method deleteById() of CrudRepository
        public void delete(int id) {
            booksRepository.deleteById(id);
        }

        //updating a record
        public void update(Books books, int bookid) {
        booksRepository.save(books);
    }

    }
