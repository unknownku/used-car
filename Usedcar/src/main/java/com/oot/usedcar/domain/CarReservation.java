package com.oot.usedcar.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cars_reservation")
public class CarReservation {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String idCard;
    private String payMethod;
    private BigDecimal reservAmount;
    private Date reservDate;
    private String reservNo;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}