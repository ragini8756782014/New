package com.example.Bastion.service;
import com.example.Bastion.Repository.crmrepo.OnlineActivationRepository;
import com.example.Bastion.Repository.crmrepo.UserInfoRepository;
import com.example.Bastion.Repository.vendorrepo.OnlineLicenseRepository;
import com.example.Bastion.entitty.crmentity.OnlineActivation;
import com.example.Bastion.entitty.crmentity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BastionService {

    @Autowired
    private OnlineLicenseRepository onlineLicenseRepository ;

    @Autowired
    private OnlineActivationRepository onlineActivationRepository;

    @Autowired
    private  UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<?> getAll() {
        return onlineActivationRepository.fetchBastionDtoLeftJoin();
    }

    public OnlineActivation getLicense(String licenseKey){
        return  onlineActivationRepository.findByLicenseKey(licenseKey);
    }

    public void updateSystemCount(OnlineActivation onlineActivation,String licenseKey){
        onlineActivationRepository.save(onlineActivation);
    }

    public void deleteEntry(String license_key){
        onlineLicenseRepository.findByLicenseKey(license_key);
    }

    public List<OnlineActivation> getAllBook()
    {
        return  onlineActivationRepository.findAll();
    }

    public String addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userInfoRepository.save(user);
        return "user added to db ";
    }

}
