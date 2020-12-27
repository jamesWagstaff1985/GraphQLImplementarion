package com.graphql.postgres.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Product extends BaseEntity {

    private String name;
    private Float price;

    @ManyToOne
    private Warehouse warehouse;

}
