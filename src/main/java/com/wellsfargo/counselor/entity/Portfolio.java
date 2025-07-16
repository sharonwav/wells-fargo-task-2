package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private Long portfolioId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @Column(name = "createdAt", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "deletedAt", nullable = true)
    private LocalDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    protected Portfolio() {

    }

    public Portfolio(String name, String description, Client client) {
        this.name = name;
        this.description = description;
        this.client = client;
    }

    public Long getPortfolioId() { return portfolioId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Client getClient() {return client; }

    public void setClient(Client client) { this.client = client; }

}
