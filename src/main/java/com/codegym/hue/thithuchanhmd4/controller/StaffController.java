package com.codegym.hue.thithuchanhmd4.controller;

import com.codegym.hue.thithuchanhmd4.model.Staff;
import com.codegym.hue.thithuchanhmd4.service.IStaffService;
import com.codegym.hue.thithuchanhmd4.service.IStaffTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("staff")
@AllArgsConstructor
public class StaffController {
    private final IStaffService staffService;
    private final IStaffTypeService staffTypeService;

    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "") String search) {
        return new ModelAndView("index")
                .addObject("listStaff", staffService.getAllStaffBy(search))
                .addObject(search);
    }

    @GetMapping("/add")
    public ModelAndView showFormCreate() {
        return new ModelAndView("add")
                .addObject("listStaffType", staffTypeService.getAllStaffType())
                .addObject("staff", new Staff());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        return new ModelAndView("update")
                .addObject("staff", staffService.getDetailStaffBy(id))
                .addObject("listStaffType", staffTypeService.getAllStaffType());
    }

    @PostMapping("/add")
    public String addStaff(@ModelAttribute @Valid Staff staff, RedirectAttributes redirectAttributes) {
        staffService.save(staff);
        redirectAttributes.addFlashAttribute("success", "Thêm mới nhân viên thành công!!");
        return "redirect:/staff";
    }

    @PostMapping("/edit/{id}")
    public String updateStaff(@PathVariable Long id, @ModelAttribute @Valid Staff staff, RedirectAttributes redirectAttributes) {
        staff.setId(id);
        staffService.save(staff);
        redirectAttributes.addFlashAttribute("success", "Sửa thông tin nhân viên thành công!");
        return "redirect:/staff";
    }

    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Long id, RedirectAttributes redirectAttributes) throws Exception {
        staffService.deletedBy(id);
        redirectAttributes.addFlashAttribute("success", "Xóa nhân viên thành công!");
        return "redirect:/staff";
    }
}
