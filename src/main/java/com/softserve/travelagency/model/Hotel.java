package com.softserve.travelagency.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotels")
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9 ]",message = "Incorrect name")
    @Column(name = "name")
    private String name;

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9 ]")
    @Column(name = "country")
    private String country;

    @NotNull
    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?")
    @Column(name = "city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "hotel")
    private List<Room> rooms;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "hotel")
    private List<Order> orders;
}
