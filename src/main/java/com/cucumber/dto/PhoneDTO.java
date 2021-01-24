package com.cucumber.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PhoneDTO {

    @NotNull
    private Long id;

    @NotEmpty
    private String type;

    @NotEmpty
    private String isdCode;

    @NotEmpty
    private String phoneNumber;

    private String extension;
}
