package com.example.Bastion.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BastionDto {

    private String licenseKey;

    private String Inv_id_fk;

    private String  system_count;

    private String status;

    private String os;

    private String create_date;

    private String expiry_date;

    private String user_name;

    private String user_email_id;

    private String mobile_no;

    private String user_address;
}
