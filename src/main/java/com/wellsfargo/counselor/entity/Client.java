package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Client {

    @Id
    @GeneratedValue()
    private Long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "advisorId")
    private Advisor advisor;

    @Column(name = "createdAt", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "deleteAt", nullable = true)
    private LocalDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    protected Client() {

    }

    public Client(String firstName, String lastName, String address, String phone, String email, Advisor advisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.advisor = advisor;
    }

    public Long getClientId() { return clientId; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Advisor getAdvisor() { return advisor; }

    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }
}
