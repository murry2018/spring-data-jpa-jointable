package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository
    extends CrudRepository<Phone, Long> {

    List<Phone> findByModelName(String modelName);

    List<Phone> findByVendor(String vendor);
    
}
