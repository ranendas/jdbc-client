package com.jdbcclient.controller;

import com.jdbcclient.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdbcclient")
public class JdbcController {

    @Autowired
    private JdbcClient jdbcClient;

    @PostMapping("/add")
    public String addNewEmployee(@RequestBody Employee employee){
        try {
            int i = jdbcClient.sql("INSERT INTO employee(id, firstName, lastName, dob) values(:id, :firstName, " +
                            ":lastName, :dob)")
                    .param("id", employee.getId())
                    .param("firstName", employee.getFirstName())
                    .param("lastName", employee.getLastName())
                    .param("dob", employee.getDob())
                    .update();
            System.out.println("return type of update == " + i);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Successfully updated";
    }

    @GetMapping("/all")
    public List<Employee> getAll(){
        return jdbcClient.sql("SELECT id, firstName, lastName, dob from employee")
                .query(Employee.class).list();
    }

}
