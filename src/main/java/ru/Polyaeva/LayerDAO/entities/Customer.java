package ru.Polyaeva.LayerDAO.entities;


import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "customers")
@IdClass(String.class)
public class Customer {
    @Id
    @Column
    public String name;

    @Id
    @Column
    public String surname;

    @Id
    @Column
    public int age;

    @Column
    public String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
}