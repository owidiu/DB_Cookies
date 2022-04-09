package com.example.homework7.product;

import com.example.homework7.order.OrderModel;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private int price;
    private String description;

    @OneToMany
    public List<OrderModel> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}