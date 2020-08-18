package com.capricove.capricove.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "capriapp")
public class OrderDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int orderId;

    @Column
    private String username;

    @Column
    private String orderType;


}
