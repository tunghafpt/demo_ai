package com.vietsoftware.demo_ai.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
}
