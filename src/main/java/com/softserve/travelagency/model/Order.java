package com.softserve.travelagency.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @NotNull
    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @NotNull
    @Column(name = "departure_date")
    private LocalDate departureDate;

    @NotNull
    @Column(name = "order_date")
    private LocalDateTime orderDate;

}
