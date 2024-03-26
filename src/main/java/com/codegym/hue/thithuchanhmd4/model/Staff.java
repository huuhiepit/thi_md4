package com.codegym.hue.thithuchanhmd4.model;

import com.codegym.hue.thithuchanhmd4.model.enumeration.EGender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity(name = "staffs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee ID cannot be left blank.")
    private String idStaff;

    @ManyToOne
    private StaffType staffType;

    @NotBlank(message = "Employee name cannot be left blank.")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @NotNull(message = "Employee gender cannot be left blank.")
    @Enumerated(EnumType.STRING)
    private EGender gender;

    @NotBlank(message = "Employee phone cannot be left blank.")
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid phone")
    private String phone;

    @NotBlank(message = "Employee number CMND cannot be left blank.")
    private String cmnd;

    @NotBlank(message = "Employee email cannot be left blank.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email")
    private String email;

    @NotBlank(message = "Employee address cannot be left blank.")
    private String address;
}
