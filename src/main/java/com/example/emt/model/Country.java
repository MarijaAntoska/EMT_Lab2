package com.example.emt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String continent;

    public Country(String name, String continent) {
        this.name = name;
        this.continent=continent;
    }
}
