package com.softserve.travelagency.model;

import com.softserve.travelagency.model.util.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true, name = "email")
    private String email;

    @NotNull
    @Pattern(regexp = "[1-9A-Za-z!%@*]{8,20}", message = "Invalid password!")
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?")
    @Column(name = "first_name")
    private String firstName;

    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?")
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "user")
    private List<Order> orders;
}
