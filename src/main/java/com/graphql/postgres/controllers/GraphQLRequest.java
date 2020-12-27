package com.graphql.postgres.controllers;

import lombok.Data;

import java.util.Map;

@Data
public class GraphQLRequest {

    private String query;
    private Map<String, Object> variables;

}
