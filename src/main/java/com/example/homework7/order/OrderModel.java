package com.example.homework7.order;



import com.example.homework7.customer.CustomerModel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="order")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private long timestamp;

    @ManyToOne
    public CustomerModel customers;

   // @ManyToOne
    //public List<Product> products;
}