package com.eazybytes.cards.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Card")
public class Card extends BaseEntity{
    @Column(unique = true,nullable = false)
    private String cardNumber;
    @Column(unique = true,nullable = false)
    private String name;
    private Date expiryDate;
    private String securityCode;
}
