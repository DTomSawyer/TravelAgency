package com.softserve.travelagency.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "hotel")
public class HotelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?")
    @Column(name = "name")
    private String name;

    @NotNull
    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?")
    @Column(name = "country")
    private String country;

    @NotNull
    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?")
    @Column(name = "city")
    private String city;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "hotel")
    private List<RoomModel> rooms;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "hotel")
    private List<OrderModel> orders;
}
