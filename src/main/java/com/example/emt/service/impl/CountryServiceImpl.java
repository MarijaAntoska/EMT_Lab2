package com.example.emt.service.impl;

import com.example.emt.model.Country;
import com.example.emt.repository.CountryRepository;
import com.example.emt.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country create(Country country) {

        return repository.save(country);

    }
}
