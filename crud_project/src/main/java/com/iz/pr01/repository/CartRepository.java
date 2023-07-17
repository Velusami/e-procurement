package com.iz.pr01.repository;

import com.iz.pr01.model.CartModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<CartModel, Integer> {

    @Query(value = "SELECT * from purchaseorderr ud where ud.bookname=?1", nativeQuery = true)
    public List<CartModel> getUserByStatus(String bookname);
    @Query(value = "SELECT * from purchaseorderr ud where ud.bookid=?1", nativeQuery = true)
    public  List<CartModel> getBookId(Integer bookid);


}
