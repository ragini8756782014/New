package com.example.Bastion.Repository.crmrepo;
import com.example.Bastion.dto.BastionDto;
import com.example.Bastion.entitty.crmentity.OnlineActivation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OnlineActivationRepository extends JpaRepository<OnlineActivation, Long> {

    public OnlineActivation findByLicenseKey(String licenseKey);

    @Query(value = "SELECT u.licenseKey, u.Inv_id_fk, u.system_count, u.status, u.os, u.create_date, u.expiry_date, " +
            "a.user_name, a.user_email_id, a.user_address, a.mobile_no " +
            "FROM bi_crm_database.bi_api_tbl_online_activation u " +
            "LEFT JOIN bi_vendor_database.bi_api_tbl_online_licenses a ON u.licenseKey = a.licenseKey",
            nativeQuery = true)
    List<?> fetchBastionDtoLeftJoin();





}
