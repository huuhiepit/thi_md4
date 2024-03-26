package com.codegym.hue.thithuchanhmd4.service;

import com.codegym.hue.thithuchanhmd4.model.Staff;

import java.util.List;

public interface IStaffService {
    List<Staff> getAllStaff();
    List<Staff> getAllStaffBy(String search);
    Staff getDetailStaffBy(Long id);
    void save(Staff staff);
    void deletedBy(Long id) throws Exception;

}
