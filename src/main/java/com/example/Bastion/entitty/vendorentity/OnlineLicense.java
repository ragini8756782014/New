package com.example.Bastion.entitty.vendorentity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bi_api_tbl_online_licenses")
public class OnlineLicense {

@Id
private int id;

private String licenseKey;

private String user_name;

private String user_email_id;

private String mobile_no;

private String user_address;

}
