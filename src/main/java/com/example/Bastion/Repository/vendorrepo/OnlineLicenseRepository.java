package com.example.Bastion.Repository.vendorrepo;

import com.example.Bastion.entitty.crmentity.OnlineActivation;
import com.example.Bastion.entitty.vendorentity.OnlineLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineLicenseRepository extends JpaRepository<OnlineLicense, Long> {

    public OnlineLicense findByLicenseKey(String licenseKey);

}