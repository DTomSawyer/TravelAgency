package com.softserve.travelagency.model;

import com.softserve.travelagency.model.util.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "number")
    private Integer number;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @NotNull
    @Column(name = "price")
    private Double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(//cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "room")
    private List<Order> orders;
}
