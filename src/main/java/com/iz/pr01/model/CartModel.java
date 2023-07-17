package com.iz.pr01.model;

        import lombok.Getter;
        import lombok.Setter;

        import javax.persistence.*;

@Entity(name = "purchaseorderr")
@Table(name = "purchaseorderr")
@Getter
@Setter
public class CartModel {


    @Id
    @Column(name = "orderid")
    private int orderid;
    @Column(name = "bookid")
    private int bookid;
    @Column(name = "bookname")
    private String bookname;
    @Column(name = "price")
    private int price;
    @Column(name = "orderedby")
    private String ordered_by;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "amount")
    private int amount;


//    //    @ManyToOne
////    @JoinColumn (name = "book_id")
////    private Books book_id;

}
