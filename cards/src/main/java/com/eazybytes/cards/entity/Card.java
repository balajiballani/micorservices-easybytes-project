package com.eazybytes.cards.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Card")
public class Card extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String cardNumber;
    private String cardType;
    private String mobileNumber;
    private double totalLimit;
    private double amountUsed;
    private double availableAmount;
}
