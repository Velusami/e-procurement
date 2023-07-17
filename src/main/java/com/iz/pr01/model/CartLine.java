package com.iz.pr01.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "cart_line")
@Entity

public class CartLine {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "line_id"    ,nullable = false)
    private int lineId;
    @ManyToOne
    @JoinColumn(name = "item_code")
    private Item itemCode;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private int price;
    //Quantity*Price=Amount
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "tax_percentage")
    private int taxPercentage;


}
