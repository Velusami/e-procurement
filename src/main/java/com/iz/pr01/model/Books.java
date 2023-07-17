package com.iz.pr01.model;



import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
@lombok.Getter
@Setter
public class Books {

    //Defining book id as primary key
    @Id
    @Column(name = "bookid")
    private int bookId;
    @Column(name = "bookname")
    private String bookName;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private int price;


}
