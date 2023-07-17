package com.iz.pr01.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@NoArgsConstructor
@Getter
@Setter
@Table(name = "purchasing_order")
@Entity
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "order_id",nullable = false)
    private String orderId;
//

    //sum of line Quantity * line price
    @Column(name = "sub_total")
    private BigDecimal subTotal=BigDecimal.ZERO;
    @Column(name = "tax_amount")
    private BigDecimal taxAmount=BigDecimal.ZERO;
    //sum of subTotal and tax amount=grandTotal
    @Column(name = "grand_total")
    private BigDecimal grandTotal=BigDecimal.ZERO;

    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL)
    private List<CartLine> cartLines;

    private List<PurchaseOrderItem> purchaseOrderItems;




}
