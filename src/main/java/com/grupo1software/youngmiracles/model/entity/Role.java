package com.grupo1software.youngmiracles.model.entity;

import com.grupo1software.youngmiracles.model.enums.ERole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name="name",nullable = false,unique = true)
    private ERole name;
}
