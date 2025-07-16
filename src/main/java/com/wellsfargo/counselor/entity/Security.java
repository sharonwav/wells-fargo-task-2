package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;
import java.math.BigDecimal;


@Entity
public class Security {

    @Id
    @GeneratedValue()
    private Long securityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(name = "purchaseDate", nullable = false)
    private LocalDateTime purchaseDate;

    @Column(name = "purchasePrice", nullable = false)
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "portfolioId")
    private Portfolio portfolio;

    @Column(name = "createdAt", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "deletedAt", nullable = true)
    private LocalDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    protected Security() {

    }

    public Security(String name, String category, LocalDateTime purchaseDate, BigDecimal purchasePrice, int quantity, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    public Long getSecurityId() { return securityId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public LocalDateTime getPurchaseDate() { return purchaseDate; }

    public void setPurchaseDate(LocalDateTime purchaseDate) { this.purchaseDate = purchaseDate; }

    public BigDecimal getPurchasePrice() { return purchasePrice; }

    public void setPurchasePrice(BigDecimal purchasePrice) { this.purchasePrice = purchasePrice; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Portfolio getPortfolio() { return portfolio; }

    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
