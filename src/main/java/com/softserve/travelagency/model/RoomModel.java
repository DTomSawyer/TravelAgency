package com.softserve.travelagency.model;

import com.softserve.travelagency.model.util.RoomType;
import jakarta.validation.constraints.NotNull;
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
@Entity(name = "room")
public class RoomModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private RoomType type;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelModel hotel;

    @ManyToMany(mappedBy = "projects")
    private List<OrderModel> orders;
}
