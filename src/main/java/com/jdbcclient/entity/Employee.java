package com.jdbcclient.entity;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String dob;

}
