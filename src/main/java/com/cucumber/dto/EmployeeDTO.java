package com.cucumber.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class EmployeeDTO {

    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotNull
    //@JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-MM-dd")
    public String dateOfBirth;

    @NotNull
    //@JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-MM-dd")
    public String startDate;

    //@JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "yyyy-MM-dd")
    public String endDate;

    @NotEmpty
    private String employmentType;

    @NotEmpty
    private String email;

    @NotNull
    private List<PhoneDTO> phones;
}
