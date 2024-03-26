package com.codegym.hue.thithuchanhmd4.service;

import com.codegym.hue.thithuchanhmd4.model.StaffType;
import com.codegym.hue.thithuchanhmd4.repository.IStaffTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StaffTypeService implements IStaffTypeService{
    private final IStaffTypeRepository staffTypeRepository;

    @Override
    public List<StaffType> getAllStaffType() {
        return staffTypeRepository.findAll();
    }

}
