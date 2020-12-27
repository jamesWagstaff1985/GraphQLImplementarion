package com.graphql.postgres.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Warehouse extends BaseEntity {

    private String aisle;

    @OneToMany(mappedBy = "warehouse")
    private Set<Product> products = new HashSet<>();

}
