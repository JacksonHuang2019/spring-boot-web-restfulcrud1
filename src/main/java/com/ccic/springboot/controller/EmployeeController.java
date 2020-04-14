package com.ccic.springboot.controller;

import com.ccic.springboot.dao.DepartmentDao;
import com.ccic.springboot.dao.EmployeeDao;

import com.ccic.springboot.entities.Department;
import com.ccic.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping(value = "/emps")
    public String getEmps(Model model) {
        Collection<Employee> emps = employeeDao.getAll();

        model.addAttribute("emps", emps);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 来到添加页面
        //  查出所有的部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
//        System.out.println(employee);

        // 重定向到一个地址 redirect
        //妆发到一个地址  forward
        return "redirect:emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        // 页面显示所有的部门列表
        //  查出所有的部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);

        //


        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        // add页面是修改添加二合一
        return "emp/add";
    }

    @PutMapping("/emp")
    public String UpdateEmployee(Employee employee) {
        Employee employee1 = employeeDao.get(employee.getId());
        employeeDao.save(employee);
        return "redirect:emps";
    }

    @DeleteMapping("emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);

        return "emp/emps";
    }


}
