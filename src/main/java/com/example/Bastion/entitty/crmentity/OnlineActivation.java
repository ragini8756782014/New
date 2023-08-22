package com.example.Bastion.entitty.crmentity;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bi_api_tbl_online_activation")
public class OnlineActivation {

    @Id
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "licenseKey", nullable = false)
    private String licenseKey;

    @Column(name = "inv_id_fk"  )
    private String  inv_id_fk;

    @Column(name = " system_count", columnDefinition = "varchar(255) default '2'")
    private String  system_count;

    @Column(name = "status")
    private String status;

    @Column(name = "os")
    private String   os;

    @Column(name = "expiry_date")
    private String expiry_date;

    @Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String create_date;


}
