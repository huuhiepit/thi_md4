package com.codegym.hue.thithuchanhmd4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "staff_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "staffType", fetch = FetchType.LAZY)
    private List<Staff> staff;
}
