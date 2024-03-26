package com.codegym.hue.thithuchanhmd4.service;

import com.codegym.hue.thithuchanhmd4.model.Staff;
import com.codegym.hue.thithuchanhmd4.repository.IStaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StaffService implements IStaffService {
    private final IStaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public List<Staff> getAllStaffBy(String search) {
        return staffRepository.findAllByNameContainingIgnoreCaseOrIdStaffContaining(search, search);
    }

    @Override
    public Staff getDetailStaffBy(Long id) {
        return staffRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No employee not found."));
    }

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void deletedBy(Long id) throws Exception{
        try {
            staffRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Không thể xóa dữ liệu của nhân viên: " + e.getMessage());
        }
    }
}
