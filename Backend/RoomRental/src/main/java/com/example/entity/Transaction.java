package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Transaction")
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Landlord owner;  // Owner initiating the transaction

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;  // Tenant participating in the transaction

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Property room;

    @Column(nullable = false)
    private double paymentAmount;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;
}
