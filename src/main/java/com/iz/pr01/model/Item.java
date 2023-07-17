package com.iz.pr01.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@JsonIgnoreProperties({"hibernateLazyInitilizer","handler"})
@NoArgsConstructor
@Getter
@Setter
@Table(name = "items")
@Entity
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "item_code",nullable = false)
    private String itemCode;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "price")
    private int price;
    @Column(name = "tax")
    private int tax;
}
