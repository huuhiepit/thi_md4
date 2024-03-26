package com.codegym.hue.thithuchanhmd4.repository;

import com.codegym.hue.thithuchanhmd4.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findAllByNameContainingIgnoreCaseOrIdStaffContaining(String name, String idStaff);
}
