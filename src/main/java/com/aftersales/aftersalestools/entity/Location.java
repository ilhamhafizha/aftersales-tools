package com.aftersales.aftersalestools.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "locations")
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String code;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Location parent;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}

