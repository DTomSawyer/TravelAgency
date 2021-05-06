package com.softserve.travelagency.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_rooms",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Room> rooms;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "arrival_date")
    private Date arrivalDate;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "departure_date")
    private Date departureDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private Date orderDate;
}
